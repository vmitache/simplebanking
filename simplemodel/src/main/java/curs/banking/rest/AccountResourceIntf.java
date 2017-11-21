package curs.banking.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import curs.banking.model.Account;
import curs.banking.model.AccountType;
import curs.banking.model.Currency;

@Path("/accounts")
@Produces({"application/json","text/xml"})
public interface AccountResourceIntf {
	@GET
	public Collection<Account> getAccounts() throws Exception;
	
	@GET
	@Path("/{id}")
	public Account getAccount(@PathParam("id") long pId) throws Exception;
	
	@POST
	public Account addAccount(
			@QueryParam("iban") String pIBAN,
			@QueryParam("sold") double pSold,
			@QueryParam("cid") long pClientId,
			@QueryParam("at") AccountType pType,
			@QueryParam("c") Currency pCurrency) throws Exception;
		
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public Account updateAccount(@PathParam("id") long pId,
			Account pAccount) throws Exception;
	

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
