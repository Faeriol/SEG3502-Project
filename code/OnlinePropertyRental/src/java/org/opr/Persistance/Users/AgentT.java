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
    
}
