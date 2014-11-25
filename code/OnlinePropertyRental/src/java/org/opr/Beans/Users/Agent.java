package org.opr.Beans.Users;

import java.util.List;
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
    
    private List<AgentT> lookupResults;
    // Agent number is an ID or a phone Number??
    
    public void setLookupResults(List<AgentT> results) {
        this.lookupResults = results;
    }
    
    public List<AgentT> getLookupResults() {
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
    
}
