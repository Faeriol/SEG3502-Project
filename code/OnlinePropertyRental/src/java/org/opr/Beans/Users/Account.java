package org.opr.Beans.Users;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.Users.AccountT;

/**
 *
 * @author faeriol
 */
@Named(value = "account")
@RequestScoped
public class Account {
    private String ID;
    private String firstName, lastName, email, userName, password;
    private String status;
    private String template;
    private String type; // What is this supposed to be??? vlad: I use it to determine what template the client sees

    private List<AccountT> lookupResults;
    
    /**
     * 
     * @return the template the use
     */
    public String getTemplate() {
        return template;
    }
    
    /**
     * 
     * @param template the template to set
     */
    public void setTemplate(String template) {
        this.template = template;
    }
    
    /**
     * 
     * @return the login status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status the login status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    public void setLookupResults(List<AccountT> results) {
        this.lookupResults = results;
    }
    
    public List<AccountT> getLookupResults() {
        return lookupResults;
    }
    // show results if any
    public boolean getShowResults() {
        return (lookupResults != null) && !lookupResults.isEmpty();
    }
    // show message if no result
    public boolean getShowMessage() {
        return (lookupResults != null) && lookupResults.isEmpty();
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }
    
}
