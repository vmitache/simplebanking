package curs.banking.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory implements IConnectionFactory {
  static final String DB_URL = "jdbc:h2:~/test;AUTO_SERVER=TRUE";

  private ConnectionFactory() {

  }

  @Override
  public Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection(DB_URL, "SA", "");
    // return mThreadConn.get();
  }

  private static ConnectionFactory __INSTANCE = null;

  public static ConnectionFactory factory() {
    if (__INSTANCE == null) {
      synchronized (ConnectionFactory.class) {
        if (__INSTANCE == null) {
          __INSTANCE = new ConnectionFactory();
        }
      }
    }
    return __INSTANCE;
  }
}
