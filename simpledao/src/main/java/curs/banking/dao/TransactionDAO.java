package curs.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import curs.banking.model.Transaction;
import curs.banking.model.TransactionPair;
import curs.banking.model.TransactionType;

public class TransactionDAO extends AbstractBaseDAO<Transaction> {
	private AccountDAO mAccountDAO;

	@Override
	protected Transaction loadFromResultSet(ResultSet pRS) throws SQLException {
		Transaction trans = new Transaction();
		trans.setId(pRS.getLong(1));
		long accId = pRS.getLong(2);
		if (!pRS.wasNull()) {
			trans.setAccount(mAccountDAO.findById(accId));
		}
		trans.setTransactionType("D".equals(pRS.getString(3)) ? TransactionType.D : TransactionType.C);
		/// pRS.getString(3).equals("D");
		trans.setAmount(pRS.getDouble(4));
		trans.setTransactionTime(pRS.getTimestamp(5));

		return trans;
	}

	@Override
	protected String getSQLForFindAll() {
		return "SELECT ID,ACCOUNT_ID,TTYPE,AMOUNT,TTIME FROM BANK.TRANSACTION";
	}

	public TransactionDAO(Connection pConnection) {
		super(pConnection);
		mAccountDAO = new AccountDAO(mConnection);
	}

	@Override
	public Transaction insert(Transaction pEntity) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = mConnection.prepareStatement(
					"INSERT INTO BANK.TRANSACTION(ACCOUNT_ID,TTYPE,AMOUNT,TTIME) VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, pEntity.getAccount().getId());
			stmt.setString(2, pEntity.getTransactionType().name());
			stmt.setDouble(3, pEntity.getAmount());
			stmt.setTimestamp(4, pEntity.getTransactionTime());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getLong(1);
				return findById(id);
			} else {
				throw new DAOException("Id not found in insert");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			SQLUtils.closeQuietly(rs, stmt);

		}

	}

	public Collection<TransactionPair> getAllPairs() {
		String sqlStmt = "SELECT t1.id,t2.id FROM BANK.TRANSACTION t1,BANK.TRANSACTION t2 "
				+ "WHERE t1.TTYPE='D' AND t2.TTYPE='C' AND t1.AMOUNT=t2.AMOUNT AND t1.TTIME=t2.TTIME";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Collection<TransactionPair> result = new ArrayList<>();
		try {
			stmt = mConnection.prepareStatement(sqlStmt);

			rs = stmt.executeQuery();
			while (rs.next()) {
				long debitID = rs.getLong(1);
				long creditID = rs.getLong(2);
				Transaction t1 = findById(debitID);
				Transaction t2 = findById(creditID);
				TransactionPair tp = new TransactionPair(t1, t2);
				result.add(tp);
			}
			return result;
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			SQLUtils.closeQuietly(rs, stmt);

		}
	}

	@Override
	public Transaction update(Transaction pEntity) {
		throw new DAOException("A NU SE IMPLEMENTA");

	}

	@Override
	public void delete(Transaction pEntity) {
		throw new DAOException("Not implemented!!!");

	}

}
