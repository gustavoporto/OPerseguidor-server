package br.com.calcard.calsystem.teste;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import br.com.calcard.calsystem.entity.Job;
import br.com.calcard.calsystem.service.JobService;

public class ScheduledJob extends QuartzJobBean {

	private AnotherBean anotherBean;

	private JobService jobService;

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		
		System.out.println("Oi");
		// anotherBean.printAnotherMessage();
		// List<Job> job = anotherBean.listJobsAtivos();
	}

	public void setAnotherBean(AnotherBean anotherBean) {
		this.anotherBean = anotherBean;
	}

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

}
