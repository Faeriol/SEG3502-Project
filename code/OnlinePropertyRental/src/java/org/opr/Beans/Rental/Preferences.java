package org.opr.Beans.Rental;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.Rental.PreferencesT;

/**
 *
 * @author faeriol
 */
@Named(value = "preferences")
@RequestScoped
public class Preferences {
    private short  nbBathrooms, nbBedrooms, nbOther;
    private int    minRent, maxRent;
    private String location;

    private List<PreferencesT> lookupResults;
    
    /**
     * @return the nbBathrooms
     */
    public short getNbBathrooms() {
        return nbBathrooms;
    }

    /**
     * @param nbBathrooms the nbBathrooms to set
     */
    public void setNbBathrooms(short nbBathrooms) {
        this.nbBathrooms = nbBathrooms;
    }

    /**
     * @return the nbBedrooms
     */
    public short getNbBedrooms() {
        return nbBedrooms;
    }

    /**
     * @param nbBedrooms the nbBedrooms to set
     */
    public void setNbBedrooms(short nbBedrooms) {
        this.nbBedrooms = nbBedrooms;
    }

    /**
     * @return the nbOther
     */
    public short getNbOther() {
        return nbOther;
    }

    /**
     * @param nbOther the nbOther to set
     */
    public void setNbOther(short nbOther) {
        this.nbOther = nbOther;
    }

    /**
     * @return the minRent
     */
    public int getMinRent() {
        return minRent;
    }

    /**
     * @param minRent the minRent to set
     */
    public void setMinRent(int minRent) {
        this.minRent = minRent;
    }

    /**
     * @return the maxRent
     */
    public int getMaxRent() {
        return maxRent;
    }

    /**
     * @param maxRent the maxRent to set
     */
    public void setMaxRent(int maxRent) {
        this.maxRent = maxRent;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setLookupResults(List<PreferencesT> results) {
        this.lookupResults = results;
    }
    
    public List<PreferencesT> getLookupResults() {
        return lookupResults;
    }
    // show results if any
    public boolean getShowResults() {
        return (lookupResults != null) && !lookupResults.isEmpty();
    }
    // show message if no result
    public boolean getShowMessage() {
        return (lookupResults != null) && lookupResults.isEmpty();
    }
    
}
