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
 * Specification for the influence of a blocking species on the conductance of a BlockingSynapse. Based on the
 *             mechanism for blocking of an NMDA receptor by Mg as outlined in Gabbiani et al, 1994, Maex DeSchutter 1998
 * 
 * <p>Java class for Block complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Block">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="conc" use="required" type="{http://morphml.org/biophysics/schema}ConcentrationValue" />
 *       &lt;attribute name="eta" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="gamma" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="species" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Block")
public class Block {

    @XmlAttribute(required = true)
    protected double conc;
    @XmlAttribute(required = true)
    protected double eta;
    @XmlAttribute(required = true)
    protected double gamma;
    @XmlAttribute(required = true)
    protected String species;

    /**
     * Gets the value of the conc property.
     * 
     */
    public double getConc() {
        return conc;
    }

    /**
     * Sets the value of the conc property.
     * 
     */
    public void setConc(double value) {
        this.conc = value;
    }

    /**
     * Gets the value of the eta property.
     * 
     */
    public double getEta() {
        return eta;
    }

    /**
     * Sets the value of the eta property.
     * 
     */
    public void setEta(double value) {
        this.eta = value;
    }

    /**
     * Gets the value of the gamma property.
     * 
     */
    public double getGamma() {
        return gamma;
    }

    /**
     * Sets the value of the gamma property.
     * 
     */
    public void setGamma(double value) {
        this.gamma = value;
    }

    /**
     * Gets the value of the species property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Sets the value of the species property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecies(String value) {
        this.species = value;
    }

}