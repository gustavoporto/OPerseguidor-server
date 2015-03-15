package x.br.com.calcard.calsystem.persistence.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.calcard.calsystem.entity.Job;

@Repository
public class JobDaoImpl implements JobDAO {

//	@Autowired
	private SessionFactory sessionFactory;

	public Job findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Job> findAll() {
		@SuppressWarnings("unchecked")
		List<Job> listUser = (List<Job>) sessionFactory.getCurrentSession()
				.createCriteria(Job.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	public void create(Job entity) {
		// TODO Auto-generated method stub

	}

	public Job update(Job entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Job entity) {
		// TODO Auto-generated method stub

	}

	public void deleteById(long entityId) {
		// TODO Auto-generated method stub

	}

}
