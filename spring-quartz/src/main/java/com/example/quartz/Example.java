package com.example.quartz;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 整合 Quartz 的 Hello World!
 *@author jiang
 */
public class Example {

	public static void main(String[] args) {

//		xmlConfigSchedule();

//		startSimpleSchedule();

//		startCronSchedule();

		resumeJob();
	}

	
	public static void xmlConfigSchedule() {
		try {
			AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring_quartz.xml");
			Scheduler scheduler = (StdScheduler) ctx.getBean("scheduler");

			scheduler.start();

			// 关闭容器后，将关闭定时调度器
//			ctx.close();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public static void startSimpleSchedule() {
		try {
			// 1、创建一个JobDetail实例，指定Quartz
			JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class)
					// 任务执行类
					.withIdentity("job1_1", "jGroup1")
					// 任务名，任务组
					.build();

			// 触发器类型
			// SimpleScheduleBuilder
			SimpleScheduleBuilder builder = SimpleScheduleBuilder
					// 设置执行次数
					.repeatSecondlyForTotalCount(15);

			// 2、创建Trigger
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1_1", "tGroup1").startNow()
					.withSchedule(builder).build();

			// 3、创建Scheduler
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			// 4、调度执行
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public static void startCronSchedule() {
		try {
			// 1、创建一个JobDetail实例，指定Quartz
			JobDetail jobDetail = JobBuilder.newJob(CronJob.class)
					// 任务执行类
					.withIdentity("job1_2", "jGroup2")
					// 任务名，任务组
					.build();

			// 触发器类型
			CronScheduleBuilder builder = CronScheduleBuilder
					// 设置表达式
					.cronSchedule("0/2 * * * * ?");

			// 2、创建Trigger
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1_2", "tGroup2").startNow()
					.withSchedule(builder).build();

			// 3、创建Scheduler
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

			// 4、调度执行
			scheduler.scheduleJob(jobDetail, trigger);

			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从数据库中找到已经存在的job，并重新开户调度
	 */
	public static void resumeJob() {
		try {
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			JobKey jobKey = new JobKey("job1", "group1");
			List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
			// SELECT TRIGGER_NAME, TRIGGER_GROUP FROM {0}TRIGGERS WHERE SCHED_NAME = {1}
			// AND JOB_NAME = ? AND JOB_GROUP = ?
			// 重新恢复在group1组中，名为job1的 job的触发器运行
			if (triggers.size() > 0) {
				for (Trigger tg : triggers) {
					// 根据类型判断
					if ((tg instanceof CronTrigger) || (tg instanceof SimpleTrigger)) {
						// 恢复job运行
						scheduler.resumeJob(jobKey);
					}
				}
				scheduler.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
