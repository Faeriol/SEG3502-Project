package org.opr.Persistance;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.opr.Beans.Visit;
import org.opr.Persistance.Rental.PropertyT;
import org.opr.Persistance.Users.AgentT;
import org.opr.Persistance.Users.CustomerT;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="Visit")
public class VisitT implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String VISIT_ID;
    private Date VISIT_DATE;
    @ManyToOne
    private CustomerT PROSPECT;
    @ManyToOne
    private AgentT REP;
    @ManyToOne
    private PropertyT PROPERTY;

    /**
     * @return the VISIT_ID
     */
    public String getVISIT_ID() {
        return VISIT_ID;
    }

    /**
     * @param VISIT_ID the VISIT_ID to set
     */
    public void setVISIT_ID(String VISIT_ID) {
        this.VISIT_ID = VISIT_ID;
    }

    /**
     * @return the PROSPECT
     */
    public CustomerT getPROSPECT() {
        return PROSPECT;
    }

    /**
     * @param PROSPECT the PROSPECT to set
     */
    public void setPROSPECT(CustomerT PROSPECT) {
        this.PROSPECT = PROSPECT;
    }

    /**
     * @return the REP
     */
    public AgentT getREP() {
        return REP;
    }

    /**
     * @param REP the REP to set
     */
    public void setREP(AgentT REP) {
        this.REP = REP;
    }

    /**
     * @return the PROPERTY
     */
    public PropertyT getPROPERTY() {
        return PROPERTY;
    }

    /**
     * @param PROPERTY the PROPERTY to set
     */
    public void setPROPERTY(PropertyT PROPERTY) {
        this.PROPERTY = PROPERTY;
    }
    
    @Override
    public String toString() {
        return "persistence.Visit[id=" + this.getVISIT_ID() + "]";
    }

    /**
     * @return the VISIT_DATE
     */
    public Date getVISIT_DATE() {
        return VISIT_DATE;
    }

    /**
     * @param VISIT_DATE the VISIT_DATE to set
     */
    public void setVISIT_DATE(Date VISIT_DATE) {
        this.VISIT_DATE = VISIT_DATE;
    }
    
        @Override
    public int hashCode() {
        int hash = 0;
        hash += this.getVISIT_ID().hashCode();
        return hash;
    }

    public boolean matches(Visit bean) {
        if (null!=bean.getID() && !"".equals(bean.getID()) && !this.getVISIT_ID().trim().equals(bean.getID().trim())) {
            return false;
        } //else if (!"".equals(bean.getNomProjet()) && !this.getNOM_PROJET().trim().equals(bean.getNomProjet())) { //Needs more
        //        return false;
        //} 
        return true;
    }
    
}
