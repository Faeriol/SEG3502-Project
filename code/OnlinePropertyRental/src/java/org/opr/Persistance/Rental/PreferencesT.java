package org.opr.Persistance.Rental;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.opr.Beans.Rental.Preferences;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="Preferences")
public class PreferencesT implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int PREFERENCE_ID;
    private short NB_BATHROOMS, NB_BEDROOMS, NB_OTHER;
    private String LOCATION;
    
    @Override
    public String toString() {
        return "persistence.Preference[id=" + this.getPREFERENCE_ID() + "]";
    }

    /**
     * @return the PREFERENCE_ID
     */
    public int getPREFERENCE_ID() {
        return PREFERENCE_ID;
    }

    /**
     * @param PREFERENCE_ID the PREFERENCE_ID to set
     */
    public void setPREFERENCE_ID(int PREFERENCE_ID) {
        this.PREFERENCE_ID = PREFERENCE_ID;
    }

    /**
     * @return the NB_BATHROOMS
     */
    public short getNB_BATHROOMS() {
        return NB_BATHROOMS;
    }

    /**
     * @param NB_BATHROOMS the NB_BATHROOMS to set
     */
    public void setNB_BATHROOMS(short NB_BATHROOMS) {
        this.NB_BATHROOMS = NB_BATHROOMS;
    }

    /**
     * @return the NB_BEDROOMS
     */
    public short getNB_BEDROOMS() {
        return NB_BEDROOMS;
    }

    /**
     * @param NB_BEDROOMS the NB_BEDROOMS to set
     */
    public void setNB_BEDROOMS(short NB_BEDROOMS) {
        this.NB_BEDROOMS = NB_BEDROOMS;
    }

    /**
     * @return the NB_OTHER
     */
    public short getNB_OTHER() {
        return NB_OTHER;
    }

    /**
     * @param NB_OTHER the NB_OTHER to set
     */
    public void setNB_OTHER(short NB_OTHER) {
        this.NB_OTHER = NB_OTHER;
    }

    /**
     * @return the LOCATION
     */
    public String getLOCATION() {
        return LOCATION;
    }

    /**
     * @param LOCATION the LOCATION to set
     */
    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }
    
    public boolean matches(Preferences preferences) {
        // IMPLEMENT!!!
        //if (null!=projetData.getProjetID() && !"".equals(projetData.getProjetID()) && !this.getPROJET_ID().trim().equals(projetData.getProjetID().trim())) {
        //    return false;
        //} else if (!"".equals(projetData.getNomProjet()) && !this.getNOM_PROJET().trim().equals(projetData.getNomProjet())) {
        //        return false;
        //} 
        return true;
    }
}
