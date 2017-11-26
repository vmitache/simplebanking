package curs.banking.jpa.dao;

import javax.persistence.EntityManager;

import curs.banking.model.Country;

public class CountryDAO extends GenericDaoJpaImpl<Country, Long> {

	public CountryDAO(EntityManager pEntityManager) {
		super(Country.class, pEntityManager);
	}

}
