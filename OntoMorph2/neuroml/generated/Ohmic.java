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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Signifies an ohmic relation; the current is proportional to the potential difference across the channel
 * 
 * <p>Java class for Ohmic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ohmic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="conductance">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;group ref="{http://morphml.org/metadata/schema}metadata"/>
 *                   &lt;element name="rate_adjustments" type="{http://morphml.org/channelml/schema}RateAdjustments" minOccurs="0"/>
 *                   &lt;element name="gate" type="{http://morphml.org/channelml/schema}Gate" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="default_gmax" use="required" type="{http://morphml.org/biophysics/schema}ConductanceDensityValue" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="ion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ohmic", propOrder = {
    "conductance"
})
public class Ohmic {

    @XmlElement(required = true)
    protected Ohmic.Conductance conductance;
    @XmlAttribute
    protected String ion;

    /**
     * Gets the value of the conductance property.
     * 
     * @return
     *     possible object is
     *     {@link Ohmic.Conductance }
     *     
     */
    public Ohmic.Conductance getConductance() {
        return conductance;
    }

    /**
     * Sets the value of the conductance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ohmic.Conductance }
     *     
     */
    public void setConductance(Ohmic.Conductance value) {
        this.conductance = value;
    }

    /**
     * Gets the value of the ion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIon() {
        return ion;
    }

    /**
     * Sets the value of the ion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIon(String value) {
        this.ion = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;group ref="{http://morphml.org/metadata/schema}metadata"/>
     *         &lt;element name="rate_adjustments" type="{http://morphml.org/channelml/schema}RateAdjustments" minOccurs="0"/>
     *         &lt;element name="gate" type="{http://morphml.org/channelml/schema}Gate" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="default_gmax" use="required" type="{http://morphml.org/biophysics/schema}ConductanceDensityValue" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "notes",
        "properties",
        "annotation",
        "group",
        "rateAdjustments",
        "gate"
    })
    public static class Conductance {

        @XmlElement(namespace = "http://morphml.org/metadata/schema")
        protected String notes;
        @XmlElement(namespace = "http://morphml.org/metadata/schema")
        protected Properties properties;
        @XmlElement(namespace = "http://morphml.org/metadata/schema")
        protected Annotation annotation;
        @XmlElement(namespace = "http://morphml.org/metadata/schema")
        protected List<String> group;
        @XmlElement(name = "rate_adjustments")
        protected RateAdjustments rateAdjustments;
        protected List<Gate> gate;
        @XmlAttribute(name = "default_gmax", required = true)
        protected double defaultGmax;

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
         * Gets the value of the rateAdjustments property.
         * 
         * @return
         *     possible object is
         *     {@link RateAdjustments }
         *     
         */
        public RateAdjustments getRateAdjustments() {
            return rateAdjustments;
        }

        /**
         * Sets the value of the rateAdjustments property.
         * 
         * @param value
         *     allowed object is
         *     {@link RateAdjustments }
         *     
         */
        public void setRateAdjustments(RateAdjustments value) {
            this.rateAdjustments = value;
        }

        /**
         * Gets the value of the gate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the gate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Gate }
         * 
         * 
         */
        public List<Gate> getGate() {
            if (gate == null) {
                gate = new ArrayList<Gate>();
            }
            return this.gate;
        }

        /**
         * Gets the value of the defaultGmax property.
         * 
         */
        public double getDefaultGmax() {
            return defaultGmax;
        }

        /**
         * Sets the value of the defaultGmax property.
         * 
         */
        public void setDefaultGmax(double value) {
            this.defaultGmax = value;
        }

    }

}
