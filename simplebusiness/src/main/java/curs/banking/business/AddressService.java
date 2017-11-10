package curs.banking.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import curs.banking.dao.CityDAO;
import curs.banking.model.City;

public class AddressService {
  static final String DB_URL = "jdbc:h2:~/test;AUTO_SERVER=TRUE";

  public Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection(DB_URL, "SA", "");
    // return mThreadConn.get();
  }
  
  public City loadCityById(long pId) throws SQLException, Exception {
    try(Connection conn = getConnection()) {
      return new CityDAO(conn).findById(pId);
    }
  }
  
  
}
