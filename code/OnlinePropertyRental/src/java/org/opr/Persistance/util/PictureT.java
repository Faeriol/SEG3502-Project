package org.opr.Persistance.util;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.opr.Beans.util.Picture;

/**
 * Right now, you are getting this and its pretty much it.
 * I am not dealing with file-object management
 * @author faeriol
 */
@Entity
@Table(name="Picture")
public class PictureT implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String PICTURE_ID;
    private byte[] PICTURE_DATA;

    /**
     * @return the PICTURE_ID
     */
    public String getPICTURE_ID() {
        return PICTURE_ID;
    }

    /**
     * @param PICTURE_ID the PICTURE_ID to set
     */
    public void setPICTURE_ID(String PICTURE_ID) { 
        this.PICTURE_ID = PICTURE_ID;
    }

    /**
     * @return the PICTURE_DATA
     */
    public byte[] getPICTURE_DATA() { return PICTURE_DATA; }

    /**
     * @param PICTURE_DATA the PICTURE_DATA to set
     */
    public void setPICTURE_DATA(byte[] PICTURE_DATA) {
        this.PICTURE_DATA = PICTURE_DATA;
    }

    public boolean matches(Picture picture) {
        // IMPLEMENT!!!
        //if (null!=projetData.getProjetID() && !"".equals(projetData.getProjetID()) && !this.getPROJET_ID().trim().equals(projetData.getProjetID().trim())) {
        //    return false;
        //} else if (!"".equals(projetData.getNomProjet()) && !this.getNOM_PROJET().trim().equals(projetData.getNomProjet())) {
        //        return false;
        //} 
        return true;
    }
}
