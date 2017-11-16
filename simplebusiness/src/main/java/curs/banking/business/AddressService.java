package curs.banking.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import curs.banking.dao.CityDAO;
import curs.banking.db.utils.IConnectionFactory;
import curs.banking.model.City;

public class AddressService {
  private IConnectionFactory mConnFactory;

  public AddressService(IConnectionFactory pFactory) {
    mConnFactory = pFactory;
  }
  
  public City loadCityById(long pId) throws SQLException, Exception {
    try(Connection conn = mConnFactory.getConnection()) {
      return new CityDAO(conn).findById(pId);
    }
  }
  
  public Collection<City> loadCities() throws SQLException,Exception {
    try(Connection conn = mConnFactory.getConnection()) {
      return new CityDAO(conn).findAll();
    }
  }
  
  
}
