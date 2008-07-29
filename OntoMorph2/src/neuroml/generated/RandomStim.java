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
 * A random stimulation at a specific frequency. Note: can be interpreted differently by different simulators!!
 * 
 * <p>Java class for RandomStim complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RandomStim">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="frequency" use="required" type="{http://morphml.org/biophysics/schema}FrequencyValue" />
 *       &lt;attribute name="synaptic_mechanism" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RandomStim", namespace = "http://morphml.org/networkml/schema")
public class RandomStim {

    @XmlAttribute(required = true)
    protected double frequency;
    @XmlAttribute(name = "synaptic_mechanism", required = true)
    protected String synapticMechanism;

    /**
     * Gets the value of the frequency property.
     * 
     */
    public double getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * 
     */
    public void setFrequency(double value) {
        this.frequency = value;
    }

    /**
     * Gets the value of the synapticMechanism property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSynapticMechanism() {
        return synapticMechanism;
    }

    /**
     * Sets the value of the synapticMechanism property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSynapticMechanism(String value) {
        this.synapticMechanism = value;
    }

}
