package br.com.calcard.calsystem.service;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class JobTask extends QuartzJobBean {

	private SeguroService seguroService;

	private PropostaService propostaService;

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		String nomeJob = context.getJobDetail().getKey().getName();

		if (nomeJob.equals(JobService.JOB_001)) {
			seguroService.doAtualizarSegurosVendidos();

		} else if (nomeJob.equals(JobService.JOB_002)) {
			propostaService.doAtualizarPropostaAtivadas();
		}

		// try {
		//
		// JobArquivoTask jobArquivoTask = new JobArquivoTask();
		//
		// jobArquivoTask.setJob(jobService.getJobByNome());
		//
		// Thread thread = new Thread(jobArquivoTask);
		// thread.start();
		//
		// } catch (Exception e) {
		// System.err.println(e);
		// }

	}

	public SeguroService getSeguroService() {
		return seguroService;
	}

	public void setSeguroService(SeguroService seguroService) {
		this.seguroService = seguroService;
	}

	public PropostaService getPropostaService() {
		return propostaService;
	}

	public void setPropostaService(PropostaService propostaService) {
		this.propostaService = propostaService;
	}

}
