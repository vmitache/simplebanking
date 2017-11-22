package curs.banking.db.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ApplicationScoped
public class DataSourceProducer {
  @Inject
  @Named("jndi_name")
  private String mJNDIName;

  @Produces
  @ApplicationScoped
  public DataSource createDataSource() {
    InitialContext cxt;
    try {
      cxt = new InitialContext();
      DataSource dataSource = (DataSource) cxt.lookup(mJNDIName);
      if (dataSource == null) {
        throw new RuntimeException("Data source not found!");
      }
      return dataSource;
    } catch (NamingException e) {
      throw new RuntimeException(e);
    }
  }
}
