package org.opr.Beans.Users;

import java.util.List;
import org.opr.Beans.Rental.*;

/**
 * This class might be a good candidate for refactoring.
 * The name is confusing, and furthermore,
 * an Owner might actually share some things with the renter...
 * @author faeriol
 */
public class Customer extends User {
    
    private Preferences     housingPreference;
    private List<Property>  visitList;
    private Lease           currentLease;
    
    public void addProperty(Property property){
        visitList.add(property);
    }
}
