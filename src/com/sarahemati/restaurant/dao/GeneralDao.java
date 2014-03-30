package com.sarahemati.restaurant.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import com.sarahemati.restaurant.model.abstracts.BaseEntity;


@Stateful
public class GeneralDao implements Serializable {
	private static final long serialVersionUID = -169258812805375171L;
	// @PersistenceUnit(unitName = "store")
	// private EntityManagerFactory factory;
	@PersistenceContext(type = PersistenceContextType.EXTENDED, name = "store")
	private EntityManager entityManager;

	// private EntityTransaction entityTransaction;

	// @PostConstruct
	// public void load() {
	// System.out
	// .println("=======================================================================================");
	// factory = Persistence.createEntityManagerFactory("store");
	// entityManager = factory.createEntityManager();
	// entityTransaction = entityManager.getTransaction();
	// }

	public <T> T save(T t) throws Exception {
		try {
			// entityTransaction.begin();
			entityManager.persist(t);
			entityManager.flush();
			// entityTransaction.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.clear();
		}
		return t;
	}

	public <T> List<T> save(List<T> ts) throws Exception {
		List<T> list = new ArrayList<>();
		for (T t : ts) {
			list.add(save(t));
		}
		return list;
	}

	public <T> T update(T t) throws Exception {
		try {
			// entityTransaction.begin();
//			entityManager.merge(entityManager.getReference(t.getClass(),
//					((BaseEntity) t).getId()));
			entityManager.merge(t);
			entityManager.flush();
			// entityTransaction.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.clear();
		}
		return t;
	}

	public <T> List<T> update(List<T> ts) throws Exception {
		List<T> list = new ArrayList<>();
		for (T t : ts) {
			list.add(update(t));
		}
		return list;
	}

	public <T> T delete(T t) throws Exception {
		try {
			// entityTransaction.begin();
			// entityManager.getReference(t.getClass() ,
			// ((BaseEntity)t).getId());
			// entityManager.merge(t);
			entityManager.remove(entityManager.getReference(t.getClass(),
					((BaseEntity) t).getId()));
			entityManager.flush();
			// entityTransaction.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.clear();
		}
		return t;
	}

	public <T> List<T> delete(List<T> ts) throws Exception {
		List<T> list = new ArrayList<>();
		for (T t : ts) {
			list.add(delete(t));
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public <T> T selectSingle(String queryName, Map<String, Object> params)
			throws Exception {
		// entityTransaction.begin();
		T t = null;
		Query query = entityManager.createNamedQuery(queryName);
		if (params != null) {
			for (Entry<String, Object> e : params.entrySet()) {
				query.setParameter(e.getKey(), e.getValue());
			}
		}
		t = (T) query.getSingleResult();
		entityManager.flush();
		entityManager.clear();
		// entityTransaction.commit();
		return t;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> executeNamedQuery(String queryName,
			Map<String, Object> params) throws Exception {
		// entityTransaction.begin();
		List<T> result = new ArrayList<>();
		Query query = entityManager.createNamedQuery(queryName);
		if (params != null) {
			for (Entry<String, Object> e : params.entrySet()) {
				query.setParameter(e.getKey(), e.getValue());
			}
		}
		result = query.getResultList();
		entityManager.flush();
		entityManager.clear();
		// entityTransaction.commit();
		return result;
	}

}
