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
 * The main element which details the neuronal morphology. Cells, various histological features, and
 *             properties associated with the data can be contained in this element
 * 
 * <p>Java class for Morphology complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Morphology">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://morphml.org/metadata/schema}metadata"/>
 *         &lt;element name="cells" type="{http://morphml.org/morphml/schema}Cells"/>
 *         &lt;element name="features" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;group ref="{http://morphml.org/metadata/schema}metadata"/>
 *                   &lt;element name="feature" type="{http://morphml.org/morphml/schema}Feature" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="propertyDetails" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="propertyDetail" type="{http://morphml.org/metadata/schema}PropertyDetail" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="groupDetails" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="groupDetail" type="{http://morphml.org/metadata/schema}GroupDetail" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="lengthUnits" use="required" type="{http://morphml.org/metadata/schema}LengthUnits" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="volumeUnits" type="{http://morphml.org/metadata/schema}VolumeUnits" default="cubic_millimetre" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Morphology", namespace = "http://morphml.org/morphml/schema", propOrder = {
    "notes",
    "properties",
    "annotation",
    "group",
    "cells",
    "features",
    "propertyDetails",
    "groupDetails"
})
public class Morphology {

    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected String notes;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected Properties properties;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected Annotation annotation;
    @XmlElement(namespace = "http://morphml.org/metadata/schema")
    protected List<String> group;
    @XmlElement(namespace = "http://morphml.org/morphml/schema", required = true)
    protected Cells cells;
    @XmlElement(namespace = "http://morphml.org/morphml/schema")
    protected Morphology.Features features;
    @XmlElement(namespace = "http://morphml.org/morphml/schema")
    protected Morphology.PropertyDetails propertyDetails;
    @XmlElement(namespace = "http://morphml.org/morphml/schema")
    protected Morphology.GroupDetails groupDetails;
    @XmlAttribute(required = true)
    protected LengthUnits lengthUnits;
    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected VolumeUnits volumeUnits;

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
     * Gets the value of the cells property.
     * 
     * @return
     *     possible object is
     *     {@link Cells }
     *     
     */
    public Cells getCells() {
        return cells;
    }

    /**
     * Sets the value of the cells property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cells }
     *     
     */
    public void setCells(Cells value) {
        this.cells = value;
    }

    /**
     * Gets the value of the features property.
     * 
     * @return
     *     possible object is
     *     {@link Morphology.Features }
     *     
     */
    public Morphology.Features getFeatures() {
        return features;
    }

    /**
     * Sets the value of the features property.
     * 
     * @param value
     *     allowed object is
     *     {@link Morphology.Features }
     *     
     */
    public void setFeatures(Morphology.Features value) {
        this.features = value;
    }

    /**
     * Gets the value of the propertyDetails property.
     * 
     * @return
     *     possible object is
     *     {@link Morphology.PropertyDetails }
     *     
     */
    public Morphology.PropertyDetails getPropertyDetails() {
        return propertyDetails;
    }

    /**
     * Sets the value of the propertyDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link Morphology.PropertyDetails }
     *     
     */
    public void setPropertyDetails(Morphology.PropertyDetails value) {
        this.propertyDetails = value;
    }

    /**
     * Gets the value of the groupDetails property.
     * 
     * @return
     *     possible object is
     *     {@link Morphology.GroupDetails }
     *     
     */
    public Morphology.GroupDetails getGroupDetails() {
        return groupDetails;
    }

    /**
     * Sets the value of the groupDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link Morphology.GroupDetails }
     *     
     */
    public void setGroupDetails(Morphology.GroupDetails value) {
        this.groupDetails = value;
    }

    /**
     * Gets the value of the lengthUnits property.
     * 
     * @return
     *     possible object is
     *     {@link LengthUnits }
     *     
     */
    public LengthUnits getLengthUnits() {
        return lengthUnits;
    }

    /**
     * Sets the value of the lengthUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthUnits }
     *     
     */
    public void setLengthUnits(LengthUnits value) {
        this.lengthUnits = value;
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
     * Gets the value of the volumeUnits property.
     * 
     * @return
     *     possible object is
     *     {@link VolumeUnits }
     *     
     */
    public VolumeUnits getVolumeUnits() {
        if (volumeUnits == null) {
            return VolumeUnits.CUBIC_MILLIMETRE;
        } else {
            return volumeUnits;
        }
    }

    /**
     * Sets the value of the volumeUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link VolumeUnits }
     *     
     */
    public void setVolumeUnits(VolumeUnits value) {
        this.volumeUnits = value;
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
     *         &lt;element name="feature" type="{http://morphml.org/morphml/schema}Feature" maxOccurs="unbounded"/>
     *       &lt;/sequence>
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
        "feature"
    })
    public static class Features {

        @XmlElement(namespace = "http://morphml.org/metadata/schema")
        protected String notes;
        @XmlElement(namespace = "http://morphml.org/metadata/schema")
        protected Properties properties;
        @XmlElement(namespace = "http://morphml.org/metadata/schema")
        protected Annotation annotation;
        @XmlElement(namespace = "http://morphml.org/metadata/schema")
        protected List<String> group;
        @XmlElement(namespace = "http://morphml.org/morphml/schema", required = true)
        protected List<Feature> feature;

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
         * Gets the value of the feature property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the feature property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFeature().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Feature }
         * 
         * 
         */
        public List<Feature> getFeature() {
            if (feature == null) {
                feature = new ArrayList<Feature>();
            }
            return this.feature;
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
     *       &lt;sequence>
     *         &lt;element name="groupDetail" type="{http://morphml.org/metadata/schema}GroupDetail" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "groupDetail"
    })
    public static class GroupDetails {

        @XmlElement(namespace = "http://morphml.org/morphml/schema", required = true)
        protected List<GroupDetail> groupDetail;

        /**
         * Gets the value of the groupDetail property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the groupDetail property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGroupDetail().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GroupDetail }
         * 
         * 
         */
        public List<GroupDetail> getGroupDetail() {
            if (groupDetail == null) {
                groupDetail = new ArrayList<GroupDetail>();
            }
            return this.groupDetail;
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
     *       &lt;sequence>
     *         &lt;element name="propertyDetail" type="{http://morphml.org/metadata/schema}PropertyDetail" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "propertyDetail"
    })
    public static class PropertyDetails {

        @XmlElement(namespace = "http://morphml.org/morphml/schema", required = true)
        protected List<PropertyDetail> propertyDetail;

        /**
         * Gets the value of the propertyDetail property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the propertyDetail property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPropertyDetail().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PropertyDetail }
         * 
         * 
         */
        public List<PropertyDetail> getPropertyDetail() {
            if (propertyDetail == null) {
                propertyDetail = new ArrayList<PropertyDetail>();
            }
            return this.propertyDetail;
        }

    }

}
