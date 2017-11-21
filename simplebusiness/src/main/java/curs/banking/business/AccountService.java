package curs.banking.business;

import java.sql.Connection;
import java.util.Collection;

import curs.banking.dao.AccountDAO;
import curs.banking.dao.BankDAO;
import curs.banking.dao.CustomerDAO;
import curs.banking.dao.SQLUtils;
import curs.banking.db.utils.IConnectionFactory;
import curs.banking.model.Account;
import curs.banking.model.AccountType;
import curs.banking.model.Currency;

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
  
  public Account createAccount(String pIBAN, double pSold, long pClientId, AccountType pType, Currency pCurrency) throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      AccountDAO aDAO = new AccountDAO(conn);
      Account acc = new Account();
      acc.setIBAN(pIBAN);
      acc.setAccountType(pType);
      acc.setAmount(pSold);
      acc.setCurrency(pCurrency);
      acc.setCustomer(new CustomerDAO(conn).findById(pClientId));
      acc.setBank(new BankDAO(conn).findById(1));
      return aDAO.insert(acc);

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
  
  public Account updateAccount(long pId,Account pAccount) throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      AccountDAO aDAO = new AccountDAO(conn);
      pAccount.setId(pId);
      return aDAO.update(pAccount);
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
