package org.opr.Beans.Users;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.Users.UserT;

/**
 * If you want my very honest opinion, this class is just a facade
 * that is there for "good design" in terms of wordings and whatnot
 * It IS completely useless... Why the hell are we just wrapping an Account
 * @author faeriol
 */
@Named(value = "user")
@RequestScoped
public class User {
    
    private Account userAccount;
    
    // Will cheaply manage name clash... We never get a list of straight Users
    //private List<UserT> lookupResults;

    /**
     * @return the userAccount
     */
    public Account getUserAccount() {
        return userAccount;
    }

    /**
     * @param userAccount the userAccount to set
     */
    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }
    
    
    //Getting name clash for 2 below
    //Obvious answer is to 
    //public void setLookupResults(List<UserT> results) {
    //    this.lookupResults = results;
    //}
    
    //public List<UserT> getLookupResults() {
    //    return lookupResults;
    //}
    // show results if any
    //public boolean getShowResults() {
    //    return (lookupResults != null) && !lookupResults.isEmpty();
    //}
    // show message if no result
    //public boolean getShowMessage() {
    //    return (lookupResults != null) && lookupResults.isEmpty();
    //}
    
}
