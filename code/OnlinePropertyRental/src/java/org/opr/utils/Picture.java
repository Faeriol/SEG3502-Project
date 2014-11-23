package org.opr.utils;

/**
 * Represent a picture... Not saying this is smart, 
 * I just feel lazy and want a "representation"
 * @author faeriol
 */
public class Picture {
    private byte [] data;
    
    public Picture(){};
    public Picture(byte [] data){
        this.data = data;
    }

    /**
     * @return the data
     */
    public byte[] getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(byte[] data) {
        this.data = data;
    }
    
    
}
