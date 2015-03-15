package br.com.calcard.calsystem.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import br.com.calcard.calsystem.entity.Job;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class JobArquivoTask extends AbstractService<JobArquivoTask>
		implements Runnable {

	private Job job;
	private Session session = null;
	private ChannelSftp channel;

	public JobArquivoTask() {
		super(JobArquivoTask.class);
	}

	private String formatarNomeArquivo(String nomeArquivo) {

		SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");

		if (nomeArquivo.contains("<yyyyMMdd>")) {
			return nomeArquivo.replace("<yyyyMMdd>", dt.format(new Date()));
		} else
			return nomeArquivo;

	}

	private void conectar(String usuario, String senha, String host, int porta,
			String chavePrivada) throws JSchException {

		JSch jsch = new JSch();

		if (!chavePrivada.equals(null))
			jsch.addIdentity(chavePrivada);

		session = jsch.getSession(usuario, host, porta);

		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);

		session.connect();

		Channel c = session.openChannel("sftp");

		c.connect();

		channel = (ChannelSftp) c;
	}

	public void desconectar() {
		channel.disconnect();
		session.disconnect();
	}

	public void run() {
		try {

			conectar(job.getUsuarioOrigem(), job.getSenhaOrigem(),
					job.getHostOrigem(), job.getPortaOrigem(),
					job.getChavePrivadaOrigem());

			job.setNomeArquivoOrigem(formatarNomeArquivo(job
					.getNomeArquivoOrigem()));

			channel.get(job.getDiretorioOrigem() + job.getNomeArquivoOrigem(),
					"C:/assistencia/" + job.getNomeArquivoOrigem());

			desconectar();

		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("*** Fim método JobTransferenciaArquivos.run ***");
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}
