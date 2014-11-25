package org.opr.Beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Beans.util.Address;
import org.opr.Persistance.AgencyT;

/**
 *
 * @author faeriol
 */
@Named(value = "agency")
@RequestScoped
public class Agency {
    private String name;
    private Address address;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }
    
}
