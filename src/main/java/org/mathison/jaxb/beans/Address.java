package org.mathison.jaxb.beans;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Daryl Mathison
 */
@XmlRootElement
@Getter
@Setter
public class Address {
    @XmlType(name="address-type")
    public enum Type {
        WORK,
        HOME;
    }
    
    private Type type;
    private String addressLine;
    private String city;
    private String state;
    private String zipCode;


    @Override
    public String toString() {
        return "Address{" + "type=" + type + ", addressLine=" + addressLine + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 23 * hash + (this.addressLine != null ? this.addressLine.hashCode() : 0);
        hash = 23 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 23 * hash + (this.state != null ? this.state.hashCode() : 0);
        hash = 23 * hash + (this.zipCode != null ? this.zipCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.addressLine, other.addressLine)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        return true;
    }
    
    
}
