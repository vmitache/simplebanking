package curs.banking.jpa.dao;

import java.io.Serializable;
import java.util.Collection;

public interface GenericDao<T, PK extends Serializable> {
	T insert(T t);

	T findById(PK id);

	T update(T t);

	void delete(T t);
	
	Collection<T> findAll();
}