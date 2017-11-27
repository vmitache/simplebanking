package curs.banking.jpa.dao;

import javax.persistence.EntityManager;

import curs.banking.model.Transaction;

public class TransactionDAO extends GenericDaoJpaImpl<Transaction, Long> {

  public TransactionDAO(EntityManager pEntityManager) {
    super(Transaction.class, pEntityManager);
  }

}
