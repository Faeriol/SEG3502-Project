package org.opr;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.opr.Persistance.Users.AccountT;
import org.opr.Persistance.Users.UserT;

/**
 *
 * @author faeriol
 */
@Named(value = "system")
@RequestScoped
public class System {
    @Inject
    private Account userAccount;
    @Inject
    private Property property;
    @Inject
    private Address address;
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
        if (DBHelper.addUser(em, utx, userAccount)) {
            userAccount.setStatus("Creation Successful");
        } else {
            userAccount.setStatus("Creation Unsuccessful");
        }
    }
    
    public void updateAccount() {
        if(userAccount.getPassword().isEmpty() && userAccount.getEmail().isEmpty()) {
            userAccount.setStatus("No changes - Update not performed");
        } else {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            UserT tUser = (UserT) session.getAttribute("User");
            if (DBHelper.updateAccount(em, utx, tUser.getACCOUNT().getACCOUNT_ID(), userAccount)) {
                userAccount.setStatus("Update Successful");
            } else {
                userAccount.setStatus("Update Unsuccessful");
            }
        }
    }
    
    public void deleteAccount() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        UserT tUser = (UserT) session.getAttribute("User");
        
        if (DBHelper.deleteAccount(em, utx, tUser.getACCOUNT().getUSER_NAME())) {
            userAccount.setStatus("Delete Successful");
            logout();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Login.xhtml");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            userAccount.setStatus("Delete Unsuccessful");
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

    private void deleteProperty(Property property){
        // Implement
    }
    
    private void updateProperty(Account account, Property property){
        // Implement
    }
    
    private Account findAccount(String username){
        return null;
    }
    
    private Account findAccount(Account account){
        return null;
    }
    
    private void viewVisitingList(Account account){
        
    }
    
    private List<Property> findPropertyByLocation(String location)
    {
        List<Property> pro= DBHelper.findAllProperty(em,location);
        return pro;
    }

    public void login() {
        UserT tUser = null;
        AccountT acc = DBHelper.findAccount(em, userAccount.getUserName());

        if (acc != null) {
            if (acc.getTYPE().equals("owner")) {
                tUser = DBHelper.findOwner(em, userAccount.getUserName());
            } else {
                tUser = DBHelper.findCustomer(em, userAccount.getUserName());
            }
            
            if (userAccount.getPassword().equals(tUser.getACCOUNT().getPASSWORD())) {
                //login ok - set user in session context
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("User", tUser);
                userAccount.setStatus("Login Successful");

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
                userAccount.setStatus("Login Unsuccessful - Wrong Password");
            }
        } else {
            userAccount.setStatus("Login Unsuccessful - Account Not Found");
        }
    }

    public void logout() {
        // invalidate session to remove User
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        // navigate to index - see faces-config.xml for navigation rules
        userAccount.setStatus("Logout Successful");
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
    
    
}