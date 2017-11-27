package curs.banking.jpa.dao;

import java.util.Collection;

import javax.persistence.EntityManager;

import curs.banking.model.Customer;

public class CustomerDAO extends GenericDaoJpaImpl<Customer, Long> {

  public CustomerDAO(EntityManager pEntityManager) {
    super(Customer.class, pEntityManager);
  }

  public Collection<Customer> findByName(String pName) {
    return mEntityManager
        .createQuery(
            "SELECT x FROM " + mEntityClass.getName() + 
            " x WHERE UPPER(mName) LIKE :name",mEntityClass)
        .setParameter("name", pName.toUpperCase()).getResultList();
  }

}
