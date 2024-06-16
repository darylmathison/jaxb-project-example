package org.mathison.jaxb.beans;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement
@Getter
@Setter
public class PhoneNumber {
    @XmlType(name="phone-type")
    public enum Type {
        HOME,
        WORK,
        MOBILE;
    }
    
    private Type type;
    private String number;

    @Override
    public String toString() {
        return "PhoneNumber{" + "type=" + type + ", number=" + number + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 37 * hash + (this.number != null ? this.number.hashCode() : 0);
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
        final PhoneNumber other = (PhoneNumber) obj;
        if (this.type != other.type) {
            return false;
        }
      return Objects.equals(this.number, other.number);
    }
    
}
