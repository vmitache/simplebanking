package curs.banking.jpa.dao;

import javax.persistence.EntityManager;

import curs.banking.model.City;

public class CityDAO extends GenericDaoJpaImpl<City, Long> {

	public CityDAO(EntityManager pEntityManager) {
		super(City.class, pEntityManager);
	}

}
