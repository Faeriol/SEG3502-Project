package org.opr;

import java.util.List;
import org.opr.Beans.Agency;
import org.opr.Beans.Rental.Property;
import org.opr.Beans.Users.Account;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.opr.Persistance.DBHelper;

/**
 *
 * @author faeriol
 */
@Named(value = "system")
@RequestScoped
public class System {
    
    //private List<Account> accounts; In DB
    //private List<Agency> agencies; In DB
    
    
    private void addPropertyVisitList(Property property){
        //!?
    }
    
    private void addProperty(/**/){
        // Implement!
    }
    
    private void createAccount(Account info){
        // Handle
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
    
    private boolean login(String username, String password){
        return false;
    }
    
    private void logout(){
        
    }
    
    
}
