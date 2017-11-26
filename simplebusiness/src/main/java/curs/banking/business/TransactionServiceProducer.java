package curs.banking.business;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import curs.banking.db.utils.IConnectionFactory;

@RequestScoped
public class TransactionServiceProducer {
  @Inject
  private IConnectionFactory mConnFact;

  @Produces
  public TransactionService getTransactionService() {
    return new TransactionService(mConnFact);
  }
}
