package org.opr.Beans.Users;

import java.util.List;
import org.opr.Beans.Rental.*;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.Users.CustomerT;

/**
 * This class might be a good candidate for refactoring.
 * The name is confusing, and furthermore,
 * an Owner might actually share some things with the renter...
 * @author faeriol
 */
@Named(value = "customer")
@RequestScoped
public class Customer extends User {
    
    private Preferences     housingPreference;
    private List<Property>  visitList;
    private Lease           currentLease;
    
    private List<CustomerT> lookupResults;
    
    public void addProperty(Property property){
        getVisitList().add(property);
    }

    /**
     * @return the housingPreference
     */
    public Preferences getHousingPreference() {
        return housingPreference;
    }

    /**
     * @param housingPreference the housingPreference to set
     */
    public void setHousingPreference(Preferences housingPreference) {
        this.housingPreference = housingPreference;
    }

    /**
     * @return the visitList
     */
    public List<Property> getVisitList() {
        return visitList;
    }

    /**
     * @param visitList the visitList to set
     */
    public void setVisitList(List<Property> visitList) {
        this.visitList = visitList;
    }

    /**
     * @return the currentLease
     */
    public Lease getCurrentLease() {
        return currentLease;
    }

    /**
     * @param currentLease the currentLease to set
     */
    public void setCurrentLease(Lease currentLease) {
        this.currentLease = currentLease;
    }
    
    public void setLookupResults(List<CustomerT> results) {
        this.lookupResults = results;
    }
    
    public List<CustomerT> getLookupResults() {
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
