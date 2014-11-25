package org.opr.Beans;

import java.util.List;
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
    
    private String ID;
    private String name;
    private Address address;
    private List<AgencyT> lookupResults;

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
 
    public void setLookupResults(List<AgencyT> results) {
        this.lookupResults = results;
    }

    public List<AgencyT> getLookupResults() {
        return lookupResults;
    }

    // show results if any

    public boolean getShowResults() {
        return (lookupResults != null) && !lookupResults.isEmpty();
    }

    // show message if no result

    public boolean getShowMessage() {
        return (lookupResults != null) && lookupResults.isEmpty();
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }
}
