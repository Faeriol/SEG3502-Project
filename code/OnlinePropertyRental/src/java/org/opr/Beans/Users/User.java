package org.opr.Beans.Users;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.Users.UserT;

/**
 *
 * @author faeriol
 */
@Named(value = "user")
@RequestScoped
public class User {
    
    private Account userAccount;

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
    
}
