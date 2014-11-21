package org.opr.Beans.Users;

import org.opr.Beans.Rental.*;

/**
 * This class might be a good candidate for refactoring.
 * The name is confusing, and furthermore,
 * an Owner might actually share some things with the renter...
 * @author faeriol
 */
public class Customer extends User {
    
    private Preferences housingPreference;
    private Property[]  visitList;
    private Lease       currentLease;
    
}
