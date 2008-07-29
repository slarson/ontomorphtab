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
 * Element for parameters in a decaying pool model of ion concentration (e.g. calcium pool)
 * 
 * <p>Java class for DecayingPoolModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DecayingPoolModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resting_conc" type="{http://morphml.org/biophysics/schema}ConcentrationValue" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="decay_constant" type="{http://morphml.org/biophysics/schema}TimeConstantValue" minOccurs="0"/>
 *           &lt;element name="inv_decay_constant" type="{http://morphml.org/biophysics/schema}InvTimeConstantValue"/>
 *         &lt;/choice>
 *         &lt;element name="ceiling" type="{http://morphml.org/biophysics/schema}ConcentrationValue" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="pool_volume_info" type="{http://morphml.org/channelml/schema}PoolVolumeInfo"/>
 *           &lt;element name="fixed_pool_info" type="{http://morphml.org/channelml/schema}FixedPoolInfo"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="resting_conc" type="{http://morphml.org/biophysics/schema}ConcentrationValue" />
 *       &lt;attribute name="decay_constant" type="{http://morphml.org/biophysics/schema}TimeConstantValue" />
 *       &lt;attribute name="inv_decay_constant" type="{http://morphml.org/biophysics/schema}InvTimeConstantValue" />
 *       &lt;attribute name="ceiling" type="{http://morphml.org/biophysics/schema}ConcentrationValue" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DecayingPoolModel", propOrder = {
    "restingConcDeprecated",
    "decayConstantDeprecated",
    "invDecayConstantDeprecated",
    "ceilingDeprecated",
    "poolVolumeInfo",
    "fixedPoolInfo"
})
public class DecayingPoolModel {

    @XmlElement(name = "resting_conc")
    protected Double restingConcDeprecated;
    @XmlElement(name = "decay_constant")
    protected Double decayConstantDeprecated;
    @XmlElement(name = "inv_decay_constant")
    protected Double invDecayConstantDeprecated;
    @XmlElement(name = "ceiling")
    protected Double ceilingDeprecated;
    @XmlElement(name = "pool_volume_info")
    protected PoolVolumeInfo poolVolumeInfo;
    @XmlElement(name = "fixed_pool_info")
    protected FixedPoolInfo fixedPoolInfo;
    @XmlAttribute(name = "resting_conc")
    protected Double restingConc;
    @XmlAttribute(name = "decay_constant")
    protected Double decayConstant;
    @XmlAttribute(name = "inv_decay_constant")
    protected Double invDecayConstant;
    @XmlAttribute
    protected Double ceiling;

    /**
     * Gets the value of the restingConcDeprecated property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRestingConcDeprecated() {
        return restingConcDeprecated;
    }

    /**
     * Sets the value of the restingConcDeprecated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRestingConcDeprecated(Double value) {
        this.restingConcDeprecated = value;
    }

    /**
     * Gets the value of the decayConstantDeprecated property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDecayConstantDeprecated() {
        return decayConstantDeprecated;
    }

    /**
     * Sets the value of the decayConstantDeprecated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDecayConstantDeprecated(Double value) {
        this.decayConstantDeprecated = value;
    }

    /**
     * Gets the value of the invDecayConstantDeprecated property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInvDecayConstantDeprecated() {
        return invDecayConstantDeprecated;
    }

    /**
     * Sets the value of the invDecayConstantDeprecated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInvDecayConstantDeprecated(Double value) {
        this.invDecayConstantDeprecated = value;
    }

    /**
     * Gets the value of the ceilingDeprecated property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCeilingDeprecated() {
        return ceilingDeprecated;
    }

    /**
     * Sets the value of the ceilingDeprecated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCeilingDeprecated(Double value) {
        this.ceilingDeprecated = value;
    }

    /**
     * Gets the value of the poolVolumeInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PoolVolumeInfo }
     *     
     */
    public PoolVolumeInfo getPoolVolumeInfo() {
        return poolVolumeInfo;
    }

    /**
     * Sets the value of the poolVolumeInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PoolVolumeInfo }
     *     
     */
    public void setPoolVolumeInfo(PoolVolumeInfo value) {
        this.poolVolumeInfo = value;
    }

    /**
     * Gets the value of the fixedPoolInfo property.
     * 
     * @return
     *     possible object is
     *     {@link FixedPoolInfo }
     *     
     */
    public FixedPoolInfo getFixedPoolInfo() {
        return fixedPoolInfo;
    }

    /**
     * Sets the value of the fixedPoolInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FixedPoolInfo }
     *     
     */
    public void setFixedPoolInfo(FixedPoolInfo value) {
        this.fixedPoolInfo = value;
    }

    /**
     * Gets the value of the restingConc property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRestingConc() {
        return restingConc;
    }

    /**
     * Sets the value of the restingConc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRestingConc(Double value) {
        this.restingConc = value;
    }

    /**
     * Gets the value of the decayConstant property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDecayConstant() {
        return decayConstant;
    }

    /**
     * Sets the value of the decayConstant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDecayConstant(Double value) {
        this.decayConstant = value;
    }

    /**
     * Gets the value of the invDecayConstant property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getInvDecayConstant() {
        return invDecayConstant;
    }

    /**
     * Sets the value of the invDecayConstant property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setInvDecayConstant(Double value) {
        this.invDecayConstant = value;
    }

    /**
     * Gets the value of the ceiling property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCeiling() {
        return ceiling;
    }

    /**
     * Sets the value of the ceiling property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCeiling(Double value) {
        this.ceiling = value;
    }

}
