//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.04.03 at 06:02:34 PM PDT 
//


package neuroml.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition of a voltage gate. Normally this will be specified as rate equations for 
 *             alpha and beta, or for tau and inf
 * 
 * <p>Java class for VoltageGate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VoltageGate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://morphml.org/channelml/schema}AlphaBetaForm" minOccurs="0"/>
 *         &lt;group ref="{http://morphml.org/channelml/schema}ExtraRateExpressions" minOccurs="0"/>
 *         &lt;element name="tau" type="{http://morphml.org/channelml/schema}RateConstantEqnChoice" minOccurs="0"/>
 *         &lt;element name="inf" type="{http://morphml.org/channelml/schema}RateConstantEqnChoice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoltageGate", propOrder = {
    "alpha",
    "beta",
    "gamma",
    "zeta",
    "tau",
    "inf"
})
public class VoltageGate {

    protected RateConstantEqnChoice alpha;
    protected RateConstantEqnChoice beta;
    protected RateConstantEqnChoice gamma;
    protected RateConstantEqnChoice zeta;
    protected RateConstantEqnChoice tau;
    protected RateConstantEqnChoice inf;

    /**
     * Gets the value of the alpha property.
     * 
     * @return
     *     possible object is
     *     {@link RateConstantEqnChoice }
     *     
     */
    public RateConstantEqnChoice getAlpha() {
        return alpha;
    }

    /**
     * Sets the value of the alpha property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateConstantEqnChoice }
     *     
     */
    public void setAlpha(RateConstantEqnChoice value) {
        this.alpha = value;
    }

    /**
     * Gets the value of the beta property.
     * 
     * @return
     *     possible object is
     *     {@link RateConstantEqnChoice }
     *     
     */
    public RateConstantEqnChoice getBeta() {
        return beta;
    }

    /**
     * Sets the value of the beta property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateConstantEqnChoice }
     *     
     */
    public void setBeta(RateConstantEqnChoice value) {
        this.beta = value;
    }

    /**
     * Gets the value of the gamma property.
     * 
     * @return
     *     possible object is
     *     {@link RateConstantEqnChoice }
     *     
     */
    public RateConstantEqnChoice getGamma() {
        return gamma;
    }

    /**
     * Sets the value of the gamma property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateConstantEqnChoice }
     *     
     */
    public void setGamma(RateConstantEqnChoice value) {
        this.gamma = value;
    }

    /**
     * Gets the value of the zeta property.
     * 
     * @return
     *     possible object is
     *     {@link RateConstantEqnChoice }
     *     
     */
    public RateConstantEqnChoice getZeta() {
        return zeta;
    }

    /**
     * Sets the value of the zeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateConstantEqnChoice }
     *     
     */
    public void setZeta(RateConstantEqnChoice value) {
        this.zeta = value;
    }

    /**
     * Gets the value of the tau property.
     * 
     * @return
     *     possible object is
     *     {@link RateConstantEqnChoice }
     *     
     */
    public RateConstantEqnChoice getTau() {
        return tau;
    }

    /**
     * Sets the value of the tau property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateConstantEqnChoice }
     *     
     */
    public void setTau(RateConstantEqnChoice value) {
        this.tau = value;
    }

    /**
     * Gets the value of the inf property.
     * 
     * @return
     *     possible object is
     *     {@link RateConstantEqnChoice }
     *     
     */
    public RateConstantEqnChoice getInf() {
        return inf;
    }

    /**
     * Sets the value of the inf property.
     * 
     * @param value
     *     allowed object is
     *     {@link RateConstantEqnChoice }
     *     
     */
    public void setInf(RateConstantEqnChoice value) {
        this.inf = value;
    }

}
