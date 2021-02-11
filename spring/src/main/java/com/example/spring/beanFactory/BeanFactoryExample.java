package com.example.spring.beanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class BeanFactoryExample {

	public static void main(String[] args) {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("classpath:com/example/spring/beanFactory/beans.xml");
		BeanFactory factory = new DefaultListableBeanFactory();
		BeanDefinitionReader bdr = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
		System.out.println("init BeanFactory，bean 在第一次使用时实例化.");
		bdr.loadBeanDefinitions(resource);
		Car car = factory.getBean("car", Car.class);
		System.out.println("BeanFactory car:" + car);
		// 关闭容器
		System.out.println("close BeanFactory\n");
		((DefaultListableBeanFactory) factory).destroySingletons();

		// "com/example/spring/beanFactory/beans.xml"等同于
		// "classpath:com/example/spring/beanFactory/beans.xml"
		System.out.println("init ClassPathXmlApplicationContext，bean 同时实例化");
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/example/spring/beanFactory/beans.xml");
		car = ctx.getBean("car", Car.class);
		System.out.println("ClassPathXmlApplicationContext car:" + car);
		// 关闭容器
		System.out.println("close ClassPathXmlApplicationContext\n");
		ctx.close();

		// "com/example/spring/beanFactory/beans.xml"等同于
		// "file:src/main/java/com/example/spring/beanFactory/beans.xml"
		System.out.println("init FileSystemXmlApplicationContext，bean 同时实例化");
		ctx = new FileSystemXmlApplicationContext("file:src/main/java/com/example/spring/beanFactory/beans.xml");
		car = ctx.getBean("car", Car.class);
		System.out.println("FileSystemXmlApplicationContext car:" + car);
		// 关闭容器
		System.out.println("close FileSystemXmlApplicationContext\n");
		ctx.close();

	}
}
