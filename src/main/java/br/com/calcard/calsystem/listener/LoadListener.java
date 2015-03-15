package br.com.calcard.calsystem.listener;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.calcard.calsystem.service.JobService;

public class LoadListener {

	@Autowired
	private JobService jobService;

	public void init() throws SchedulerException {
		this.inicializarJobs();
	}

	private void inicializarJobs() throws SchedulerException {
		// jobService.inicializarJobs();
	}

}
