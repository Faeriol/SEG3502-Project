/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vlado
 */
public class AuthenticationFilter implements Filter {
    private FilterConfig filterConfig = null;
    
    @Override
    public void init(FilterConfig fc) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        HttpServletResponse res = (HttpServletResponse) sr1;
        HttpSession ses = req.getSession(false);  
        String reqURI = req.getRequestURI();
        // redirects to login page if an attempt to access a page in /protected folder  
        // is made by an anonymous (not logged) user
        if (reqURI.contains("/protected/") && (ses == null || (ses != null && ses.getAttribute("Account") == null))) {
            String loginURL = req.getContextPath() + "/faces/Login.xhtml";
            res.sendRedirect(loginURL);
        } else {
            fc.doFilter(sr, sr1);
        }  
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}