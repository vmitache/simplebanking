package curs.banking;

import curs.banking.model.Account;
import curs.banking.rest.AccountResourceIntf;
import curs.banking.rest.proxy.ProxyUtils;

public class MainTest {
	public static void main(String[] args) throws Exception {
		AccountResourceIntf accIntf = ProxyUtils.getRestClient(AccountResourceIntf.class);
		Account acc = accIntf.getAccount(1);
		acc.setAmount(acc.getAmount() + 1000);
		accIntf.updateAccount(1, acc);
	}

}
