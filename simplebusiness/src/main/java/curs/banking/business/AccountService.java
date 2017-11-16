package curs.banking.business;

import java.sql.Connection;
import java.util.Collection;

import curs.banking.dao.AccountDAO;
import curs.banking.dao.SQLUtils;
import curs.banking.db.utils.IConnectionFactory;
import curs.banking.model.Account;

public class AccountService {
  private IConnectionFactory mConnFactory;

  public AccountService(IConnectionFactory pFactory) {
    mConnFactory = pFactory;
  }

  public Collection<Account> loadAllAccounts() throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      AccountDAO aDAO = new AccountDAO(conn);
      return aDAO.findAll();
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }

  public Collection<Account> loadAccountsPerCustomerId(long pId) throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      AccountDAO aDAO = new AccountDAO(conn);
      return aDAO.findByCustomerId(pId);
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }

  public Account createAccount(Account pAccount) throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      AccountDAO aDAO = new AccountDAO(conn);
      return aDAO.insert(pAccount);
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }

  public Account loadAccountById(long pId) throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      AccountDAO aDAO = new AccountDAO(conn);
      return aDAO.findById(pId);
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }

  public Collection<Account> loadPossibleAccountsForPaymentFrom(Account pPaymentAccount) throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      AccountDAO aDAO = new AccountDAO(conn);
      return aDAO.loadPossibleAccountsForPaymentFrom(pPaymentAccount);
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }
}
