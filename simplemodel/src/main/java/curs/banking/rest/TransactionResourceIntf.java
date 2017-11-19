package curs.banking.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import curs.banking.model.TransactionPair;

@Path("/transactions")
public interface TransactionResourceIntf {
	@GET
	@Produces("application/json")
	public Collection<TransactionPair> getTransactions() throws Exception;
}
