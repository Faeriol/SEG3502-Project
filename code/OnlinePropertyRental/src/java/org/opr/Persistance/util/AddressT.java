package org.opr.Persistance.util;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Just something to represent an address...
 * Imported from Lab5 content.
 * @author faeriol
 */
@Entity
@Table(name="Adress")
public class AddressT implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String ADDRESS_ID;
    private int NUMERO_RUE;
    private String NOM_RUE;
    private String NUMERO_UNITE;
    private String VILLE;
    private String PROVINCE;
    private String POSTAL_CODE;

    /**
     * @return the NUMERO_RUE
     */
    public int getNUMERO_RUE() {
        return NUMERO_RUE;
    }

    /**
     * @param NUMERO_RUE the NUMERO_RUE to set
     */
    public void setNUMERO_RUE(int NUMERO_RUE) {
        this.NUMERO_RUE = NUMERO_RUE;
    }

    /**
     * @return the NOM_RUE
     */
    public String getNOM_RUE() {
        return NOM_RUE;
    }

    /**
     * @param NOM_RUE the NOM_RUE to set
     */
    public void setNOM_RUE(String NOM_RUE) {
        this.NOM_RUE = NOM_RUE;
    }

    /**
     * @return the NUMERO_UNITE
     */
    public String getNUMERO_UNITE() {
        return NUMERO_UNITE;
    }

    /**
     * @param NUMERO_UNITE the NUMERO_UNITE to set
     */
    public void setNUMERO_UNITE(String NUMERO_UNITE) {
        this.NUMERO_UNITE = NUMERO_UNITE;
    }

    /**
     * @return the VILLE
     */
    public String getVILLE() {
        return VILLE;
    }

    /**
     * @param VILLE the VILLE to set
     */
    public void setVILLE(String VILLE) {
        this.VILLE = VILLE;
    }

    /**
     * @return the PROVINCE
     */
    public String getPROVINCE() {
        return PROVINCE;
    }

    /**
     * @param PROVINCE the PROVINCE to set
     */
    public void setPROVINCE(String PROVINCE) {
        this.PROVINCE = PROVINCE;
    }

    /**
     * @return the POSTAL_CODE
     */
    public String getPOSTAL_CODE() {
        return POSTAL_CODE;
    }

    /**
     * @param POSTAL_CODE the POSTAL_CODE to set
     */
    public void setPOSTAL_CODE(String POSTAL_CODE) {
        this.POSTAL_CODE = POSTAL_CODE;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += this.getADDRESS_ID().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AddressT other = (AddressT) obj;
        if (!Objects.equals(this.ADDRESS_ID, other.ADDRESS_ID)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "persistence.Adress[id=" + this.getADDRESS_ID() + "]";
    }

    /**
     * @return the ADDRESS_ID
     */
    public String getADDRESS_ID() {
        return ADDRESS_ID;
    }

    /**
     * @param ADDRESS_ID the ADDRESS_ID to set
     */
    public void setADDRESS_ID(String ADDRESS_ID) {
        this.ADDRESS_ID = ADDRESS_ID;
    }
    

}
