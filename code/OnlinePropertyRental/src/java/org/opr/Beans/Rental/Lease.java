package org.opr.Beans.Rental;

import java.util.Date;
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
    
    private Date rentalDate;
    private long rentalTime;
    private Customer renter;
    private Property leasedProperty;
    private int rent;
    
}
