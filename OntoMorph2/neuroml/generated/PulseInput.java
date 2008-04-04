//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.04.03 at 06:02:34 PM PDT 
//


package neuroml.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * A single input pulse. Note: this should be changed to allow easier specifications of
 *                                   pulse trains, input protocols, etc.
 * 
 * <p>Java class for PulseInput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PulseInput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="amplitude" use="required" type="{http://morphml.org/biophysics/schema}CurrentValue" />
 *       &lt;attribute name="delay" use="required" type="{http://morphml.org/biophysics/schema}TimeValue" />
 *       &lt;attribute name="duration" use="required" type="{http://morphml.org/biophysics/schema}TimeValue" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PulseInput", namespace = "http://morphml.org/networkml/schema")
public class PulseInput {

    @XmlAttribute(required = true)
    protected double amplitude;
    @XmlAttribute(required = true)
    protected double delay;
    @XmlAttribute(required = true)
    protected double duration;

    /**
     * Gets the value of the amplitude property.
     * 
     */
    public double getAmplitude() {
        return amplitude;
    }

    /**
     * Sets the value of the amplitude property.
     * 
     */
    public void setAmplitude(double value) {
        this.amplitude = value;
    }

    /**
     * Gets the value of the delay property.
     * 
     */
    public double getDelay() {
        return delay;
    }

    /**
     * Sets the value of the delay property.
     * 
     */
    public void setDelay(double value) {
        this.delay = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     */
    public void setDuration(double value) {
        this.duration = value;
    }

}
