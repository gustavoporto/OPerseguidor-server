package br.com.calcard.calsystem.service;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import br.com.calcard.calsystem.entity.BaseEntity;
import br.com.calcard.calsystem.util.Logger2;

@Repository
public class GenericService extends Logger2 {

	@PersistenceContext(unitName = "entityManager")
	private EntityManager entityManager;

	public GenericService() {
		super(GenericService.class);
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void doInsert(Object entity) {
		logger.info("Persistindo Objeto no banco de dados...");

		Date data = new Date();

		((BaseEntity) entity).setDataAtualizacao(data);
		((BaseEntity) entity).setDataRegistro(data);

		this.entityManager.persist(entity);
	}

	public void doUpdate(Object entity) {
		logger.info("Atualizando Objeto no banco de dados...");

		((BaseEntity) entity).setDataAtualizacao(new Date());

		this.entityManager.merge(entity);

	}

	public void doDelete(Object entity) {
		logger.info("Deletando Objeto no banco de dados...");
		this.entityManager.remove(this.entityManager.merge(entity));
	}

	@SuppressWarnings({ "rawtypes", "unchecked", })
	public Object doFind(Class classe, Integer primaryKey) {
		logger.info("Consultando Objeto no banco de dados...");
		return this.entityManager.find(classe, primaryKey);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object doFind(Class classe, String primaryKey) {
		logger.info("Consultando Objeto no banco de dados...");
		return this.entityManager.find(classe, primaryKey);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object doGetResultList(String query, Class classe, Map parametros) {
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object doFindAll(Class classe) {
		logger.info("Consultando lista de Objetos no banco de dados...");
		CriteriaQuery cq = this.entityManager.getCriteriaBuilder()
				.createQuery();
		cq.select(cq.from(classe));
		return this.entityManager.createQuery(cq).getResultList();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object doGetSingleResult(String query, Class classe, Map parametros) {

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
