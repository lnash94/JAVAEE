package com.emp.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloEjb
 */
@Stateless
@LocalBean
public class HelloEjb implements HelloEjbLocal {

    /**
     * Default constructor. 
     */
    public HelloEjb() {
        // TODO Auto-generated constructor stub
    }
    public String sayHello(){
    	String msg = "Hello from EJB";
    	return msg;
    }

}
