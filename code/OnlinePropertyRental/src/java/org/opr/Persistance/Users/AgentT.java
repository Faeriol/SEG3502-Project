package org.opr.Persistance.Users;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.opr.Beans.Users.Agent;
import org.opr.Persistance.VisitT;

/**
 * Used mainly to check type when giving rights?
 * @author faeriol
 */
@Entity
@Table(name="Agent")
public class AgentT extends UserT implements Serializable {
    @OneToMany(mappedBy = "REP")
    private List<VisitT> visitTs;

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
    
    public boolean matches(Agent bean) {
        if (null!=bean.getID() && !"".equals(bean.getID()) && !this.getUSER_ID().trim().equals(bean.getID().trim())) {
            return false;
        } //else if (!"".equals(bean.getNomProjet()) && !this.getNOM_PROJET().trim().equals(bean.getNomProjet())) { //Needs more
        //        return false;
        //} 
        return true;
    }
}
