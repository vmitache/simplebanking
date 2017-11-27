package curs.banking.jpa.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import curs.banking.model.Address;
import curs.banking.model.Customer;
import curs.banking.model.SexEnum;

public class CustomerDAOTest {
  private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("banking");
  private EntityManager mEntityManager;

  @Before
  public void setUp() throws Exception {
    mEntityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
  }

  @Test
  public void testFindById() {
    assertEquals("Popescu", new CustomerDAO(mEntityManager).findById(1L).getName());
  }

  @Test
  public void testFindAll() {
    assertTrue(new CustomerDAO(mEntityManager).findAll().size() > 0);
  }
  
  @Test
  public void testFindByName() {
    assertTrue(new CustomerDAO(mEntityManager).findByName("Ionesc%").size() == 1);
  }

  @Test
  public void testInsert() {
    mEntityManager.getTransaction().begin();
    Address address = new AddressDAO(mEntityManager).findById(1L);
    Customer cust = new Customer();
    cust.setName("Pafnutie");
    cust.setSSN("1111111111");
    cust.setAddress(address);
    cust.setVarsta(22);
    cust.setSex(SexEnum.M);
    cust = new CustomerDAO(mEntityManager).insert(cust);
    mEntityManager.getTransaction().commit();
    assertTrue(cust.equals(new CustomerDAO(mEntityManager).findById(cust.getId())));
  }

  @Test
  public void testUpdate() {
    
  }

  @Test
  public void testDelete() {
  }

}
