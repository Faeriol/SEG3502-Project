package org.opr.Beans.Finance;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Beans.Agency;
import org.opr.Beans.Users.User;
import org.opr.Persistance.Finance.TransactionT;

/**
 *
 * @author faeriol
 */
@Named(value = "transaction")
@RequestScoped
public class Transaction {
 
    private float  amount;
    private String financialInstitution;
    private User   user;
    private Agency agency;
    
    private List<TransactionT> lookupResults;

    /**
     * @return the amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     * @return the financialInstitution
     */
    public String getFinancialInstitution() {
        return financialInstitution;
    }

    /**
     * @param financialInstitution the financialInstitution to set
     */
    public void setFinancialInstitution(String financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the agency
     */
    public Agency getAgency() {
        return agency;
    }

    /**
     * @param agency the agency to set
     */
    public void setAgency(Agency agency) {
        this.agency = agency;
    }
    
    public void setLookupResults(List<TransactionT> results) {
        this.lookupResults = results;
    }
    
    public List<TransactionT> getLookupResults() {
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
    
}
