/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mathison.jaxb.beans;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Daryl Mathison
 */
@XmlRootElement
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

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
        if ((this.addressLine == null) ? (other.addressLine != null) : !this.addressLine.equals(other.addressLine)) {
            return false;
        }
        if ((this.city == null) ? (other.city != null) : !this.city.equals(other.city)) {
            return false;
        }
        if ((this.state == null) ? (other.state != null) : !this.state.equals(other.state)) {
            return false;
        }
        if ((this.zipCode == null) ? (other.zipCode != null) : !this.zipCode.equals(other.zipCode)) {
            return false;
        }
        return true;
    }
    
    
}
