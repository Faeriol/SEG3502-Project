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
    private String SERVICE_ID;
    private String NAME;
    
    @Override
    public String toString() {
        return "persistence.Service[id=" + this.getSERVICE_ID() + "]";
    }

    /**
     * @return the SERVICE_ID
     */
    public String getSERVICE_ID() {
        return SERVICE_ID;
    }

    /**
     * @param SERVICE_ID the SERVICE_ID to set
     */
    public void setSERVICE_ID(String SERVICE_ID) {
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
    
    public boolean matches(Service bean) {
        if (null!=bean.getID() && !"".equals(bean.getID()) && !this.getSERVICE_ID().trim().equals(bean.getID().trim())) {
            return false;
        } //else if (!"".equals(bean.getNomProjet()) && !this.getNOM_PROJET().trim().equals(bean.getNomProjet())) { //Needs more
        //        return false;
        //} 
        return true;
    }
    
        @Override
    public int hashCode() {
        int hash = 0;
        hash += this.getSERVICE_ID().hashCode();
        return hash;
    }

}
