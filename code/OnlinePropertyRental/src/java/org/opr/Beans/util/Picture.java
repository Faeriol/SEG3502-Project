package org.opr.Beans.util;

/**
 * Represent a picture... Not saying this is smart, 
 * I just feel lazy and want a "representation", an easy way to handle them
 * The "right" answer would obviously be to store the object-files in some form
 * of storage... But then the amount of code required is much higher... Potentially
 * @author faeriol
 */
public class Picture {
    private byte [] data;
    
    public Picture(){};
    public Picture(byte [] data){ this.data = data; }

    /**
     * @return the data
     */
    public byte[] getData() { return data; }

    /**
     * @param data the data to set
     */
    public void setData(byte[] data) { this.data = data; }
    
}
