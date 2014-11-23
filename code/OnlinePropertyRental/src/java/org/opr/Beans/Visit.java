package org.opr.Beans;

import java.util.Date;
import org.opr.Beans.Users.Agent;
import org.opr.Beans.Users.Customer;

/**
 *
 * @author faeriol
 */
public class Visit {
    private Date     date;
    private Customer prospect;
    private Agent    rep;

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
    
    
}

