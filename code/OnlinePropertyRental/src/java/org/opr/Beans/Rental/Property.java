package org.opr.Beans.Rental;

import java.util.List;
import org.opr.Beans.util.Address;
import org.opr.utils.Picture;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.Rental.PropertyT;

/**
 *
 * @author faeriol
 */
@Named(value = "property")
@RequestScoped
public class Property {
    private Address  address;
    private List<Picture> photos;
    private String  type;
    private short   nbBedrooms, nbBathrooms, nbOthers;
    private int     rent;

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
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
    public List<Picture> getPhotos() {
        return photos;
    }

    /**
     * @param photos the photos to set
     */
    public void setPhotos(List<Picture> photos) {
        this.photos = photos;
    }
    
    public void addPhoto(Picture photo){
        this.photos.add(photo);
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
    public int getRent() {
        return rent;
    }

    /**
     * @param rent the rent to set
     */
    public void setRent(int rent) {
        this.rent = rent;
    }
    
}
