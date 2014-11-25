package org.opr.Persistance;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.opr.Persistance.Rental.PropertyT;
import org.opr.Persistance.Users.AgentT;
import org.opr.Persistance.Users.CustomerT;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="Visit")
public class VisitT {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int VISIT_ID;
    private Date DATE;
    private CustomerT PROSPECT;
    private AgentT REP;
    private PropertyT PROPERTY;

    /**
     * @return the VISIT_ID
     */
    public int getVISIT_ID() {
        return VISIT_ID;
    }

    /**
     * @param VISIT_ID the VISIT_ID to set
     */
    public void setVISIT_ID(int VISIT_ID) {
        this.VISIT_ID = VISIT_ID;
    }

    /**
     * @return the DATE
     */
    public Date getDATE() {
        return DATE;
    }

    /**
     * @param DATE the DATE to set
     */
    public void setDATE(Date DATE) {
        this.DATE = DATE;
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

}
