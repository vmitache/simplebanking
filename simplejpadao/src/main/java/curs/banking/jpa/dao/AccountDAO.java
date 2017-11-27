package curs.banking.jpa.dao;

import javax.persistence.EntityManager;

import curs.banking.model.Account;

public class AccountDAO extends GenericDaoJpaImpl<Account, Long> {

  public AccountDAO(EntityManager pEntityManager) {
    super(Account.class, pEntityManager);
  }

}
