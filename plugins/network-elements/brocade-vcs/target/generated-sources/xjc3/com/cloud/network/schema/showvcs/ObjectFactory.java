//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.04.29 at 05:02:19 PM MESZ 
//


package com.cloud.network.schema.showvcs;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cloud.network.schema.showvcs package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cloud.network.schema.showvcs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NodePublicIpv6Addresses }
     * 
     */
    public NodePublicIpv6Addresses createNodePublicIpv6Addresses() {
        return new NodePublicIpv6Addresses();
    }

    /**
     * Create an instance of {@link VcsNodes }
     * 
     */
    public VcsNodes createVcsNodes() {
        return new VcsNodes();
    }

    /**
     * Create an instance of {@link Output }
     * 
     */
    public Output createOutput() {
        return new Output();
    }

    /**
     * Create an instance of {@link NodePublicIpAddresses }
     * 
     */
    public NodePublicIpAddresses createNodePublicIpAddresses() {
        return new NodePublicIpAddresses();
    }

    /**
     * Create an instance of {@link VcsNodeInfo }
     * 
     */
    public VcsNodeInfo createVcsNodeInfo() {
        return new VcsNodeInfo();
    }

}