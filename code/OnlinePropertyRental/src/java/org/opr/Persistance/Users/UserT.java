package org.opr.Persistance.Users;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.opr.Beans.Users.User;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="UserT") // User is a reserved SQL name
public class UserT implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int USER_ID;
    @OneToOne
    private AccountT ACCOUNT;

    /**
     * @return the USER_ID
     */
    public int getUSER_ID() {
        return USER_ID;
    }

    /**
     * @param USER_ID the USER_ID to set
     */
    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    /**
     * @return the ACCOUNT
     */
    public AccountT getACCOUNT() {
        return ACCOUNT;
    }

    /**
     * @param ACCOUNT the ACCOUNT to set
     */
    public void setACCOUNT(AccountT ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }
    
    public boolean matches(User user) {
        // IMPLEMENT!!!
        //if (null!=projetData.getProjetID() && !"".equals(projetData.getProjetID()) && !this.getPROJET_ID().trim().equals(projetData.getProjetID().trim())) {
        //    return false;
        //} else if (!"".equals(projetData.getNomProjet()) && !this.getNOM_PROJET().trim().equals(projetData.getNomProjet())) {
        //        return false;
        //} 
        return true;
    }
    
}
