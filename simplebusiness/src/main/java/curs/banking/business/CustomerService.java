package curs.banking.business;

import java.sql.Connection;
import java.util.Collection;
import curs.banking.dao.AddressDAO;
import curs.banking.dao.BankDAO;
import curs.banking.dao.CustomerDAO;
import curs.banking.dao.SQLUtils;
import curs.banking.db.utils.IConnectionFactory;
import curs.banking.model.Bank;
import curs.banking.model.Customer;

public class CustomerService {
  private IConnectionFactory mConnFactory;

  public CustomerService(IConnectionFactory pFactory) {
    mConnFactory = pFactory;
  }
  

  public Customer createCustomer(Customer pCustomer) throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      conn.setAutoCommit(false);
      AddressDAO addressDAO = new AddressDAO(conn);
   
      CustomerDAO custDAO = new CustomerDAO(conn);
      pCustomer.setAddress(addressDAO.insert(pCustomer.getAddress()));// BE AWARE
      Customer cust = custDAO.insert(pCustomer);
      conn.commit();

      return cust;
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }

  public Collection<Customer> loadAllCustomers() throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      CustomerDAO cDAO = new CustomerDAO(conn);
      return cDAO.findAll();
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }
  
  public Customer loadCustomerById(long pId) throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      CustomerDAO cDAO = new CustomerDAO(conn);
      return cDAO.findById(pId);
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }
  
  public Bank getBank() throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      BankDAO bDAO = new BankDAO(conn);
      return bDAO.findById(1);
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }


}
