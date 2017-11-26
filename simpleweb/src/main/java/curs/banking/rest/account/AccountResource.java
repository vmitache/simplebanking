package curs.banking.rest.account;

import java.util.Collection;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import curs.banking.business.AccountService;
import curs.banking.model.Account;
import curs.banking.model.AccountType;
import curs.banking.model.Currency;
import curs.banking.rest.AccountResourceIntf;

@RequestScoped
public class AccountResource implements AccountResourceIntf {
	@Inject
	private Logger mLogger;
	
	@Context 
	private HttpServletRequest mRequest;
	@Context 
	private HttpServletResponse mResponse;
	
	@Inject
	@RequestScoped
	private AccountService mAccService;

	@PostConstruct
	public void init() {
		mLogger.info("INIT :" + mAccService);
	}
	
	@Override
	public Collection<Account> getAccounts() throws Exception {
		mResponse.setHeader("pufi", "fifi");
		//if(mRequest.getUserPrincipal() == null) {
		//	return new ArrayList<Account>();
		//}
		return mAccService.loadAllAccounts();
		//return new AccountService(DataSourceConnectionFactory.factory()).loadAllAccounts();
	}

	@Override
	public Account getAccount(long pId) throws Exception {
		return mAccService.loadAccountById(pId);
		//return new AccountService(DataSourceConnectionFactory.factory()).loadAccountById(pId);

	}

	@Override
	public Account addAccount(String pIBAN, double pSold, long pClientId, AccountType pType, Currency pCurrency) throws Exception {
		return mAccService.createAccount(pIBAN, pSold, pClientId, pType, pCurrency);
		//AccountService as = new AccountService(DataSourceConnectionFactory.factory());
		//return as.createAccount(pIBAN, pSold, pClientId, pType, pCurrency);
	}

	
	@Override
	public Account updateAccount(long pId, Account pAccount) throws Exception {
		return mAccService.updateAccount(pId, pAccount);
		//AccountService as = new AccountService(DataSourceConnectionFactory.factory());
		//return as.updateAccount(pId, pAccount);
	}
	
	// GET ACCOUNT BY ID
}
