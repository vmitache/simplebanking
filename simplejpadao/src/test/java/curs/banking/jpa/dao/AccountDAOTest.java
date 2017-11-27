package curs.banking.jpa.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import curs.banking.model.Account;
import curs.banking.model.AccountType;
import curs.banking.model.Bank;
import curs.banking.model.Currency;
import curs.banking.model.Customer;

public class AccountDAOTest {
  private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("banking");
  private EntityManager mEntityManager;

  @Before
  public void setUp() throws Exception {
    mEntityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
  }

  @Test
  public void testFindById() throws Exception {
    assertTrue("RNCB0101010101101".equals(new AccountDAO(mEntityManager).findById(1L).getIBAN()));
  }

  @Test
  public void testFindAll() throws Exception {
    assertTrue(new AccountDAO(mEntityManager).findAll().size() >= 3);
  }

  @Test
  public void testInsert() throws Exception {
    mEntityManager.getTransaction().begin();
    int initialSize = new AccountDAO(mEntityManager).findAll().size();
    Bank bank = new BankDAO(mEntityManager).findById(1L);
    Customer cust = new CustomerDAO(mEntityManager).findById(1L);
    Account acc = new Account();
    acc.setAccountType(AccountType.CREDIT);
    acc.setAmount(100);
    acc.setBank(bank);
    acc.setCurrency(Currency.GBP);
    acc.setCustomer(cust);
    acc.setIBAN("XXXXXXXXXXXXXXXXX");
    AccountDAO accDAO = new AccountDAO(mEntityManager);
    Account savedAcc = accDAO.insert(acc);
    assertTrue(savedAcc.getId() != 0);
    acc.setId(savedAcc.getId());
    assertEquals(acc, savedAcc);
    mEntityManager.getTransaction().commit();
    assertEquals(initialSize, new AccountDAO(mEntityManager).findAll().size() - 1);
  }

  @Test
  public void testUpdate() throws Exception {
    
    AccountDAO accDAO = new AccountDAO(mEntityManager);
    Account acc = accDAO.findById(1L);
    double amount = acc.getAmount();
    acc.setAmount(amount + 33);
    mEntityManager.getTransaction().begin();
    accDAO.update(acc);
    mEntityManager.getTransaction().commit();
    assertEquals((int) (amount + 33), (int) accDAO.findById(1L).getAmount());
  }

  @Test
  public void testDelete() throws Exception {
  }

}
