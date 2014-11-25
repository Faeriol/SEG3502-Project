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
    private String USER_ID;
    @OneToOne
    private AccountT ACCOUNT;

    /**
     * @return the USER_ID
     */
    public String getUSER_ID() {
        return USER_ID;
    }

    /**
     * @param USER_ID the USER_ID to set
     */
    public void setUSER_ID(String USER_ID) {
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
    
    public boolean matches(User bean) {
        if (null!=bean.getID() && !"".equals(bean.getID()) && !this.getUSER_ID().trim().equals(bean.getID().trim())) {
            return false;
        } //else if (!"".equals(bean.getNomProjet()) && !this.getNOM_PROJET().trim().equals(bean.getNomProjet())) { //Needs more
        //        return false;
        //} 
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += this.getUSER_ID().hashCode();
        return hash;
    }
    
}
