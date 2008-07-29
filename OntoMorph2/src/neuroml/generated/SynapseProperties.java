//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.07.28 at 11:54:05 PM PDT 
//


package neuroml.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Pre v1.7.1 format for global synapse properties. Preferred format is GlobalSynapticProperties. This option will be disabled in v2.0
 * 
 * <p>Java class for SynapseProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SynapseProperties">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://morphml.org/metadata/schema}metadata"/>
 *         &lt;element name="synapse_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="default_values" type="{http://morphml.org/networkml/schema}SynapseInternalProperties"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SynapseProperties", namespace = "http://morphml.org/networkml/schema", propOrder = {
    "notes",
    "properties",
    "annotation",
    "group",
    "synapseType",
    "defaultValues"
})
public class SynapseProperties {

    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected String notes;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected Properties properties;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected Annotation annotation;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected List<String> group;
    @XmlElement(name = "synapse_type", required = true)
    protected String synapseType;
    @XmlElement(name = "default_values", required = true)
    protected SynapseInternalProperties defaultValues;

    /**
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotes(String value) {
        this.notes = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link Properties }
     *     
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link Properties }
     *     
     */
    public void setProperties(Properties value) {
        this.properties = value;
    }

    /**
     * Gets the value of the annotation property.
     * 
     * @return
     *     possible object is
     *     {@link Annotation }
     *     
     */
    public Annotation getAnnotation() {
        return annotation;
    }

    /**
     * Sets the value of the annotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Annotation }
     *     
     */
    public void setAnnotation(Annotation value) {
        this.annotation = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the group property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGroup() {
        if (group == null) {
            group = new ArrayList<String>();
        }
        return this.group;
    }

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

    /**
     * Gets the value of the defaultValues property.
     * 
     * @return
     *     possible object is
     *     {@link SynapseInternalProperties }
     *     
     */
    public SynapseInternalProperties getDefaultValues() {
        return defaultValues;
    }

    /**
     * Sets the value of the defaultValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link SynapseInternalProperties }
     *     
     */
    public void setDefaultValues(SynapseInternalProperties value) {
        this.defaultValues = value;
    }

}
