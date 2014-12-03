package org.opr.Persistance.Rental;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.opr.Beans.Rental.Property;
import org.opr.Persistance.Users.AccountT;
import org.opr.Persistance.Users.OwnerT;
import org.opr.Persistance.VisitT;
import org.opr.Persistance.util.AddressT;
import org.opr.Persistance.util.PictureT;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="Property")
public class PropertyT implements Serializable {
    @OneToMany(mappedBy = "PROPERTY")
    private List<VisitT> visitTs;
    @ManyToOne(cascade = CascadeType.ALL)
    private OwnerT ownerT;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String PROPERTY_ID;
    @OneToOne(cascade = CascadeType.ALL)
    private AddressT ADDRESS;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PictureT> pictures;
    private String TYPE;
    private short NB_BEDROOMS, NB_BATHROOMS, NB_OTHERS;
    private float RENT;

    /**
     * @return the PROPERTY_ID
     */
    public String getPROPERTY_ID() {
        return PROPERTY_ID;
    }

    /**
     * @param PROPERTY_ID the PROPERTY_ID to set
     */
    public void setPROPERTY_ID(String PROPERTY_ID) {
        this.PROPERTY_ID = PROPERTY_ID;
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

    /**
     * @return the TYPE
     */
    public String getTYPE() {
        return TYPE;
    }

    /**
     * @param TYPE the TYPE to set
     */
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
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
     * @return the NB_OTHERS
     */
    public short getNB_OTHERS() {
        return NB_OTHERS;
    }

    /**
     * @param NB_OTHERS the NB_OTHERS to set
     */
    public void setNB_OTHERS(short NB_OTHERS) {
        this.NB_OTHERS = NB_OTHERS;
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
    
    @Override
    public String toString() {
        return "persistence.Property[id=" + this.getPROPERTY_ID() + "]";
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

    /**
     * @return the ownerT
     */
    public OwnerT getOwnerT() {
        return ownerT;
    }

    /**
     * @param ownerT the ownerT to set
     */
    public void setOwnerT(OwnerT ownerT) {
        this.ownerT = ownerT;
    }

    /**
     * @return the pictures
     */
    public List<PictureT> getPICTURES() {
        return pictures;
    }

    /**
     * @param pictures the pictures to set
     */
    public void setPICTURES(List<PictureT> pictures) {
        this.pictures = pictures;
    }
    
    public boolean matches(Property bean) {
        if (null!=bean.getID() && !"".equals(bean.getID()) && !this.getPROPERTY_ID().trim().equals(bean.getID().trim())) {
            return false;
        } //else if (!"".equals(bean.getNomProjet()) && !this.getNOM_PROJET().trim().equals(bean.getNomProjet())) { //Needs more
        //        return false;
        //} 
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += this.getPROPERTY_ID().hashCode();
        return hash;
    }
    
}
