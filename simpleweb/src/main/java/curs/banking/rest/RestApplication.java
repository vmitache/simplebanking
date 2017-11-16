package curs.banking.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import curs.banking.rest.customer.CustomerResource;

@ApplicationPath("/rest1")
public class RestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
		Set<Class<?>> clzz = new HashSet<>();
		clzz.add(CustomerResource.class);
    	return clzz;
    }
}
