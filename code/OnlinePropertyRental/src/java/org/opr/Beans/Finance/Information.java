package org.opr.Beans.Finance;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.Finance.InformationT;

/**
 *
 * @author faeriol
 */
@Named(value = "information")
@RequestScoped
public class Information {
    
    private String creditCardType;
    private String creditCardNumber;
    private String primaryCardHolder;
    private short  monthExp;
    private short  yearExp;

    /**
     * @return the creditCardType
     */
    public String getCreditCardType() {
        return creditCardType;
    }

    /**
     * @param creditCardType the creditCardType to set
     */
    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    /**
     * @return the creditCardNumber
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * @param creditCardNumber the creditCardNumber to set
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * @return the primaryCardHolder
     */
    public String getPrimaryCardHolder() {
        return primaryCardHolder;
    }

    /**
     * @param primaryCardHolder the primaryCardHolder to set
     */
    public void setPrimaryCardHolder(String primaryCardHolder) {
        this.primaryCardHolder = primaryCardHolder;
    }

    /**
     * @return the monthExp
     */
    public short getMonthExp() {
        return monthExp;
    }

    /**
     * @param monthExp the monthExp to set
     */
    public void setMonthExp(short monthExp) {
        this.monthExp = monthExp;
    }

    /**
     * @return the yearExp
     */
    public short getYearExp() {
        return yearExp;
    }

    /**
     * @param yearExp the yearExp to set
     */
    public void setYearExp(short yearExp) {
        this.yearExp = yearExp;
    }
    
}
