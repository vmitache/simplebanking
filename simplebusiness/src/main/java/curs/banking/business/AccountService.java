package curs.banking.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;

import curs.banking.dao.AccountDAO;
import curs.banking.dao.CustomerDAO;
import curs.banking.dao.SQLUtils;
import curs.banking.model.Account;
import curs.banking.model.Customer;

public class AccountService {
  static final String DB_URL = "jdbc:h2:~/test;AUTO_SERVER=TRUE";

  public Connection getConnection() throws Exception {
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection(DB_URL, "SA", "");
    // return mThreadConn.get();
  }
  
  public Collection<Account> loadAllAccounts() throws Exception {
    Connection conn = getConnection();
    try {
      AccountDAO aDAO = new AccountDAO(conn);
      return aDAO.findAll();
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }
  
  public Collection<Account> loadAccountsPerCustomerId(long pId) throws Exception {
    Connection conn = getConnection();
    try {
      AccountDAO aDAO = new AccountDAO(conn);
      return aDAO.findByCustomerId(pId);
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }
  
  public Account createAccount(Account pAccount) throws Exception {
    Connection conn = getConnection();
    try {
      AccountDAO aDAO = new AccountDAO(conn);
      return aDAO.insert(pAccount);
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }
}
