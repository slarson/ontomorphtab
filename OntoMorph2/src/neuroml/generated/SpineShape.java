//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.07.28 at 11:54:05 PM PDT 
//


package neuroml.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpineShape.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SpineShape">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="mushroom"/>
 *     &lt;enumeration value="stubby"/>
 *     &lt;enumeration value="thin"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SpineShape", namespace = "http://morphml.org/morphml/schema")
@XmlEnum
public enum SpineShape {

    @XmlEnumValue("mushroom")
    MUSHROOM("mushroom"),
    @XmlEnumValue("stubby")
    STUBBY("stubby"),
    @XmlEnumValue("thin")
    THIN("thin");
    private final String value;

    SpineShape(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SpineShape fromValue(String v) {
        for (SpineShape c: SpineShape.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
