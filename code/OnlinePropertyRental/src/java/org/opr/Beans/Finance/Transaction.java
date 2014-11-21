/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opr.Beans.Finance;

/**
 *
 * @author faeriol
 */
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
