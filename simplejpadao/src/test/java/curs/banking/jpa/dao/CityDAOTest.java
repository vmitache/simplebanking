package curs.banking.jpa.dao;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import curs.banking.model.City;
import curs.banking.model.Country;

public class CityDAOTest {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("banking");
	private EntityManager mEntityManager;

	@Before
	public void setUp() throws Exception {
		mEntityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
	}

	@Test
	public void testFindAll() {
		Collection<City> cities = new CityDAO(mEntityManager).findAll();
		System.out.println(cities);
	}
	
	@Test
	public void createNewCity() {
		CountryDAO countryDAO = new CountryDAO(mEntityManager);
		Country country = countryDAO.findById(2L);
		mEntityManager.getTransaction().begin();
		City city = new City();
		city.setCountry(country);
		city.setName("Faurei");
		CityDAO cityDAO = new CityDAO(mEntityManager);
		city = cityDAO.insert(city);
		mEntityManager.getTransaction().commit();
		assertEquals(city, cityDAO.findById(city.getId()));
	}

}
