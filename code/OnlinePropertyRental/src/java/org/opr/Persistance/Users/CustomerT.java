package org.opr.Persistance.Users;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.opr.Persistance.Rental.LeaseT;
import org.opr.Persistance.Rental.PreferencesT;
import org.opr.Persistance.Rental.PropertyT;
import org.opr.Persistance.VisitT;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="Customer")
public class CustomerT extends UserT implements Serializable {
    @OneToMany(mappedBy = "PROSPECT") // STUFF BELLOW IS BROKEN!
    private List<VisitT> visitTs;
    
    //@Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    //private int CUSTOMER_ID;
    @OneToOne
    private PreferencesT HOUSING_PREFERENCE;
    @OneToMany
    private List<PropertyT> VISIT_LIST;
    @OneToOne
    private LeaseT CURRENT_LEASE;


    /**
     * @return the HOUSING_PREFERENCE
     */
    public PreferencesT getHOUSING_PREFERENCE() {
        return HOUSING_PREFERENCE;
    }

    /**
     * @param HOUSING_PREFERENCE the HOUSING_PREFERENCE to set
     */
    public void setHOUSING_PREFERENCE(PreferencesT HOUSING_PREFERENCE) {
        this.HOUSING_PREFERENCE = HOUSING_PREFERENCE;
    }

    /**
     * @return the VISIT_LIST
     */
    public List<PropertyT> getVISIT_LIST() {
        return VISIT_LIST;
    }

    /**
     * @param VISIT_LIST the VISIT_LIST to set
     */
    public void setVISIT_LIST(List<PropertyT> VISIT_LIST) {
        this.VISIT_LIST = VISIT_LIST;
    }

    /**
     * @return the CURRENT_LEASE
     */
    public LeaseT getCURRENT_LEASE() {
        return CURRENT_LEASE;
    }

    /**
     * @param CURRENT_LEASE the CURRENT_LEASE to set
     */
    public void setCURRENT_LEASE(LeaseT CURRENT_LEASE) {
        this.CURRENT_LEASE = CURRENT_LEASE;
    }

    /**
     * @return the visitTs
     */
    public List<VisitT> getVisitTs() {
        return visitTs;
    }

    /**
     * @param visitTs the visitTs to set
     */
    public void setVisitTs(List<VisitT> visitTs) {
        this.visitTs = visitTs;
    }
}
