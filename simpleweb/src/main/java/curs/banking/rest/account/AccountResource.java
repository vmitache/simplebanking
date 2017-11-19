package curs.banking.rest.account;

import java.util.Collection;

import curs.banking.business.AccountService;
import curs.banking.db.utils.DataSourceConnectionFactory;
import curs.banking.model.Account;
import curs.banking.rest.AccountResourceIntf;

public class AccountResource implements AccountResourceIntf {
	@Override
	public Collection<Account> getAccounts() throws Exception {
		return new AccountService(DataSourceConnectionFactory.factory()).loadAllAccounts();
	}
}
