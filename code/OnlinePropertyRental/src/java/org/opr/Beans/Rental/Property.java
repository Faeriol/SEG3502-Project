package org.opr.Beans.Rental;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import org.opr.Beans.util.Address;
import org.opr.Beans.util.Picture;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import org.opr.Persistance.Rental.PropertyT;

/**
 *
 * @author faeriol
 */
@Named(value = "property")
@RequestScoped
public class Property {
    private String ID;
    private Address  address;
    private Part part;
    private List<Picture> pictures;
    private String  type;
    private short nbBedrooms, nbBathrooms, nbOthers;
    private float rent;
    
    private String status;
    
    private List<PropertyT> lookupResults;

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        if(pictures == null) {
            pictures = new ArrayList<>();
        }
        
        Picture picture = new Picture();
        picture.setID(getFileName(part));
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            
            InputStream in = part.getInputStream();
            byte[] buffer = new byte[1024];
            int r;
            while (true) {
                r = in.read(buffer);
                if (r == -1) {
                    break;
                }
                out.write(buffer, 0, r);
            }
            picture.setData(out.toByteArray());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                out.close();
            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        pictures.add(picture);
        this.part = null;
    }
    
    /**
     * @return the address
     */
    public Address getAddress() {
        if(address == null) {
            this.address = new Address();
            return address;
        } else {
            return address;
        }
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the photos
     */
    public List<Picture> getPictures() {
            return pictures;
    }

    /**
     * @param photos the photos to set
     */
    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
    
    /*public void addPhoto(Picture photo){
        this.photos.add(photo);
    }*/

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

    /**
     * @return the nbBedrooms
     */
    public short getNbBedrooms() {
        return nbBedrooms;
    }

    /**
     * @param nbBedrooms the nbBedrooms to set
     */
    public void setNbBedrooms(short nbBedrooms) {
        this.nbBedrooms = nbBedrooms;
    }

    /**
     * @return the nbBathrooms
     */
    public short getNbBathrooms() {
        return nbBathrooms;
    }

    /**
     * @param nbBathrooms the nbBathrooms to set
     */
    public void setNbBathrooms(short nbBathrooms) {
        this.nbBathrooms = nbBathrooms;
    }

    /**
     * @return the nbOthers
     */
    public short getNbOthers() {
        return nbOthers;
    }

    /**
     * @param nbOthers the nbOthers to set
     */
    public void setNbOthers(short nbOthers) {
        this.nbOthers = nbOthers;
    }

    /**
     * @return the rent
     */
    public float getRent() {
        return rent;
    }

    /**
     * @param rent the rent to set
     */
    public void setRent(float rent) {
        this.rent = rent;
    }
    
    public void setLookupResults(List<PropertyT> results) {
        this.lookupResults = results;
    }
    
    public List<PropertyT> getLookupResults() {
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
    
    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;
    }
}
