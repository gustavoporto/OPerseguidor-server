package x.br.com.calcard.calsystem.email;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class EnviarEmail implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println ("Disparou:" + new Date());
		
	}
}
