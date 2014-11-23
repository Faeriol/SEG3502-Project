package org.opr.Beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.AgencyT;

/**
 *
 * @author faeriol
 */
@Named(value = "agency")
@RequestScoped
public class Agency {
    private String name;
    private String address;

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
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
}
