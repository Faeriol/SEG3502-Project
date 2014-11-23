package org.opr.Beans.Users;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.opr.Persistance.Users.AgentT;

/**
 *
 * @author faeriol
 */
@Named(value = "agent")
@RequestScoped
public class Agent extends User{
    
    // Agent number is an ID or a phone Number??
    
}
