package org.opr.Beans;

import java.sql.Date;
import java.util.List;
import org.opr.Beans.Users.Agent;
import org.opr.Beans.Users.Customer;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Beans.Rental.Property;
import org.opr.Persistance.VisitT;

/**
 *
 * @author faeriol
 */
@Named(value = "visit")
@RequestScoped
public class Visit {
    private Date     date;
    private Customer prospect;
    private Agent    rep;
    private Property property;
    private List<VisitT> lookupResults;

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the prospect
     */
    public Customer getProspect() {
        return prospect;
    }

    /**
     * @param prospect the prospect to set
     */
    public void setProspect(Customer prospect) {
        this.prospect = prospect;
    }

    /**
     * @return the rep
     */
    public Agent getRep() {
        return rep;
    }

    /**
     * @param rep the rep to set
     */
    public void setRep(Agent rep) {
        this.rep = rep;
    }
    
    public void setLookupResults(List<VisitT> results) {
        this.lookupResults = results;
    }
    
    public List<VisitT> getLookupResults() {
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

