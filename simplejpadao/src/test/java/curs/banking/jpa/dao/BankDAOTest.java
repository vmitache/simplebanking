package curs.banking.jpa.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import curs.banking.model.Bank;

public class BankDAOTest {
  private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("banking");
  private EntityManager mEntityManager;

  @Before
  public void setUp() throws Exception {
    mEntityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
  }

  @Test
  public void testFindById() {
    BankDAO bankDAO = new BankDAO(mEntityManager);
    Bank bank = bankDAO.findById(1L);
    assertNotNull(bank);
    assertEquals("BCR", bank.getName());
    assertNull(bank.getFiscalCode());

    bank = bankDAO.findById(314L);
    assertNull(bank);
  }

  @Test
  public void testFindAll() {
    assertTrue(new BankDAO(mEntityManager).findAll().size() > 0);
  }

  @Test
  public void testInsert() {
    mEntityManager.getTransaction().begin();
    BankDAO bankDAO = new BankDAO(mEntityManager);
    Bank bank = new Bank();
    bank.setAdress(new AddressDAO(mEntityManager).findById(1L));
    bank.setFiscalCode("xxxx");
    bank.setName("Patria bank");
    bank = bankDAO.insert(bank);
    mEntityManager.getTransaction().commit();
    assertEquals("Patria bank", bankDAO.findById(bank.getId()).getName());
    ;
  }

  @Test
  public void testUpdate() {
  }

  @Test
  public void testDelete() {
  }

}
