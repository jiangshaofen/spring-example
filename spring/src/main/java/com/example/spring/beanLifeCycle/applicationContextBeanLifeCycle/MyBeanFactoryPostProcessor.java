package com.example.spring.beanLifeCycle.applicationContextBeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 工厂后处理器.<br/>
 * 如果配置文件中声明了工厂后处理器接口 BeanFactoryPostProcessor 的实现类，<br/>
 * 则应用上下文在装载配置文件之后 初始化 bean 实例之前将调用.
 * 
 * @author jiang
 *
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public MyBeanFactoryPostProcessor() {
		super();
		System.out.println("这是 BeanFactoryPostProcessor 实现类 MyBeanFactoryPostProcessor 构造器。");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
		BeanDefinition bd = bf.getBeanDefinition("car");
		bd.getPropertyValues().addPropertyValue("brand", "上海大众");
		System.out.println("调用 BeanFactoryPostProcessor.postProcessBeanFactory()。");
	}
}
