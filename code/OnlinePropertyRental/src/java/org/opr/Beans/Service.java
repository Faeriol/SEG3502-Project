package org.opr.Beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.ServiceT;

/**
 *
 * @author faeriol
 */
@Named(value = "service")
@RequestScoped
public class Service {
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
