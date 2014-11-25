package org.opr.Persistance.Users;

import java.util.List;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.opr.Persistance.Rental.PropertyT;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="Owner")
public class OwnerT extends UserT implements Serializable {
    
    @OneToMany(mappedBy = "ownerT")
    private List<PropertyT> PROPERTIES;

    /**
     * @return the PROPERTIES
     */
    public List<PropertyT> getPROPERTIES() {
        return PROPERTIES;
    }

    /**
     * @param PROPERTIES the PROPERTIES to set
     */
    public void setPROPERTIES(List<PropertyT> PROPERTIES) {
        this.PROPERTIES = PROPERTIES;
    }
    
}
