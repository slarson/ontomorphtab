//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.0 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.04.03 at 06:02:34 PM PDT 
//


package neuroml.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for StatusValue.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatusValue">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="stable"/>
 *     &lt;enumeration value="in_progress"/>
 *     &lt;enumeration value="known_issues"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum StatusValue {

    @XmlEnumValue("stable")
    STABLE("stable"),
    @XmlEnumValue("in_progress")
    IN_PROGRESS("in_progress"),
    @XmlEnumValue("known_issues")
    KNOWN_ISSUES("known_issues");
    private final String value;

    StatusValue(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusValue fromValue(String v) {
        for (StatusValue c: StatusValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
