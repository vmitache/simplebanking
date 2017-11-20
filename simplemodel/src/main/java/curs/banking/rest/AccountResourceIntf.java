package curs.banking.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import curs.banking.model.Account;

@Path("/accounts")
public interface AccountResourceIntf {
	@GET
	@Produces("application/json")
	public Collection<Account> getAccounts() throws Exception;
	
	// Get account by id
	// Add new Account
	/**
	 * 
	 *{
  "name":"Pafnutie",
  "ssn":"12345xxx",
  "varsta":44,
  "sex":"M",
  "address": {
    "street":"Invierii",
    "number":"13",
    "postalCode":"666",
    "city": {
      "id":1,
      "name":"nu conteaza"
    }
    
  }
}
	 */
}
