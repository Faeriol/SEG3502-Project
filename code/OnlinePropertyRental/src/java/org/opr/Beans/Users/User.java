package org.opr.Beans.Users;

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
