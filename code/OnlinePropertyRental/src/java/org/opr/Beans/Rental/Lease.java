package org.opr.Beans.Rental;

import java.util.Date;
import org.opr.Beans.Users.Customer;

/**
 *
 * @author faeriol
 */
public class Lease {
    
    private Date rentalDate;
    private long rentalTime;
    private Customer renter;
    private Property leasedProperty;
    private int rent;
    
}
