package com.ibm.authors;

// JAX-RS
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;
 
@ApplicationPath("v1")
public class AuthorsApplication extends Application {
    
    public AuthorsApplication(){
        System.out.println("... [Author] start AuthorsApplication");
	}
}