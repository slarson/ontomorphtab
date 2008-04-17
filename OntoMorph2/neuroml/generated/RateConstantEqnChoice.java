//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.04.03 at 06:02:34 PM PDT 
//


package neuroml.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Choice of the various rate constant expressions allowed
 * 
 * <p>Java class for RateConstantEqnChoice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RateConstantEqnChoice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://morphml.org/metadata/schema}metadata"/>
 *         &lt;choice>
 *           &lt;element name="parameterised_hh" type="{http://morphml.org/channelml/schema}AkdEquation"/>
 *           &lt;element name="generic_equation_hh" type="{http://morphml.org/channelml/schema}GenericEquation"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RateConstantEqnChoice", propOrder = {
    "notes",
    "properties",
    "annotation",
    "group",
    "parameterisedHh",
    "genericEquationHh"
})
public class RateConstantEqnChoice {

    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected String notes;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected Properties properties;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected Annotation annotation;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected List<String> group;
    @XmlElement(name = "parameterised_hh")
    protected AkdEquation parameterisedHh;
    @XmlElement(name = "generic_equation_hh")
    protected GenericEquation genericEquationHh;

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
     * Gets the value of the parameterisedHh property.
     * 
     * @return
     *     possible object is
     *     {@link AkdEquation }
     *     
     */
    public AkdEquation getParameterisedHh() {
        return parameterisedHh;
    }

    /**
     * Sets the value of the parameterisedHh property.
     * 
     * @param value
     *     allowed object is
     *     {@link AkdEquation }
     *     
     */
    public void setParameterisedHh(AkdEquation value) {
        this.parameterisedHh = value;
    }

    /**
     * Gets the value of the genericEquationHh property.
     * 
     * @return
     *     possible object is
     *     {@link GenericEquation }
     *     
     */
    public GenericEquation getGenericEquationHh() {
        return genericEquationHh;
    }

    /**
     * Sets the value of the genericEquationHh property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericEquation }
     *     
     */
    public void setGenericEquationHh(GenericEquation value) {
        this.genericEquationHh = value;
    }

}