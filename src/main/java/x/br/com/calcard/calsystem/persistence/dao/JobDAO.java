package x.br.com.calcard.calsystem.persistence.dao;

import java.util.List;

import br.com.calcard.calsystem.entity.Job;

public interface JobDAO {

	Job findOne(long id);

	List<Job> findAll();

	void create(Job entity);

	Job update(Job entity);

	void delete(Job entity);

	void deleteById(long entityId);

}
