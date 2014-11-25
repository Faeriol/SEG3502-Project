package org.opr.Beans;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.ServiceT;

/**
 *
 * @author faeriol
 */
@Named(value = "service")
@RequestScoped
public class Service {
    private String name;
    private List<ServiceT> lookupResults;

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
    
    public void setLookupResults(List<ServiceT> results) {
        this.lookupResults = results;
    }
    
    public List<ServiceT> getLookupResults() {
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
}
