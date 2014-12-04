/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.opr.Persistance.DBHelper;

/**
 *
 * @author Vlado
 */
@ManagedBean
@FacesConverter("PropConverter")
public class PropertyConverter implements Converter {
    @PersistenceContext(unitName="OnlinePropertyRentalPU")
    private EntityManager  em;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        System.out.println(DBHelper.findProperty(em, string.substring(string.indexOf("=") + 1, string.indexOf("]"))));
        return DBHelper.findProperty(em, string.substring(string.indexOf("=") + 1, string.indexOf("]")));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return o.toString();
    }
    
}
