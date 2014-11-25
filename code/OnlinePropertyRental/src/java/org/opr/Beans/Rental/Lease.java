package org.opr.Beans.Rental;

import java.sql.Date;
import java.util.List;
import org.opr.Beans.Users.Customer;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.Rental.LeaseT;

/**
 *
 * @author faeriol
 */
@Named(value = "lease")
@RequestScoped
public class Lease {
    
    private String ID;
    private Date rentalDate;
    private long rentalTime;
    private Customer renter;
    private Property leasedProperty;
    private float rent;
    
    private List<LeaseT> lookupResults;

    /**
     * @return the rentalDate
     */
    public Date getRentalDate() {
        return rentalDate;
    }

    /**
     * @param rentalDate the rentalDate to set
     */
    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    /**
     * @return the rentalTime
     */
    public long getRentalTime() {
        return rentalTime;
    }

    /**
     * @param rentalTime the rentalTime to set
     */
    public void setRentalTime(long rentalTime) {
        this.rentalTime = rentalTime;
    }

    /**
     * @return the renter
     */
    public Customer getRenter() {
        return renter;
    }

    /**
     * @param renter the renter to set
     */
    public void setRenter(Customer renter) {
        this.renter = renter;
    }

    /**
     * @return the leasedProperty
     */
    public Property getLeasedProperty() {
        return leasedProperty;
    }

    /**
     * @param leasedProperty the leasedProperty to set
     */
    public void setLeasedProperty(Property leasedProperty) {
        this.leasedProperty = leasedProperty;
    }

    /**
     * @return the rent
     */
    public float getRent() {
        return rent;
    }

    /**
     * @param rent the rent to set
     */
    public void setRent(float rent) {
        this.rent = rent;
    }
    
    public void setLookupResults(List<LeaseT> results) {
        this.lookupResults = results;
    }
    
    public List<LeaseT> getLookupResults() {
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
