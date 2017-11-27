package curs.banking.jpa.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.EntityManager;

public class GenericDaoJpaImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
  protected Class<T> mEntityClass;
  protected EntityManager mEntityManager;

  public GenericDaoJpaImpl(Class<T> pClass, EntityManager pEntityManager) {
    mEntityClass = pClass;
    mEntityManager = pEntityManager;
  }

  @Override
  public T insert(T t) {
    this.mEntityManager.persist(t);
    return t;
  }

  @Override
  public T findById(PK id) {
    return this.mEntityManager.find(mEntityClass, id);
  }

  @Override
  public T update(T t) {
    return this.mEntityManager.merge(t);
  }

  @Override
  public void delete(T t) {
    t = this.mEntityManager.merge(t);
    this.mEntityManager.remove(t);
  }

  @Override
  public Collection<T> findAll() {
    return mEntityManager
        .createQuery("SELECT x FROM " + mEntityClass.getName() + " x",mEntityClass)
        .getResultList();
  }
}