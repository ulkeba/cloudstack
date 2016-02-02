//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.29 at 05:02:19 PM MESZ 
//


package com.cloud.network.schema.portprofile;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cloud.network.schema.portprofile package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cloud.network.schema.portprofile
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PortProfile.Static }
     * 
     */
    public PortProfile.Static createPortProfileStatic() {
        return new PortProfile.Static();
    }

    /**
     * Create an instance of {@link PortProfileGlobal }
     * 
     */
    public PortProfileGlobal createPortProfileGlobal() {
        return new PortProfileGlobal();
    }

    /**
     * Create an instance of {@link VlanProfile.SwitchportBasic.Basic }
     * 
     */
    public VlanProfile.SwitchportBasic.Basic createVlanProfileSwitchportBasicBasic() {
        return new VlanProfile.SwitchportBasic.Basic();
    }

    /**
     * Create an instance of {@link VlanProfile.Switchport.Trunk }
     * 
     */
    public VlanProfile.Switchport.Trunk createVlanProfileSwitchportTrunk() {
        return new VlanProfile.Switchport.Trunk();
    }

    /**
     * Create an instance of {@link VlanProfile.Switchport.Trunk.Allowed.Vlan }
     * 
     */
    public VlanProfile.Switchport.Trunk.Allowed.Vlan createVlanProfileSwitchportTrunkAllowedVlan() {
        return new VlanProfile.Switchport.Trunk.Allowed.Vlan();
    }

    /**
     * Create an instance of {@link VlanProfile.Switchport }
     * 
     */
    public VlanProfile.Switchport createVlanProfileSwitchport() {
        return new VlanProfile.Switchport();
    }

    /**
     * Create an instance of {@link VlanProfile.Switchport.Trunk.Allowed }
     * 
     */
    public VlanProfile.Switchport.Trunk.Allowed createVlanProfileSwitchportTrunkAllowed() {
        return new VlanProfile.Switchport.Trunk.Allowed();
    }

    /**
     * Create an instance of {@link PortProfile }
     * 
     */
    public PortProfile createPortProfile() {
        return new PortProfile();
    }

    /**
     * Create an instance of {@link PortProfile.Activate }
     * 
     */
    public PortProfile.Activate createPortProfileActivate() {
        return new PortProfile.Activate();
    }

    /**
     * Create an instance of {@link VlanProfile.SwitchportBasic }
     * 
     */
    public VlanProfile.SwitchportBasic createVlanProfileSwitchportBasic() {
        return new VlanProfile.SwitchportBasic();
    }

    /**
     * Create an instance of {@link VlanProfile.Switchport.Mode }
     * 
     */
    public VlanProfile.Switchport.Mode createVlanProfileSwitchportMode() {
        return new VlanProfile.Switchport.Mode();
    }

    /**
     * Create an instance of {@link VlanProfile }
     * 
     */
    public VlanProfile createVlanProfile() {
        return new VlanProfile();
    }

}
