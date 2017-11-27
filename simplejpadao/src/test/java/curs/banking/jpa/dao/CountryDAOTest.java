package curs.banking.jpa.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import curs.banking.model.Country;

public class CountryDAOTest {
  private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("banking");
  private EntityManager mEntityManager;

  @Before
  public void setUp() throws Exception {
    mEntityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
  }

  @Test
  public void testFindAll() {
    CountryDAO cdao = new CountryDAO(mEntityManager);
    assertTrue(cdao.findAll().size() > 0);
  }

  @Test
  public void testInsertFindById() {
    mEntityManager.getTransaction().begin();
    CountryDAO cdao = new CountryDAO(mEntityManager);
    Country c = new Country();
    c.setName("BahreinUL xxx");
    Country c1 = cdao.insert(c);
    mEntityManager.getTransaction().commit();

    Assert.assertEquals("BahreinUL xxx", c1.getName());
    Country c2 = cdao.findById(c1.getId());
    Assert.assertEquals(c1, c2);
  }

}
