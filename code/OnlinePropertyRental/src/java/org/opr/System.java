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
import javax.transaction.UserTransaction;
import org.opr.Beans.Users.User;
import org.opr.Persistance.DBHelper;
import org.opr.Persistance.Users.AccountT;

/**
 *
 * @author faeriol
 */
@Named(value = "system")
@RequestScoped
public class System {
    @Inject
    private Account userAccount;
    @PersistenceContext(unitName = "OnlinePropertyRentalPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    //private List<Account> accounts; In DB
    //private List<Agency> agencies; In DB
    
    
    private void addPropertyVisitList(Property property){
        //!?
    }
    
    private void addProperty(/**/){
        // Implement!
    }
    
    public void createAccount(){
        if (DBHelper.addAccount(em, utx, userAccount)) {
            userAccount.setStatus("Creation Successful");
        } else {
            userAccount.setStatus("Creation Unsuccessful");
        }
    }
    
    public void updateAccount() {
        DBHelper.print(userAccount.getPassword());
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

    public void login() {
        AccountT acc = DBHelper.findAccount(em, userAccount.getUserName());
        if (acc != null) {
            if (userAccount.getPassword().equals(acc.getPASSWORD())) {
                //login ok - set user in session context
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("Account", acc);
                userAccount.setStatus("Login Successful");

                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                try {
                    if(acc.getTYPE().equals("customer")) {
                        context.redirect("protected/customerIndex.xhtml");
                    } else if(acc.getTYPE().equals("owner")) {
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
    
    public void logout(){
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