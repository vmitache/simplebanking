package curs.banking.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import curs.banking.dao.AccountDAO;
import curs.banking.dao.DAOException;
import curs.banking.dao.SQLUtils;
import curs.banking.dao.TransactionDAO;
import curs.banking.model.Account;
import curs.banking.model.Transaction;
import curs.banking.model.TransactionPair;
import curs.banking.model.TransactionType;

public class TransactionService {
  private ConnectionFactory mConnFactory;

  public TransactionService() {
    mConnFactory = ConnectionFactory.factory();
  }

  public Collection<Transaction> loadAllTransactions() throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      TransactionDAO aDAO = new TransactionDAO(conn);
      return aDAO.findAll();
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }

  public Collection<TransactionPair> loadAllTransactionPairs() throws Exception {
    Connection conn = mConnFactory.getConnection();
    try {
      TransactionDAO aDAO = new TransactionDAO(conn);
      return aDAO.getAllPairs();
    } finally {
      SQLUtils.closeQuietly(conn);
    }
  }

  // SE DAU
  // ACCOUNT1 - findById (1)
  // ACCOUNT2 - findById (2)
  // DE FACUT TRANSACTIE INTRE ACCOUNT1 si ACCOUNT2
  // 1 - Transaction('D',ACCOUNT1,SUMA)
  // 2 - ACCOUNT1.SOLD = ACCOUNT1.SOLD - SUMA
  // 3 - Transaction('C',ACCOUNT2, SUMA)
  // 4 - ACCOUNT2.SOLD = ACCOUN2.SOLA + SUMA

  public boolean transferMoney(long pAccountDebitId, long pAccountCreditId, double pAmount)
      throws SQLException, Exception {
    try (Connection conn = mConnFactory.getConnection()) {
      conn.setAutoCommit(false);
      AccountDAO accDAO = new AccountDAO(conn);
      TransactionDAO transDAO = new TransactionDAO(conn);
      Account accDebit = accDAO.findById(pAccountDebitId);
      Account accCredit = accDAO.findById(pAccountCreditId);
      if (!accDebit.getCurrency().equals(accCredit.getCurrency())) {
        throw new DAOException("Different currency type");
      }
      if (accCredit.getAmount() >= pAmount) {
        long transactionTS = new Date().getTime();
        Transaction trans1 = new Transaction();
        trans1.setAccount(accCredit);
        trans1.setAmount(pAmount);
        trans1.setTransactionTime(new Timestamp(transactionTS));
        trans1.setTransactionType(TransactionType.D);

        Transaction trans2 = new Transaction();
        trans2.setAccount(accDebit);
        trans2.setAmount(pAmount);
        trans2.setTransactionTime(new Timestamp(transactionTS));
        trans2.setTransactionType(TransactionType.C);

        accCredit.setAmount(accCredit.getAmount() - pAmount);
        accDebit.setAmount(accDebit.getAmount() + pAmount);
        // ATOMIC!!!!
        transDAO.insert(trans1);
        transDAO.insert(trans2);
        accDAO.update(accCredit);
        accDAO.update(accDebit);
        // ATOMIC!!!
        conn.commit();
        return true;
      } else {
        conn.rollback();
        return false;
      }
    }
  }

}
