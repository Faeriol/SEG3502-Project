package org.opr.Persistance.Finance;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.opr.Beans.Finance.Transaction;
import org.opr.Persistance.AgencyT;
import org.opr.Persistance.Users.UserT;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="Transaction")
public class TransactionT implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String TRANSACTION_ID;
    private float AMOUNT;
    private String FINANCIAL_INSTITUTION;
    @OneToOne
    private UserT USR;
    @OneToOne
    private AgencyT AGENCY;
    
    @Override
    public String toString() {
        return "persistence.Transaction[id=" + this.getTRANSACTION_ID() + "]";
    }

    /**
     * @return the TRANSACTION_ID
     */
    public String getTRANSACTION_ID() {
        return TRANSACTION_ID;
    }

    /**
     * @param TRANSACTION_ID the TRANSACTION_ID to set
     */
    public void setTRANSACTION_ID(String TRANSACTION_ID) {
        this.TRANSACTION_ID = TRANSACTION_ID;
    }

    /**
     * @return the AMOUNT
     */
    public float getAMOUNT() {
        return AMOUNT;
    }

    /**
     * @param AMOUNT the AMOUNT to set
     */
    public void setAMOUNT(float AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    /**
     * @return the FINANCIAL_INSTITUTION
     */
    public String getFINANCIAL_INSTITUTION() {
        return FINANCIAL_INSTITUTION;
    }

    /**
     * @param FINANCIAL_INSTITUTION the FINANCIAL_INSTITUTION to set
     */
    public void setFINANCIAL_INSTITUTION(String FINANCIAL_INSTITUTION) {
        this.FINANCIAL_INSTITUTION = FINANCIAL_INSTITUTION;
    }

    /**
     * @return the USR
     */
    public UserT getUSR() {
        return USR;
    }

    /**
     * @param USR the USR to set
     */
    public void setUSR(UserT USR) {
        this.USR = USR;
    }

    /**
     * @return the AGENCY
     */
    public AgencyT getAGENCY() {
        return AGENCY;
    }

    /**
     * @param AGENCY the AGENCY to set
     */
    public void setAGENCY(AgencyT AGENCY) {
        this.AGENCY = AGENCY;
    }
    
    public boolean matches(Transaction bean) {
        if (null!=bean.getID() && !"".equals(bean.getID()) && !this.getTRANSACTION_ID().trim().equals(bean.getID().trim())) {
            return false;
        } //else if (!"".equals(bean.getNomProjet()) && !this.getNOM_PROJET().trim().equals(bean.getNomProjet())) { //Needs more
        //        return false;
        //} 
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += this.getTRANSACTION_ID().hashCode();
        return hash;
    }
    
}
