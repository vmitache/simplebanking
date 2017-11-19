package curs.banking.rest.transaction;

import java.util.Collection;

import curs.banking.business.TransactionService;
import curs.banking.db.utils.DataSourceConnectionFactory;
import curs.banking.model.TransactionPair;
import curs.banking.rest.TransactionResourceIntf;

public class TransactionResource implements TransactionResourceIntf {
	@Override
	public Collection<TransactionPair> getTransactions() throws Exception {
		return new TransactionService(DataSourceConnectionFactory.factory()).loadAllTransactionPairs();
	}

}
