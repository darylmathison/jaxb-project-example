/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mathison.jaxb.beans;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daryl Mathison
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

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
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.middleName == null) ? (other.middleName != null) : !this.middleName.equals(other.middleName)) {
            return false;
        }
        if ((this.jobTitle == null) ? (other.jobTitle != null) : !this.jobTitle.equals(other.jobTitle)) {
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
