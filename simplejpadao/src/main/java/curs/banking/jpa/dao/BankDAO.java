package curs.banking.jpa.dao;

import javax.persistence.EntityManager;

import curs.banking.model.Bank;

public class BankDAO extends GenericDaoJpaImpl<Bank, Long> {

  public BankDAO(EntityManager pEntityManager) {
    super(Bank.class, pEntityManager);
  }

}
