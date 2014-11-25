package org.opr.Persistance.Rental;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.opr.Beans.Rental.Lease;
import org.opr.Persistance.Users.CustomerT;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="Lease")
public class LeaseT implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String LEASE_ID;
    private Date RENTAL_DATE;
    private long RENTAL_TIME;
    @OneToOne
    private CustomerT RENTER;
    @OneToOne
    private PropertyT LEASED_PROPERTY;
    private float RENT;
    
    @Override
    public String toString() {
        return "persistence.Adress[id=" + this.getLEASE_ID() + "]";
    }

    /**
     * @return the LEASE_ID
     */
    public String getLEASE_ID() {
        return LEASE_ID;
    }

    /**
     * @param LEASE_ID the LEASE_ID to set
     */
    public void setLEASE_ID(String LEASE_ID) {
        this.LEASE_ID = LEASE_ID;
    }

    /**
     * @return the RENTAL_DATE
     */
    public Date getRENTAL_DATE() {
        return RENTAL_DATE;
    }

    /**
     * @param RENTAL_DATE the RENTAL_DATE to set
     */
    public void setRENTAL_DATE(Date RENTAL_DATE) {
        this.RENTAL_DATE = RENTAL_DATE;
    }

    /**
     * @return the RENTAL_TIME
     */
    public long getRENTAL_TIME() {
        return RENTAL_TIME;
    }

    /**
     * @param RENTAL_TIME the RENTAL_TIME to set
     */
    public void setRENTAL_TIME(long RENTAL_TIME) {
        this.RENTAL_TIME = RENTAL_TIME;
    }

    /**
     * @return the RENTER
     */
    public CustomerT getRENTER() {
        return RENTER;
    }

    /**
     * @param RENTER the RENTER to set
     */
    public void setRENTER(CustomerT RENTER) {
        this.RENTER = RENTER;
    }

    /**
     * @return the LEASED_PROPERTY
     */
    public PropertyT getLEASED_PROPERTY() {
        return LEASED_PROPERTY;
    }

    /**
     * @param LEASED_PROPERTY the LEASED_PROPERTY to set
     */
    public void setLEASED_PROPERTY(PropertyT LEASED_PROPERTY) {
        this.LEASED_PROPERTY = LEASED_PROPERTY;
    }

    /**
     * @return the RENT
     */
    public float getRENT() {
        return RENT;
    }

    /**
     * @param RENT the RENT to set
     */
    public void setRENT(float RENT) {
        this.RENT = RENT;
    }
    
    public boolean matches(Lease bean) {
        if (null!=bean.getID() && !"".equals(bean.getID()) && !this.getLEASE_ID().trim().equals(bean.getID().trim())) {
            return false;
        } //else if (!"".equals(bean.getNomProjet()) && !this.getNOM_PROJET().trim().equals(bean.getNomProjet())) { //Needs more
        //        return false;
        //} 
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += this.getLEASE_ID().hashCode();
        return hash;
    }
    
}
