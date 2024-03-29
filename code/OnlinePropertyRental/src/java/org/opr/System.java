package org.opr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.opr.Beans.Agency;
import org.opr.Beans.Rental.Property;
import org.opr.Beans.Users.Account;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.transaction.UserTransaction;
import org.opr.Beans.Users.User;
import org.opr.Beans.util.Address;
import org.opr.Persistance.DBHelper;
import org.opr.Persistance.Rental.PropertyT;
import org.opr.Persistance.Users.AccountT;
import org.opr.Persistance.Users.UserT;
import org.opr.Persistance.util.PictureT;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author faeriol
 */
@Named(value = "system")
@RequestScoped
public class System {
    @Inject
    private Account account;
    @Inject
    private Property property;
    @Inject
    private Address address;
    private List<Property> propreties;

    private long upperRent;
    private long lowerRent;
    
    @PersistenceContext(unitName = "OnlinePropertyRentalPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    
    //private List<Account> accounts; In DB
    //private List<Agency> agencies; In DB
    
    
    private void addPropertyVisitList(Property property){
        //!?
    }
    
    public void createAccount(){
        if (DBHelper.addUser(em, utx, account)) {
            account.setStatus("Creation Successful");
        } else {
            account.setStatus("Creation Unsuccessful");
        }
    }
    
    public void updateAccount() {
        if(account.getPassword().isEmpty() && account.getEmail().isEmpty()) {
            account.setStatus("No changes - Update not performed");
        } else {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            UserT tUser = (UserT) session.getAttribute("User");
            if (DBHelper.updateAccount(em, utx, tUser.getACCOUNT().getACCOUNT_ID(), account)) {
                account.setStatus("Update Successful");
            } else {
                account.setStatus("Update Unsuccessful");
            }
        }
    }
    
    public void deleteAccount() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        UserT tUser = (UserT) session.getAttribute("User");
        
        if (DBHelper.deleteAccount(em, utx, tUser.getACCOUNT().getUSER_NAME())) {
            account.setStatus("Delete Successful");
            logout();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Login.xhtml");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            account.setStatus("Delete Unsuccessful");
        }
    }
    
    public void createProperty() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        UserT tUser = (UserT) session.getAttribute("User");
        if (DBHelper.addProperty(em, utx, property, address, tUser.getACCOUNT().getUSER_NAME())) {
            property.setStatus("Creation Successful");
        } else {
            property.setStatus("Creation Unsuccessful");
        }
    }

    public void redirectUpdateProperty() {
        PropertyT tProperty = DBHelper.findProperty(em, property.getID());
        if (tProperty != null) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("UserProperty", tProperty);
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("UpdateProperty2.xhtml");
            } catch(IOException ex) {
                property.setStatus("Unable to redirect");
            }
        } else {
            property.setStatus("Property Not Found");
        }
    }

    public void redirectFindProperty() {
        if(!property.getType().isEmpty()) {
            DBHelper.print(String.valueOf(DBHelper.findAllPropertyType(em, property.getType()).size()));
        }
    }
    
    public void systemLoad() {
        if (FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo().contains("ViewProperties.xhtml")
                || FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo().contains("DeleteProperty.xhtml")
                || FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo().contains("UpdateProperty.xhtml")) {
            propreties = DBHelper.findAllProperty(em);
        } 
    }

    public StreamedContent getPropertyImage() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        } else {
            String pictureId = context.getExternalContext().getRequestParameterMap().get("pictureID");
            PictureT tPicture= DBHelper.findPicture(em, pictureId);
            return new DefaultStreamedContent(new ByteArrayInputStream(tPicture.getPICTURE_DATA()));
        }
    }

    public void deleteProperty(){
        if (DBHelper.deleteProperty(em, utx, property.getID())) {
            property.setStatus("Delete Successful");
        } else {
            property.setStatus("Delete Unsuccessful");
        }
    }

    public void updateProperty(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        PropertyT tProperty = (PropertyT) session.getAttribute("UserProperty");
        if(DBHelper.updateProperty(em, utx, tProperty.getPROPERTY_ID(), property)) {
            property.setStatus("Update Successful");
        } else {
            property.setStatus("Update Unsuccessful");
        }
    }
    
    private Account findAccount(String username){
        return null;
    }
    
    private Account findAccount(Account account){
        return null;
    }
    
    private void viewVisitingList(Account account){
        
    }

    public void findPropertyByLocation()
    {
        List<PropertyT> pro= DBHelper.findAllProperty(em,address.getVille());
        property.setLookupResults(pro);
        
    }
    
    public void findOwnedProperty() {
        List<PropertyT> pro = DBHelper.findOwnedProperty(em, account);
        property.setLookupResults(pro);
    }

    public void login() {
        UserT tUser = null;
        AccountT acc = DBHelper.findAccount(em, account.getUserName());

        if (acc != null) {
            if (acc.getTYPE().equals("owner")) {
                tUser = DBHelper.findOwner(em, account.getUserName());
            } else {
                tUser = DBHelper.findCustomer(em, account.getUserName());
            }
            
            if (account.getPassword().equals(tUser.getACCOUNT().getPASSWORD())) {
                //login ok - set user in session context
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("User", tUser);
                account.setStatus("Login Successful");

                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                try {
                    if (tUser.getACCOUNT().getTYPE().equals("customer")) {
                        context.redirect("protected/customerIndex.xhtml");
                    } else if (tUser.getACCOUNT().getTYPE().equals("owner")) {
                        context.redirect("protected/ownerIndex.xhtml");
                    } else {
                        throw new IOException("The type of the account does not follow defined convention");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                account.setStatus("Login Unsuccessful - Wrong Password");
            }
        } else {
            account.setStatus("Login Unsuccessful - Account Not Found");
        }
    }

    public void logout() {
        // invalidate session to remove User
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        // navigate to index - see faces-config.xml for navigation rules
        account.setStatus("Logout Successful");
    }

    public void persist(Object object) {
        /* Add this to the deployment descriptor of this module (e.g. web.xml, ejb-jar.xml):
         * <persistence-context-ref>
         * <persistence-context-ref-name>persistence/LogicalName</persistence-context-ref-name>
         * <persistence-unit-name>OnlinePropertyRentalPU</persistence-unit-name>
         * </persistence-context-ref>
         * <resource-ref>
         * <res-ref-name>UserTransaction</res-ref-name>
         * <res-type>javax.transaction.UserTransaction</res-type>
         * <res-auth>Container</res-auth>
         * </resource-ref> */
        try {
            Context ctx = new InitialContext();
            UserTransaction utx = (UserTransaction) ctx.lookup("java:comp/env/UserTransaction");
            utx.begin();
            EntityManager em = (EntityManager) ctx.lookup("java:comp/env/persistence/LogicalName");
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    public void persist1(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    public List<Property> getPropreties() {
        return propreties;
    }

    public void setPropreties(List<Property> propreties) {
        this.propreties = propreties;
    }
    
    public long getUpperRent() {
        return upperRent;
    }

    public void setUpperRent(long upperRent) {
        this.upperRent = upperRent;
    }

    public long getLowerRent() {
        return lowerRent;
    }

    public void setLowerRent(long lowerRent) {
        this.lowerRent = lowerRent;
    }
}