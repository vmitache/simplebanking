package curs.banking.jpa.dao;

import javax.persistence.EntityManager;

import curs.banking.model.Address;

public class AddressDAO extends GenericDaoJpaImpl<Address, Long> {
  public AddressDAO(EntityManager pEntityManager) {
    super(Address.class, pEntityManager);
  }

}
