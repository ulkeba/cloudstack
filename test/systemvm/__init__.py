# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.

from vagrant import Vagrant
from unittest import TestCase
from paramiko.config import SSHConfig
from paramiko.client import SSHClient, AutoAddPolicy
from fabric.api import env
from envassert import file, detect

from StringIO import StringIO

from nose.plugins.attrib import attr

import os.path


_defaultVagrantDir = os.path.abspath(os.path.join(
    os.path.basename(__file__), '..', '..', '..', 'tools', 'vagrant', 'systemvm'))


class SystemVM(object):
    def __init__(self,
                 host='default',
                 vagrantDir=None,
                 controlVagrant=True):
        global _defaultVagrantDir
        self.host = host
        self._controlVagrant = controlVagrant
        if vagrantDir is None:
            vagrantDir = _defaultVagrantDir
        self._vagrant = Vagrant(root=vagrantDir)
        self._startedVagrant = False
        self._sshClient = None
        self._sshConfigStr = None
        self._sshConfig = None
        self._sshHostConfig = None

    def maybeUp(self):
        if not self._controlVagrant:
            return
        state = self._vagrant.status(vm_name=self.host)[0].state
        if state == Vagrant.NOT_CREATED:
            self._vagrant.up(vm_name=self.host)
            self._startedVagrant = True
        elif state in [Vagrant.POWEROFF, Vagrant.SAVED, Vagrant.ABORTED]:
            raise Exception(
                "SystemVM testing does not support resume(), do not use vagrant suspend/halt")
        elif state == Vagrant.RUNNING:
            self._startedVagrant = False
        else:
            raise Exception("Unrecognized vagrant state %s" % state)

    def maybeDestroy(self):
        if not self._controlVagrant or not self._startedVagrant:
            return
        self._vagrant.destroy(vm_name=self.host)
        if self._sshClient is not None:
            self._sshClient.close()

    def loadSshConfig(self):
        if self._sshConfig is None:
            self._sshConfigStr = self._vagrant.ssh_config(vm_name=self.host)
            configObj = StringIO(self._sshConfigStr)
            self._sshConfig = SSHConfig()
            # noinspection PyTypeChecker
            self._sshConfig.parse(configObj)
            self._sshHostConfig = self._sshConfig.lookup(self.host)

    @property
    def sshConfig(self):
        if self._sshConfig is None:
            self.loadSshConfig()
        return self._sshConfig

    @property
    def sshConfigStr(self):
        if self._sshConfigStr is None:
            self.loadSshConfig()
        return self._sshConfigStr

    @property
    def sshClient(self):
        if self._sshClient is None:
            self.loadSshConfig()
            self._sshClient = SSHClient()
            self._sshClient.set_missing_host_key_policy(AutoAddPolicy())
            self._sshClient.connect(self.hostname, self.sshPort, self.sshUser,
                                    key_filename=self.sshKey, timeout=10)
        return self._sshClient

    @property
    def hostname(self):
        return self._sshHostConfig.get('hostname', self.host)

    @property
    def sshPort(self):
        return int(self._sshHostConfig.get('port', 22))

    @property
    def sshUser(self):
        return self._sshHostConfig.get('user', 'root')

    @property
    def sshKey(self):
        return self._sshHostConfig.get('identityfile', '~/.ssh/id_rsa')


class SystemVMTestCase(TestCase):
    @classmethod
    def setUpClass(cls):
        cls.systemvm = SystemVM()
        cls.systemvm.maybeUp()

    @classmethod
    def tearDownClass(cls):
        # noinspection PyUnresolvedReferences
        cls.systemvm.maybeDestroy()

    def setUp(self):
        self.sshClient = self.systemvm.sshClient
        # self._env_host_string_orig = env.host_string
        env.host_string = "%s:%s" % (self.systemvm.hostname, self.systemvm.sshPort)
        env.user = self.systemvm.sshUser
        env.port = self.systemvm.sshPort
        env.key_filename = self.systemvm.sshKey
        env.use_ssh_config = True
        env.abort_on_prompts = True
        env.command_timeout = 10
        env.timeout = 5
        env.platform_family = detect.detect()

        # this could break down when executing multiple test cases in parallel in the same python process
        # def tearDown(self):
        #     env.host_string = self._env_host_string_orig
