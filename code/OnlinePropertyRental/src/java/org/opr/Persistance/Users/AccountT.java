package org.opr.Persistance.Users;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.opr.Beans.Users.Account;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="Account")
public class AccountT implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String ACCOUNT_ID;
    private String TYPE;
    private String FIRST_NAME, LAST_NAME, EMAIL, USER_NAME, PASSWORD;

    /**
     * @return the ACCOUNT_ID
     */
    public String getACCOUNT_ID() {
        return ACCOUNT_ID;
    }

    /**
     * @param ACCOUNT_ID the ACCOUNT_ID to set
     */
    public void setACCOUNT_ID(String ACCOUNT_ID) {
        this.ACCOUNT_ID = ACCOUNT_ID;
    }

    /**
     * @return the TYPE
     */
    public String getTYPE() {
        return TYPE;
    }

    /**
     * @param TYPE the TYPE to set
     */
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    /**
     * @return the FIRST_NAME
     */
    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    /**
     * @param FIRST_NAME the FIRST_NAME to set
     */
    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    /**
     * @return the LAST_NAME
     */
    public String getLAST_NAME() {
        return LAST_NAME;
    }

    /**
     * @param LAST_NAME the LAST_NAME to set
     */
    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    /**
     * @return the EMAIL
     */
    public String getEMAIL() {
        return EMAIL;
    }

    /**
     * @param EMAIL the EMAIL to set
     */
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    /**
     * @return the USER_NAME
     */
    public String getUSER_NAME() {
        return USER_NAME;
    }

    /**
     * @param USER_NAME the USER_NAME to set
     */
    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    /**
     * @return the PASSWORD
     */
    public String getPASSWORD() {
        return PASSWORD;
    }

    /**
     * @param PASSWORD the PASSWORD to set
     */
    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
    
    public boolean matches(Account bean) {
        if (null!=bean.getID() && !"".equals(bean.getID()) && !this.getACCOUNT_ID().trim().equals(bean.getID().trim())) {
            return false;
        } //else if (!"".equals(bean.getNomProjet()) && !this.getNOM_PROJET().trim().equals(bean.getNomProjet())) { //Needs more
        //        return false;
        //} 
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += this.getACCOUNT_ID().hashCode();
        return hash;
    }
    
}
