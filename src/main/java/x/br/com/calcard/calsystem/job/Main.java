package x.br.com.calcard.calsystem.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

//import x.br.com.calcard.calsystem.service.JobService;

public class Main {

	public static void main(String[] args) {
		// try {
		//
		// // JobService jobService = new JobService();
		// // jobService.agendarJobs();
		//
		// } catch (SchedulerException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(gc.getTime());

		gc.add(Calendar.MINUTE, 30);
		System.out.println(sdf.format(gc.getTime()));

	}

}
