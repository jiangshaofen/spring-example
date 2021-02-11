package com.example.spring.ioc.annoConfig;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解方式定义 bean ,需要在 applicationContext.xml 里配置扫描节点.
 * 
 * @author jiang
 *
 */
public class AnnoConfigExample {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new ClassPathXmlApplicationContext(
				"classpath*:com/example/spring/ioc/annoConfig/beans*.xml");
		Car car = factory.getBean("car", Car.class);
		System.out.println("test annoConfig result:" + car);

		// 关闭容器
		factory.close();
	}

}
