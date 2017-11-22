package curs.banking.business;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import curs.banking.db.utils.IConnectionFactory;

@ApplicationScoped
public class TransactionServiceProducer {
  @Inject
  private IConnectionFactory mConnFact;

  @Produces
  public TransactionService getTransactionService() {
    return new TransactionService(mConnFact);
  }
}
