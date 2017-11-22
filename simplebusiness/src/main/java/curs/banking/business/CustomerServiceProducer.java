package curs.banking.business;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import curs.banking.db.utils.IConnectionFactory;

@ApplicationScoped
public class CustomerServiceProducer {
  @Inject
  private IConnectionFactory mConnFact;

  @Produces
  public CustomerService getCustomerService() {
    return new CustomerService(mConnFact);
  }
}
