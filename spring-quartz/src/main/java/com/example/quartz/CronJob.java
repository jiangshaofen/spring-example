package com.example.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jiang
 *
 */
public class CronJob implements Job {

	private static Logger log = LoggerFactory.getLogger(CronJob.class);

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.info("通过CronScheduleBuilder，实现 Job 接口， triggerName:" + arg0.getTrigger().getClass().getName());
		log.info("Welcome to Spring_Quartz World! " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		log.info("Let's begin ! \n \n");
	}
}
