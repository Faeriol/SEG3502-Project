package org.opr.Persistance;

import org.opr.Beans.*;
import org.opr.Beans.Finance.*;
import org.opr.Beans.Rental.*;
import org.opr.Beans.Users.*;
import org.opr.Beans.util.*;
import java.sql.Date;
import java.util.ArrayList;
import org.opr.Persistance.Finance.*;
import org.opr.Persistance.Rental.*;
import org.opr.Persistance.Users.*;
import org.opr.Persistance.util.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author faeriol
 */
public class DBHelper {
//AGENCY

    public static void print(String string) {
        System.out.println("efefef > " + string);
    } 
    
    public static AgencyT findAgency(EntityManager em, String id) {
        return em.find(AgencyT.class, id);
    }

    public static List findAllAgency(EntityManager em) {
        Query query = em.createQuery("SELECT A From AgencyT a");
        return query.getResultList();
    }
//Add other agency finders

    public static boolean addAgency(EntityManager em, UserTransaction utx, Agency agency) {
        System.err.println("Not implemented!");
        return false;
    }
//SERVICE

    public static ServiceT findService(EntityManager em, String id) {
        return em.find(ServiceT.class, id);
    }

    public static List findAllService(EntityManager em) {
        Query query = em.createQuery("SELECT S From ServiceT s");
        return query.getResultList();
    }
//Add other service finders

    public static boolean addService(EntityManager em, UserTransaction utx, Service service) {
        System.err.println("Not implemented!");
        return false;
    }
//VISIT

    public static VisitT findVisit(EntityManager em, String id) {
        return em.find(VisitT.class, id);
    }

    public static List findAllVisit(EntityManager em) {
        Query query = em.createQuery("SELECT V From VisitT v");
        return query.getResultList();
    }
//Add other visit finders

    public static boolean addVisit(EntityManager em, UserTransaction utx, Visit visit) {
        System.err.println("Not implemented!");
        return false;
    }
//INFORMATION

    public static InformationT findInformation(EntityManager em, String id) {
        return em.find(InformationT.class, id);
    }

    public static List findAllInformation(EntityManager em) {
        Query query = em.createQuery("SELECT A From InformationT i");
        return query.getResultList();
    }
//Add other information finders

    public static boolean addInformation(EntityManager em, UserTransaction utx, Information info) {
        System.err.println("Not implemented!");
        return false;
    }
//TRANSACTION

    public static TransactionT findTransaction(EntityManager em, String id) {
        return em.find(TransactionT.class, id);
    }

    public static List findAllTransaction(EntityManager em) {
        Query query = em.createQuery("SELECT T From TransactionT t");
        return query.getResultList();
    }
//Add other transaction finders

    public static boolean addTransaction(EntityManager em, UserTransaction utx, Transaction trans) {
        System.err.println("Not implemented!");
        return false;
    }
//LEASE

    public static LeaseT findLease(EntityManager em, String id) {
        return em.find(LeaseT.class, id);
    }

    public static List findAllLease(EntityManager em) {
        Query query = em.createQuery("SELECT L From LeaseT l");
        return query.getResultList();
    }
//Add other lease finders

    public static boolean addLease(EntityManager em, UserTransaction utx, Lease lease) {
        System.err.println("Not implemented!");
        return false;
    }
//PREFERENCES

    public static PreferencesT findPreferences(EntityManager em, String id) {
        return em.find(PreferencesT.class, id);
    }

    public static List findAllPreferences(EntityManager em) {
        Query query = em.createQuery("SELECT P From PreferencesT p");
        return query.getResultList();
    }
//Add other preference finders

    public static boolean addPreferences(EntityManager em, UserTransaction utx, Preferences pref) {
        System.err.println("Not implemented!");
        return false;
    }
//PROPERTY

    public static PropertyT findProperty(EntityManager em, String id) {
        return em.find(PropertyT.class, id);
    }

    public static List findAllProperty(EntityManager em) {
        Query query = em.createQuery("SELECT P From PropertyT p");
        return query.getResultList();
    }
    public static List findAllProperty(EntityManager em, String ville) {
        String myQuery="SELECT P From PropertyT p, AddressT a WHERE AddressT a.ville="+ville+" AND PropertyT p.address=a.id";
        Query query = em.createQuery(myQuery);
        return query.getResultList();
    }
//Add other property finders

    public static boolean addProperty(EntityManager em, UserTransaction utx, Property prop, Address addr, String userId) {
        try {
            utx.begin();
            PropertyT tProperty = new PropertyT();
            AddressT tAddress = new AddressT();
            List<PictureT> tPhotos = new ArrayList<>();
            
            tProperty.setNB_BATHROOMS(prop.getNbBathrooms());
            tProperty.setNB_BEDROOMS(prop.getNbBedrooms());
            tProperty.setNB_OTHERS(prop.getNbOthers());
            tProperty.setRENT(prop.getRent());
            tProperty.setTYPE(prop.getType()); 
            tProperty.setOwnerT(findOwner(em, userId));
            
            tAddress.setNOM_RUE(addr.getNomRue());
            tAddress.setNUMERO_RUE(addr.getNumeroRue());
            tAddress.setNUMERO_UNITE(addr.getNumeroUnite());
            tAddress.setPOSTAL_CODE(addr.getPostalCode());
            tAddress.setPROVINCE(addr.getProvince());
            tAddress.setVILLE(addr.getVille());
            
            tProperty.setADDRESS(tAddress);
            
            PictureT tempPhoto = new PictureT();
            
            for(Picture picture : prop.getPhotos()) {
                tempPhoto.setPICTURE_ID(picture.getID());
                tempPhoto.setPICTURE_DATA(picture.getData());
                tPhotos.add(tempPhoto);
            }
            
            tProperty.setPICTURES(tPhotos);
            em.persist(tProperty);
            utx.commit();
            
            updateOwnerPropreties(em, utx, userId, tProperty);
            return true;
        } catch (IllegalArgumentException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean addAddress(EntityManager em, UserTransaction utx, Address addr) {
        try {
            utx.begin();
            AddressT tAddress = new AddressT();
            tAddress.setNOM_RUE(addr.getNomRue());
            tAddress.setNUMERO_RUE(addr.getNumeroRue());
            tAddress.setNUMERO_UNITE(addr.getNumeroUnite());
            tAddress.setPOSTAL_CODE(addr.getPostalCode());
            tAddress.setPROVINCE(addr.getProvince());
            tAddress.setVILLE(addr.getVille());
            em.persist(tAddress);
            utx.commit();
            return true;
        } catch (IllegalArgumentException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
//ACCOUNT

    public static AccountT findAccount(EntityManager em, String id) {
        return em.find(AccountT.class, id);
    }

    public static List findAllAccount(EntityManager em) {
        Query query = em.createQuery("SELECT A From AccountT a");
        return query.getResultList();
    }
//Add other account finders

    public static boolean addUser(EntityManager em, UserTransaction utx, Account acc) {
        try {
            utx.begin();
            UserT tUser = null;
            
            if(acc.getType().equals("owner")) {
                tUser = new OwnerT();
            } else {
                tUser = new CustomerT();
            }
            
            tUser.setUSER_ID(acc.getUserName());
            
            AccountT tAccount = new AccountT();
            tAccount.setACCOUNT_ID(acc.getUserName());
            tAccount.setFIRST_NAME(acc.getFirstName());
            tAccount.setLAST_NAME(acc.getLastName());
            tAccount.setEMAIL(acc.getEmail());
            tAccount.setUSER_NAME(acc.getUserName());
            tAccount.setPASSWORD(acc.getPassword());
            tAccount.setTYPE(acc.getType());
            
            tUser.setACCOUNT(tAccount);
            em.persist(tUser);
            utx.commit();
            return true;
        } catch (IllegalArgumentException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
   
    public static boolean addAccount(EntityManager em, UserTransaction utx, Account acc) {
        try {
            utx.begin();
            AccountT tAccount = new AccountT();
            tAccount.setFIRST_NAME(acc.getFirstName());
            tAccount.setLAST_NAME(acc.getLastName());
            tAccount.setEMAIL(acc.getEmail());
            tAccount.setUSER_NAME(acc.getUserName());
            tAccount.setPASSWORD(acc.getPassword());
            tAccount.setTYPE(acc.getType());
            em.persist(tAccount);
            utx.commit();
            return true;
        } catch (IllegalArgumentException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static boolean updateAccount(EntityManager em, UserTransaction utx, String id, Account uAcc) {
        try {
            utx.begin();
            AccountT account = em.find(AccountT.class, id);
            if (!uAcc.getPassword().isEmpty()) {
                account.setPASSWORD(uAcc.getPassword());
            }

            if (!uAcc.getEmail().isEmpty()) {
                account.setEMAIL(uAcc.getEmail());
            }

            em.merge(account);
            utx.commit();
            return true;
        } catch (IllegalArgumentException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public static boolean updateOwnerPropreties(EntityManager em, UserTransaction utx, String id, PropertyT prop) {
        try {
            utx.begin();
            OwnerT tOwner = em.find(OwnerT.class, id);
            List<PropertyT> tempProp = tOwner.getPROPERTIES();
            tempProp.add(prop);
            tOwner.setPROPERTIES(tempProp);
            em.merge(tOwner);
            utx.commit();
            return true;
        } catch (IllegalArgumentException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public static boolean deleteAccount(EntityManager em, UserTransaction utx, String id) {
        try {
            utx.begin(); 
            UserT tUser = em.find(UserT.class, id);
            em.remove(tUser);
            utx.commit(); 
            return true;
        } catch (IllegalArgumentException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
//AGENT

    public static AddressT findAddress(EntityManager em, String id) {
        return em.find(AddressT.class, id);
    }
    
    public static AgentT findAgent(EntityManager em, String id) {
        return em.find(AgentT.class, id);
    }

    public static List findAllAgent(EntityManager em) {
        Query query = em.createQuery("SELECT A From AgentT a");
        return query.getResultList();
    }
//Add other agent finders

    public static boolean addAgent(EntityManager em, UserTransaction utx, Agent agent) {
        System.err.println("Not implemented!");
        return false;
    }
//CUSTOMER

    public static CustomerT findCustomer(EntityManager em, String id) {
        return em.find(CustomerT.class, id);
    }

    public static List findAllCustomer(EntityManager em) {
        Query query = em.createQuery("SELECT C From CustomerT c");
        return query.getResultList();
    }
//Add other customer finders

    public static boolean addCustomer(EntityManager em, UserTransaction utx, Customer customer) {
        System.err.println("Not implemented!");
        return false;
    }
//Owner

    public static OwnerT findOwner(EntityManager em, String id) {
        return em.find(OwnerT.class, id);
    }

    public static List findAllOwner(EntityManager em) {
        Query query = em.createQuery("SELECT O From OwnerT o");
        return query.getResultList();
    }
//Add other owner finders

    public static boolean addOwner(EntityManager em, UserTransaction utx, Owner owner) {
        System.err.println("Not implemented!");
        return false;
    }
    /* USED by extending classes
     //USER
     public static UserT findUser(EntityManager em, String id){
     return em.find(UserT.class, id);
     }
     public static List findAllUser(EntityManager em){
     Query query = em.createQuery("SELECT U From UserT u");
     return query.getResultList();
     }
     //Add other visit finders
     public static boolean addUser(EntityManager em, UserTransaction utx, User user){
     System.err.println("Not implemented!");
     return false;
     }
     */
// NO ADDRESS, NO PICTURE, used by add methods...
// User might even be used by extending objects... This is reason for commenting out
}
