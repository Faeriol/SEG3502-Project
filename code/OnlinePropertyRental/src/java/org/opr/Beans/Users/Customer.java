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
    
    public void addProperty(Property property){
        visitList.add(property);
    }
}
