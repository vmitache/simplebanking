package curs.banking.business;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import curs.banking.db.utils.IConnectionFactory;

@RequestScoped
public class CustomerServiceProducer {
  @Inject
  private IConnectionFactory mConnFact;

  @Produces
  @Named("customerService")
  public CustomerService getCustomerService() {
    return new CustomerService(mConnFact);
  }
}
