package br.com.calcard.calsystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.calcard.calsystem.entity.Job;

@Repository
public class JobService extends AbstractService<JobService> {

	public static final String JOB_001 = "JOB_SEGUROS_VENDIDOS";
	public static final String JOB_002 = "JOB_PROPOSTAS_ATIVADAS";

	@Autowired
	private SeguroService seguroService;

	@Autowired
	private PropostaService propostaService;

	public JobService() {
		super(JobService.class);
	}

	public void cancelarJobs() {
		try {
			logger.info("Cancelando Jobs");

			Scheduler scheduler = new StdSchedulerFactory().getScheduler();

			scheduler.shutdown();

			// List<JobExecutionContext> currentlyExecuting = scheduler
			// .getCurrentlyExecutingJobs();
			//
			// for (JobExecutionContext jobExecutionContext :
			// currentlyExecuting) {
			//
			// scheduler
			// .interrupt(jobExecutionContext.getJobDetail().getKey());
			//
			// }

		} catch (Exception e) {
			logger.error("Erro ao cancelar Jobs", e);
			e.printStackTrace();
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void doInicializarJobPropostasAtivadas() {
		logger.info("Método: doInicializarJobPropostasAtivadas");

		try {

			Scheduler scheduler;
			Map map = new HashMap();
			scheduler = new StdSchedulerFactory().getScheduler();

			map.put("propostaService", propostaService);

			JobKey jobKey = new JobKey(JOB_002, "group1");
			JobDetail jobDetail = JobBuilder.newJob(JobTask.class)
					.withIdentity(jobKey).setJobData(new JobDataMap(map))
					.build();

			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity(JOB_002, "group1")
					.withSchedule(
							CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
					.build();

			scheduler.start();
			scheduler.scheduleJob(jobDetail, trigger);

		} catch (SchedulerException e) {
			logger.error("Não foi possível inicializar o job [" + JOB_001
					+ "] - ", e);
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void doInicializarJobSegurosVendidos() {
		logger.info("Método: inicializarJobSegurosVendidos");

		try {

			Scheduler scheduler;
			Map map = new HashMap();
			scheduler = new StdSchedulerFactory().getScheduler();

			map.put("seguroService", seguroService);

			JobKey jobKey = new JobKey(JOB_001, "group1");
			JobDetail jobDetail = JobBuilder.newJob(JobTask.class)
					.withIdentity(jobKey).setJobData(new JobDataMap(map))
					.build();

			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withIdentity(JOB_001, "group1")
					.withSchedule(
							CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
					.build();

			scheduler.start();
			scheduler.scheduleJob(jobDetail, trigger);

		} catch (SchedulerException e) {
			logger.error("Não foi possível inicializar o job [" + JOB_001
					+ "] - ", e);
		}

	}

	public void inicializarJobs() {
		logger.info("Método: inicializarJobs");

		this.doInicializarJobSegurosVendidos();
		this.doInicializarJobPropostasAtivadas();

	}

	public List<Job> listJobsAtivos() {
		logger.info("Listando Jobs ativos");

		TypedQuery<Job> query = getEntityManager().createQuery(
				"SELECT j FROM Job j where j.status = :status", Job.class)
				.setParameter("status", "ATIVO");

		List<Job> jobs = query.getResultList();
		logger.info(jobs.size() + " Job(s) ativo(s) encontrado(s).");

		return jobs;
	}

	public Job getJobByNome(String nome) {
		logger.info("Consultando Job no banco de dados pelo nome " + nome);

		return getEntityManager()
				.createQuery("Select j from Job j where j.nome = :nome",
						Job.class).setParameter("nome", nome).getSingleResult();

	}
}
