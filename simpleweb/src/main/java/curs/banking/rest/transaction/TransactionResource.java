package curs.banking.rest.transaction;

import java.util.Collection;

import javax.inject.Inject;

import curs.banking.business.TransactionService;
import curs.banking.db.utils.DataSourceConnectionFactory;
import curs.banking.model.TransactionPair;
import curs.banking.rest.TransactionResourceIntf;

public class TransactionResource implements TransactionResourceIntf {
	@Inject
	private TransactionService mTransactionService;
	
	@Override
	public Collection<TransactionPair> getTransactions() throws Exception {
		return mTransactionService.loadAllTransactionPairs();
	}

}
