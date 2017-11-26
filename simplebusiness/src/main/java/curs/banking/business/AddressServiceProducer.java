package curs.banking.business;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import curs.banking.db.utils.IConnectionFactory;

@RequestScoped
public class AddressServiceProducer {
  @Inject
  private IConnectionFactory mConnFact;
  
  @Produces
  @Named("addressService")
  public AddressService getAdressService() {
    return new AddressService(mConnFact);
  }
}
