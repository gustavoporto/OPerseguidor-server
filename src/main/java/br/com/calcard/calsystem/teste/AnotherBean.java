package br.com.calcard.calsystem.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.calcard.calsystem.entity.Job;
import br.com.calcard.calsystem.service.AbstractService;

@Repository
@Component("anotherBean")
public class AnotherBean extends AbstractService<AnotherBean> {

	public AnotherBean() {
		super(AnotherBean.class);
	}

	public List<Job> listJobsAtivos() {
		logger.info("Listando Jobs ativos no banco de dados");

		List<Job> jobs = new ArrayList<Job>();

		TypedQuery<Job> query = getEntityManager().createQuery(
				"SELECT j FROM Job j where j.status = :status", Job.class)
				.setParameter("status", "ATIVO");

		return query.getResultList();
	}

	public void printAnotherMessage() {
		System.out
				.println("I am called by Quartz jobBean using CronTriggerFactoryBean");
	}

}
