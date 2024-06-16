package org.mathison.jaxb.beans;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Daryl Mathison
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Contact {
    private String lastName;
    private String firstName;
    private String middleName;
    private String jobTitle;
    
    @XmlElementWrapper(name = "addresses")
    @XmlElement(name = "address")
    private List<Address> addresses;
    
    @XmlElementWrapper(name = "phone-numbers")
    @XmlElement(name = "phone-number")
    private List<PhoneNumber> numbers;


    @Override
    public String toString() {
        return "Contact{" + "lastName=" + lastName + ", firstName=" + firstName + ", middleName=" + middleName + ", jobTitle=" + jobTitle + ", addresses=" + addresses + ", numbers=" + numbers + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 23 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 23 * hash + (this.middleName != null ? this.middleName.hashCode() : 0);
        hash = 23 * hash + (this.jobTitle != null ? this.jobTitle.hashCode() : 0);
        hash = 23 * hash + (this.addresses != null ? this.addresses.hashCode() : 0);
        hash = 23 * hash + (this.numbers != null ? this.numbers.hashCode() : 0);
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
        final Contact other = (Contact) obj;
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.middleName, other.middleName)) {
            return false;
        }
        if (!Objects.equals(this.jobTitle, other.jobTitle)) {
            return false;
        }
        
        if(!listEquals(this.addresses, other.addresses)) {
            return false;
        }
        
        if(!listEquals(this.numbers, other.numbers)) {
            return false;
        }
        return true;
    }
    
    private boolean listEquals(List first, List second) {
        for(Object o: first) {
            if(!second.contains(o)) {
                return false;
            }
        }
        return true;
    }
}
