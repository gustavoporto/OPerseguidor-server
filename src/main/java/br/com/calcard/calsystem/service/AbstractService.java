package br.com.calcard.calsystem.service;

import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import br.com.calcard.calsystem.util.Logger;

@SuppressWarnings("unchecked")
public abstract class AbstractService<T> extends Logger<T> {

	@PersistenceContext(unitName = "entityManager")
	private EntityManager entityManager;

	public AbstractService(Class<T> entityClass) {
		super(entityClass);
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	protected void doCreate(Object entity) {
		logger.info("Persistindo Objeto no banco de dados...");
		this.entityManager.persist(entity);
	}

	protected void edit(Object entity) {
		logger.info("Atualizando Objeto no banco de dados...");
		this.entityManager.merge(entity);

	}

	protected void remove(Object entity) {
		logger.info("Deletando Objeto no banco de dados...");
		this.entityManager.remove(this.entityManager.merge(entity));
	}

	@SuppressWarnings("rawtypes")
	protected Object doFind(Class classe, Integer primaryKey) {
		logger.info("Consultando Objeto no banco de dados...");
		return this.entityManager.find(classe, primaryKey);
	}

	@SuppressWarnings("rawtypes")
	protected Object doFind(Class classe, String primaryKey) {
		logger.info("Consultando Objeto no banco de dados...");
		return this.entityManager.find(classe, primaryKey);
	}

	@SuppressWarnings("rawtypes")
	protected Object doGetResultList(String query, Class classe, Map parametros) {
		logger.info("Método: doGetResultList");

		Query q = getEntityManager().createQuery(query, classe);

		if (parametros != null) {
			Iterator it = parametros.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry parametro = (Map.Entry) it.next();
				q.setParameter((String) parametro.getKey(),
						parametro.getValue());
			}
		}

		try {
			return q.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	protected Object findAll(Class classe) {
		logger.info("Consultando lista de Objetos no banco de dados...");
		CriteriaQuery cq = this.entityManager.getCriteriaBuilder()
				.createQuery();
		cq.select(cq.from(classe));
		return this.entityManager.createQuery(cq).getResultList();
	}

	@SuppressWarnings("rawtypes")
	protected Object doGetSingleResult(String query, Class classe,
			Map parametros) {

		Query q = getEntityManager().createQuery(query, classe);

		Iterator it = parametros.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry parametro = (Map.Entry) it.next();
			q.setParameter((String) parametro.getKey(), parametro.getValue());
		}

		try {
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}
}