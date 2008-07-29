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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * How the current through the channel depends on the conductance of the channel. 
 *             Only ohmic and integrate_and_fire supported at the moment
 * 
 * <p>Java class for CurrentVoltageRelation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CurrentVoltageRelation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="ohmic" type="{http://morphml.org/channelml/schema}Ohmic"/>
 *         &lt;element name="integrate_and_fire" type="{http://morphml.org/channelml/schema}IntegrateAndFire"/>
 *       &lt;/choice>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrentVoltageRelation", propOrder = {
    "ohmic",
    "integrateAndFire"
})
public class CurrentVoltageRelation {

    protected Ohmic ohmic;
    @XmlElement(name = "integrate_and_fire")
    protected IntegrateAndFire integrateAndFire;
    @XmlAttribute
    protected String name;

    /**
     * Gets the value of the ohmic property.
     * 
     * @return
     *     possible object is
     *     {@link Ohmic }
     *     
     */
    public Ohmic getOhmic() {
        return ohmic;
    }

    /**
     * Sets the value of the ohmic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ohmic }
     *     
     */
    public void setOhmic(Ohmic value) {
        this.ohmic = value;
    }

    /**
     * Gets the value of the integrateAndFire property.
     * 
     * @return
     *     possible object is
     *     {@link IntegrateAndFire }
     *     
     */
    public IntegrateAndFire getIntegrateAndFire() {
        return integrateAndFire;
    }

    /**
     * Sets the value of the integrateAndFire property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegrateAndFire }
     *     
     */
    public void setIntegrateAndFire(IntegrateAndFire value) {
        this.integrateAndFire = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
