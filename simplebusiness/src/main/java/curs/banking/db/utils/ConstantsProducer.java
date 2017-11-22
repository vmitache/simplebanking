package curs.banking.db.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class ConstantsProducer {
  private final String DS_NAME = "java:/comp/env/jdbc/BankDB";
  
  @Produces
  @Named("jndi_name")
  public String getDSJndiName() {
    return DS_NAME;
  }
}
