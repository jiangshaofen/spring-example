package com.example.spring.ioc.xmlConfig;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这是采用 xml 配置方式定义bean.
 * 
 * @author jiang
 *
 */
public class XmlConfigExample {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new ClassPathXmlApplicationContext(
				"classpath*:com/example/spring/ioc/xmlConfig/beans*.xml");
		Car car = factory.getBean("car", Car.class);
		System.out.println("test xmlConfig result:" + car);
		
		// 关闭容器
		factory.close();
	}
}
