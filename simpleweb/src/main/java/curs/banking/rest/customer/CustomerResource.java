package curs.banking.rest.customer;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import curs.banking.business.CustomerService;
import curs.banking.model.Customer;

@Path("/customers")
public class CustomerResource {
	@GET
	@Produces("application/json")
   public Collection<Customer> getCustomers() throws Exception {
	   return new CustomerService().loadAllCustomers();
   }
}
