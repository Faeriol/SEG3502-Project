package org.opr.Beans.Users;

import java.util.List;
import org.opr.Beans.Rental.Property;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.Users.OwnerT;

/**
 *
 * @author faeriol
 */
@Named(value = "owner")
@RequestScoped
public class Owner extends User {
    private List<Property> properties;
    
    private List<OwnerT> lookupResults;
    
    
    public void addProperty(Property property){
        getProperties().add(property);
    }
    
    public void deleteProperty(Property property){
        getProperties().remove(property);
    }
    
    public void updateProperty(Property property){
        // Please implement, got lazy
    }

    /**
     * @return the properties
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * @param properties the properties to set
     */
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
    
    public void setLookupResults(List<OwnerT> results) {
        this.lookupResults = results;
    }
    
    public List<OwnerT> getLookupResults() {
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
