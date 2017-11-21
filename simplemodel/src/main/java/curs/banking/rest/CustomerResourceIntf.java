package curs.banking.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import curs.banking.model.Customer;

@Path("/customers")
public interface CustomerResourceIntf {
	@GET
	@Produces("application/json")
	public Collection<Customer> getCustomers() throws Exception;

	@GET
	@Produces("application/json")
	@Path("/{customer_id}")
	public Customer getCustomer(@PathParam("customer_id") long pId) throws Exception;
	
	@POST
	@Produces("application/json")
	@Consumes({"application/json","text/xml"})
	public Customer createCustomer(Customer pCustomer) throws Exception;
	
}
