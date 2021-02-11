package com.example.spring.beanLifeCycle.applicationContextBeanLifeCycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextBeanLifeCycleExample {

	public static void main(String[] args) {
		System.out.println("开始初始化容器，bean 同时实例化");
		AbstractApplicationContext factory = new ClassPathXmlApplicationContext(
				"classpath*:com/example/spring/beanLifeCycle/applicationContextBeanLifeCycle/beans.xml");
		System.out.println("容器初始化成功");
		
		// 得到Car，并使用
		Car car = factory.getBean("car", Car.class);
		System.out.println(car);

		System.out.println("现在开始关闭容器");
		factory.close();
		System.out.println("容器关闭成功");
	}
}
