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
public class PhoneNumber {
    @XmlType(name="phone-type")
    public enum Type {
        HOME,
        WORK,
        HOME_FAX,
        WORK_FAX;
    }
    
    private Type type;
    private String number;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

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
        if ((this.number == null) ? (other.number != null) : !this.number.equals(other.number)) {
            return false;
        }
        return true;
    }
    
}
