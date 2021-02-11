package com.example.spring.ioc.javaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * 基于 java 类编程方式定义 bean,不需要 xml 配置文件.
 * 
 * @author jiang
 *
 */
public class BeanConfigExample {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new AnnotationConfigApplicationContext(BeanConfig.class);
		Car car = factory.getBean(Car.class); 
		System.out.println("test javaConfig result:" + car);
		
		// 关闭容器
		factory.close();
	}
}
