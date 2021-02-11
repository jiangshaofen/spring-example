package com.example.spring.beanLifeCycle.beanFactoryBeanLifeCycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanFactoryBeanLifeCycleExample {

	public static void main(String[] args) {
		// 下面两句装载配置文件并启动容器
		Resource resource = new ClassPathResource("com/example/spring/beanLifeCycle/beanFactoryBeanLifeCycle/beans.xml");
		BeanFactory factory = new DefaultListableBeanFactory();
		BeanDefinitionReader bdr = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
		System.out.println("开始初始化容器，bean 没有被实例化");
		bdr.loadBeanDefinitions(resource);
		System.out.println("容器初始化成功");
		
		// 向容器中注册 MyBeanPostProcessor 后处理器
		((ConfigurableBeanFactory) factory).addBeanPostProcessor(new MyBeanPostProcessor());

		// 向容器中注册 MyInstantiationAwareBeanPostProcessor 后处理器
		((ConfigurableBeanFactory) factory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

		// 第一次从容器中获取 car，将触发容器实例化该 bean，这将引发 bean 生命周期方法的调用
		Car car1 = (Car) factory.getBean("car");
		car1.introduce();
		car1.setColor("红色");

		// 第二次从容器中获取 bean，直接从缓存池中获取
		Car car2 = (Car) factory.getBean("car");

		// 查看 car1 和 car2 是否指向同一个引用
		System.out.println("car1==car2:" + (car1 == car2));
		
		System.out.println("现在开始关闭容器");
		// 关闭容器
		((DefaultListableBeanFactory) factory).destroySingletons();
		System.out.println("容器关闭成功");
	}
}
