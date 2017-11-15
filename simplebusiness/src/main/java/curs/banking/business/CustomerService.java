package curs.banking.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import curs.banking.dao.AccountDAO;
import curs.banking.dao.AddressDAO;
import curs.banking.dao.BankDAO;
import curs.banking.dao.CustomerDAO;
import curs.banking.dao.DAOException;
import curs.banking.dao.SQLUtils;
import curs.banking.dao.TransactionDAO;
import curs.banking.model.Account;
import curs.banking.model.Bank;
import curs.banking.model.Customer;
import curs.banking.model.Transaction;
import curs.banking.model.TransactionType;

public class CustomerService {
  private ConnectionFactory mConnFactory;

  public CustomerService() {
    mConnFactory = ConnectionFactory.factory();
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
