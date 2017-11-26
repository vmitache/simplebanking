package curs.banking.business;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import curs.banking.db.utils.IConnectionFactory;

@RequestScoped
public class AccountServiceProducer {
  @Inject
  private IConnectionFactory mConnFact;
  
  @Produces
  @Named("accountService")
  public AccountService getAccountService() {
    return new AccountService(mConnFact);
  }
}
