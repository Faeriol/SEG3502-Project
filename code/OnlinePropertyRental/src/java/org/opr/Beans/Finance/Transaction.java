package org.opr.Beans.Finance;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
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
    
}
