package org.opr.Persistance;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.opr.Persistance.util.AddressT;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="Agency")
public class AgencyT {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int AGENCY_ID;
    private String NAME;
    private AddressT ADDRESS;
    
    @Override
    public String toString() {
        return "persistence.Agency[id=" + this.getAGENCY_ID() + "]";
    }

    /**
     * @return the AGENCY_ID
     */
    public int getAGENCY_ID() {
        return AGENCY_ID;
    }

    /**
     * @param AGENCY_ID the AGENCY_ID to set
     */
    public void setAGENCY_ID(int AGENCY_ID) {
        this.AGENCY_ID = AGENCY_ID;
    }

    /**
     * @return the NAME
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * @param NAME the NAME to set
     */
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    /**
     * @return the ADDRESS
     */
    public AddressT getADDRESS() {
        return ADDRESS;
    }

    /**
     * @param ADDRESS the ADDRESS to set
     */
    public void setADDRESS(AddressT ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

}
