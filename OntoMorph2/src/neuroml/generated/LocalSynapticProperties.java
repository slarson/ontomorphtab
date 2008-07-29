//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.07.28 at 11:54:05 PM PDT 
//


package neuroml.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Variables specifying a single synapse
 * 
 * <p>Java class for LocalSynapticProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocalSynapticProperties">
 *   &lt;complexContent>
 *     &lt;extension base="{http://morphml.org/networkml/schema}SynapseInternalProperties">
 *       &lt;attribute name="synapse_type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocalSynapticProperties", namespace = "http://morphml.org/networkml/schema")
public class LocalSynapticProperties
    extends SynapseInternalProperties
{

    @XmlAttribute(name = "synapse_type")
    protected String synapseType;

    /**
     * Gets the value of the synapseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSynapseType() {
        return synapseType;
    }

    /**
     * Sets the value of the synapseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSynapseType(String value) {
        this.synapseType = value;
    }

}
