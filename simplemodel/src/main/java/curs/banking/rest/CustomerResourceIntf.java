package curs.banking.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import curs.banking.model.Customer;

@Path("/customers")
public interface CustomerResourceIntf {
	@GET
	@Produces("application/json")
	public Collection<Customer> getCustomers() throws Exception;

}
