package com.example.spring.factoryBean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarFactoryBeanExample {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new ClassPathXmlApplicationContext(
				"classpath*:com/example/spring/factoryBean/beans.xml");
		Car car = factory.getBean("car", Car.class);
		System.out.println("car.brand:" + car.getBrand());
		
		// 关闭容器
		factory.close();
	}

}
