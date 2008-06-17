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
 * Definition of a synaptic mechanism
 * 
 * <p>Java class for SynapseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SynapseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://morphml.org/metadata/schema}Status" minOccurs="0"/>
 *         &lt;group ref="{http://morphml.org/metadata/schema}metadata"/>
 *         &lt;group ref="{http://morphml.org/metadata/schema}referencedata"/>
 *         &lt;choice>
 *           &lt;element name="doub_exp_syn" type="{http://morphml.org/channelml/schema}DoubleExponentialSynapse"/>
 *           &lt;element name="blocking_syn" type="{http://morphml.org/channelml/schema}BlockingSynapse"/>
 *           &lt;element name="plastic_syn" type="{http://morphml.org/channelml/schema}PlasticSynapse"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SynapseType", propOrder = {
    "status",
    "notes",
    "properties",
    "annotation",
    "group",
    "authorList",
    "publication",
    "neuronDBref",
    "modelDBref",
    "doubExpSyn",
    "blockingSyn",
    "plasticSyn"
})
public class SynapseType {

    protected Status status;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected String notes;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected Properties properties;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected Annotation annotation;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected List<String> group;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected Authors authorList;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected List<Publication> publication;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected NeuronDBReference neuronDBref;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected ModelDBReference modelDBref;
    @XmlElement(name = "doub_exp_syn")
    protected DoubleExponentialSynapse doubExpSyn;
    @XmlElement(name = "blocking_syn")
    protected BlockingSynapse blockingSyn;
    @XmlElement(name = "plastic_syn")
    protected PlasticSynapse plasticSyn;
    @XmlAttribute(required = true)
    protected String name;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

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
     * Gets the value of the authorList property.
     * 
     * @return
     *     possible object is
     *     {@link Authors }
     *     
     */
    public Authors getAuthorList() {
        return authorList;
    }

    /**
     * Sets the value of the authorList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Authors }
     *     
     */
    public void setAuthorList(Authors value) {
        this.authorList = value;
    }

    /**
     * Gets the value of the publication property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the publication property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPublication().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Publication }
     * 
     * 
     */
    public List<Publication> getPublication() {
        if (publication == null) {
            publication = new ArrayList<Publication>();
        }
        return this.publication;
    }

    /**
     * Gets the value of the neuronDBref property.
     * 
     * @return
     *     possible object is
     *     {@link NeuronDBReference }
     *     
     */
    public NeuronDBReference getNeuronDBref() {
        return neuronDBref;
    }

    /**
     * Sets the value of the neuronDBref property.
     * 
     * @param value
     *     allowed object is
     *     {@link NeuronDBReference }
     *     
     */
    public void setNeuronDBref(NeuronDBReference value) {
        this.neuronDBref = value;
    }

    /**
     * Gets the value of the modelDBref property.
     * 
     * @return
     *     possible object is
     *     {@link ModelDBReference }
     *     
     */
    public ModelDBReference getModelDBref() {
        return modelDBref;
    }

    /**
     * Sets the value of the modelDBref property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelDBReference }
     *     
     */
    public void setModelDBref(ModelDBReference value) {
        this.modelDBref = value;
    }

    /**
     * Gets the value of the doubExpSyn property.
     * 
     * @return
     *     possible object is
     *     {@link DoubleExponentialSynapse }
     *     
     */
    public DoubleExponentialSynapse getDoubExpSyn() {
        return doubExpSyn;
    }

    /**
     * Sets the value of the doubExpSyn property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoubleExponentialSynapse }
     *     
     */
    public void setDoubExpSyn(DoubleExponentialSynapse value) {
        this.doubExpSyn = value;
    }

    /**
     * Gets the value of the blockingSyn property.
     * 
     * @return
     *     possible object is
     *     {@link BlockingSynapse }
     *     
     */
    public BlockingSynapse getBlockingSyn() {
        return blockingSyn;
    }

    /**
     * Sets the value of the blockingSyn property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlockingSynapse }
     *     
     */
    public void setBlockingSyn(BlockingSynapse value) {
        this.blockingSyn = value;
    }

    /**
     * Gets the value of the plasticSyn property.
     * 
     * @return
     *     possible object is
     *     {@link PlasticSynapse }
     *     
     */
    public PlasticSynapse getPlasticSyn() {
        return plasticSyn;
    }

    /**
     * Sets the value of the plasticSyn property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlasticSynapse }
     *     
     */
    public void setPlasticSyn(PlasticSynapse value) {
        this.plasticSyn = value;
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
