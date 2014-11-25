package org.opr.Persistance.Finance;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author faeriol
 */
@Entity
@Table(name="Information")
public class InformationT implements Serializable {
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int INFORMATION_ID;
    private String CREDIT_CARD_TYPE;
    private String CREDIT_CARD_NUMBER;
    private String PRIMARY_CARD_HOLDER;
    private short  MONTH_EXP;
    private short  YEAR_EXP;
    
    @Override
    public String toString() {
        return "persistence.Information[id=" + this.getINFORMATION_ID() + "]";
    }

    /**
     * @return the INFORMATION_ID
     */
    public int getINFORMATION_ID() {
        return INFORMATION_ID;
    }

    /**
     * @param INFORMATION_ID the INFORMATION_ID to set
     */
    public void setINFORMATION_ID(int INFORMATION_ID) {
        this.INFORMATION_ID = INFORMATION_ID;
    }

    /**
     * @return the CREDIT_CARD_TYPE
     */
    public String getCREDIT_CARD_TYPE() {
        return CREDIT_CARD_TYPE;
    }

    /**
     * @param CREDIT_CARD_TYPE the CREDIT_CARD_TYPE to set
     */
    public void setCREDIT_CARD_TYPE(String CREDIT_CARD_TYPE) {
        this.CREDIT_CARD_TYPE = CREDIT_CARD_TYPE;
    }

    /**
     * @return the CREDIT_CARD_NUMBER
     */
    public String getCREDIT_CARD_NUMBER() {
        return CREDIT_CARD_NUMBER;
    }

    /**
     * @param CREDIT_CARD_NUMBER the CREDIT_CARD_NUMBER to set
     */
    public void setCREDIT_CARD_NUMBER(String CREDIT_CARD_NUMBER) {
        this.CREDIT_CARD_NUMBER = CREDIT_CARD_NUMBER;
    }

    /**
     * @return the PRIMARY_CARD_HOLDER
     */
    public String getPRIMARY_CARD_HOLDER() {
        return PRIMARY_CARD_HOLDER;
    }

    /**
     * @param PRIMARY_CARD_HOLDER the PRIMARY_CARD_HOLDER to set
     */
    public void setPRIMARY_CARD_HOLDER(String PRIMARY_CARD_HOLDER) {
        this.PRIMARY_CARD_HOLDER = PRIMARY_CARD_HOLDER;
    }

    /**
     * @return the MONTH_EXP
     */
    public short getMONTH_EXP() {
        return MONTH_EXP;
    }

    /**
     * @param MONTH_EXP the MONTH_EXP to set
     */
    public void setMONTH_EXP(short MONTH_EXP) {
        this.MONTH_EXP = MONTH_EXP;
    }

    /**
     * @return the YEAR_EXP
     */
    public short getYEAR_EXP() {
        return YEAR_EXP;
    }

    /**
     * @param YEAR_EXP the YEAR_EXP to set
     */
    public void setYEAR_EXP(short YEAR_EXP) {
        this.YEAR_EXP = YEAR_EXP;
    }

}
