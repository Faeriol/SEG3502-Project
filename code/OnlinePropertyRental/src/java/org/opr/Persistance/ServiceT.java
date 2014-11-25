package org.opr.Persistance;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.opr.Beans.Service;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="Service")
public class ServiceT implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int SERVICE_ID;
    private String NAME;
    
    @Override
    public String toString() {
        return "persistence.Service[id=" + this.getSERVICE_ID() + "]";
    }

    /**
     * @return the SERVICE_ID
     */
    public int getSERVICE_ID() {
        return SERVICE_ID;
    }

    /**
     * @param SERVICE_ID the SERVICE_ID to set
     */
    public void setSERVICE_ID(int SERVICE_ID) {
        this.SERVICE_ID = SERVICE_ID;
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
    
    public boolean matches(Service service) {
        // IMPLEMENT!!!
        //if (null!=projetData.getProjetID() && !"".equals(projetData.getProjetID()) && !this.getPROJET_ID().trim().equals(projetData.getProjetID().trim())) {
        //    return false;
        //} else if (!"".equals(projetData.getNomProjet()) && !this.getNOM_PROJET().trim().equals(projetData.getNomProjet())) {
        //        return false;
        //} 
        return true;
    }

}
