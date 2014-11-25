package org.opr.Beans.util;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.util.AddressT;

/**
 * Just representing Addresses...
 * Imported from Lab5
 * @author faeriol
 */
@Named(value = "address")
@RequestScoped
public class Address {
    private String ID;
    private int numeroRue;
    private String nomRue;
    private String numeroUnite;
    private String ville;
    private String province;
    private String postalCode;
    
    private List<AddressT> lookupResults;

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the numeroRue
     */
    public int getNumeroRue() {
        return numeroRue;
    }

    /**
     * @param numeroRue the numeroRue to set
     */
    public void setNumeroRue(int numeroRue) {
        this.numeroRue = numeroRue;
    }

    /**
     * @return the nomRue
     */
    public String getNomRue() {
        return nomRue;
    }

    /**
     * @param nomRue the nomRue to set
     */
    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    /**
     * @return the numeroUnite
     */
    public String getNumeroUnite() {
        return numeroUnite;
    }

    /**
     * @param numeroUnite the numeroUnite to set
     */
    public void setNumeroUnite(String numeroUnite) {
        this.numeroUnite = numeroUnite;
    }

    /**
     * @return the ville
     */
    public String getVille() {
        return ville;
    }

    /**
     * @param ville the ville to set
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public void setLookupResults(List<AddressT> results) {
        this.lookupResults = results;
    }
    
    public List<AddressT> getLookupResults() {
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
