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
 * Definition of a parameter which varies along a cable group.
 * 
 * <p>Java class for InhomogeneousParam complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InhomogeneousParam">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="metric">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Path Length from root"/>
 *               &lt;enumeration value="3D radial position"/>
 *               &lt;enumeration value="3D path length from line"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="proximal" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="translationStart" type="{http://www.w3.org/2001/XMLSchema}double" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="distal" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="normalizationEnd" type="{http://www.w3.org/2001/XMLSchema}double" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="variable" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InhomogeneousParam", namespace = "http://morphml.org/morphml/schema", propOrder = {
    "metric",
    "proximal",
    "distal"
})
public class InhomogeneousParam {

    @XmlElement(required = true)
    protected String metric;
    protected InhomogeneousParam.Proximal proximal;
    protected InhomogeneousParam.Distal distal;
    @XmlAttribute(required = true)
    protected String name;
    @XmlAttribute(required = true)
    protected String variable;

    /**
     * Gets the value of the metric property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetric() {
        return metric;
    }

    /**
     * Sets the value of the metric property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetric(String value) {
        this.metric = value;
    }

    /**
     * Gets the value of the proximal property.
     * 
     * @return
     *     possible object is
     *     {@link InhomogeneousParam.Proximal }
     *     
     */
    public InhomogeneousParam.Proximal getProximal() {
        return proximal;
    }

    /**
     * Sets the value of the proximal property.
     * 
     * @param value
     *     allowed object is
     *     {@link InhomogeneousParam.Proximal }
     *     
     */
    public void setProximal(InhomogeneousParam.Proximal value) {
        this.proximal = value;
    }

    /**
     * Gets the value of the distal property.
     * 
     * @return
     *     possible object is
     *     {@link InhomogeneousParam.Distal }
     *     
     */
    public InhomogeneousParam.Distal getDistal() {
        return distal;
    }

    /**
     * Sets the value of the distal property.
     * 
     * @param value
     *     allowed object is
     *     {@link InhomogeneousParam.Distal }
     *     
     */
    public void setDistal(InhomogeneousParam.Distal value) {
        this.distal = value;
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

    /**
     * Gets the value of the variable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVariable() {
        return variable;
    }

    /**
     * Sets the value of the variable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVariable(String value) {
        this.variable = value;
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
     *       &lt;attribute name="normalizationEnd" type="{http://www.w3.org/2001/XMLSchema}double" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Distal {

        @XmlAttribute
        protected Double normalizationEnd;

        /**
         * Gets the value of the normalizationEnd property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getNormalizationEnd() {
            return normalizationEnd;
        }

        /**
         * Sets the value of the normalizationEnd property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setNormalizationEnd(Double value) {
            this.normalizationEnd = value;
        }

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
     *       &lt;attribute name="translationStart" type="{http://www.w3.org/2001/XMLSchema}double" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Proximal {

        @XmlAttribute
        protected Double translationStart;

        /**
         * Gets the value of the translationStart property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getTranslationStart() {
            return translationStart;
        }

        /**
         * Sets the value of the translationStart property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setTranslationStart(Double value) {
            this.translationStart = value;
        }

    }

}
