package com.example.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 将自定义业务方法作为定时任务执行，无需实现 Job 接口.
 * @author jiang
 *
 */
public class NoImplJob {

	private static Logger log = LoggerFactory.getLogger(NoImplJob.class);

	public void say() {
		log.info("将自定义业务方法作为定时任务执行，无需实现 Job 接口.");
		log.info("Welcome to Spring_Quartz World! " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		log.info("Let's begin ! \n \n");
	}
}
