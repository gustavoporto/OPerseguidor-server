package br.com.calcard.calsystem.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.calsystem.entity.Job;
import br.com.calcard.calsystem.service.JobService;

@RestController
@RequestMapping("/ws/job")
public class JobWS extends AbstractWS<JobWS> {

	@Autowired
	private JobService jobService;

	public JobWS() {
		super(JobWS.class);
	}

	@RequestMapping(value = "/reiniciarJobs", method = RequestMethod.GET, produces = "application/json")
	public List<JobKey> reiniciarJobs() {

		jobService.cancelarJobs();
		try {
			jobService.inicializarJobs();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return listJobsAtivos();

	}

	@RequestMapping(value = "/cancelarJobs", method = RequestMethod.GET, produces = "application/json")
	public void cancelarJobs() {
		try {
			logger.info("Cancelando Jobs");

			jobService.cancelarJobs();

		} catch (Exception e) {
			logger.error("Erro ao cancelar Jobs", e);
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/listJobsAtivos", method = RequestMethod.GET, produces = "application/json")
	public List<JobKey> listJobsAtivos() {
		try {
			logger.info("Listando Jobs ativos");

			List<JobKey> jobs = new ArrayList<JobKey>();

			Scheduler scheduler = new StdSchedulerFactory().getScheduler();

			for (String groupName : scheduler.getJobGroupNames()) {

				for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher
						.jobGroupEquals(groupName))) {

					jobs.add(jobKey);

					List<Trigger> triggers = (List<Trigger>) scheduler
							.getTriggersOfJob(jobKey);
					Date nextFireTime = triggers.get(0).getNextFireTime();

					System.out.println("[jobName] : " + jobKey.getName()
							+ " [groupName] : " + jobKey.getGroup() + " - "
							+ nextFireTime);

				}

			}

			return jobs;

		} catch (Exception e) {
			logger.error("Erro ao listar os Jobs ativos.", e);
			e.printStackTrace();
			return null;

		}

	}

	@RequestMapping(value = "/inicializarJobs", method = RequestMethod.GET, produces = "application/json")
	public List<JobKey> inicializarJobs() {
		try {
			logger.info("Startando Jobs");
			jobService.inicializarJobs();
			return listJobsAtivos();
		} catch (Exception e) {
			logger.error("Erro ao startar Jobs", e);
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping(value = "/getJobByNome", method = RequestMethod.GET, produces = "application/json")
	public Job getJobByNome(@RequestParam(value = "nome") String nome) {
		try {
			logger.info("Consultando Job pelo nome " + nome);

			return jobService.getJobByNome(nome);

		} catch (Exception e) {
			logger.error("Erro ao consultar Job pelo nome " + nome, e);
			e.printStackTrace();
			return null;
		}
	}

}
