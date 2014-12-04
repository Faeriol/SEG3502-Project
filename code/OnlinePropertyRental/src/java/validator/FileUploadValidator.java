/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author Vlado
 */
@FacesValidator
public class FileUploadValidator implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        Part part =(Part) o;
        int maxFileSize = 5*1024*1024;
        if(part.getSize() > maxFileSize) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "File is too large", "File is too large"));
        }
        
        if(!part.getSubmittedFileName().toUpperCase().endsWith(".JPG")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "File if not of .jpg format", "File if not of .jpg format"));
        }
    }
}
