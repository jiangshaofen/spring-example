package com.example.spring.beanLifeCycle.beanFactoryBeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * 后处理器，也称容器级生命周期接口.<br/>
 * 实现类以容器附加配置的形式注册到spring容器中，通过接口反射为spring容器预先识别， <br/>
 * 当spring容器创建任何bean的时候，这些后处理器都会发生作用，初始化 bean 实例之前将调用.
 * 
 * @author jiang
 *
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	public MyInstantiationAwareBeanPostProcessor() {
		super();
		System.out.println("这是 InstantiationAwareBeanPostProcessor 实现类 MyInstantiationAwareBeanPostProcessor 构造器。");
	}
	
	// 接口方法，在实例化 bean 前进行调用.
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) {
		// 仅对容器中 car bean 进行处理
		if ("car".equals(beanName)) {
			System.out.println("InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
		}
		return null;
	}

	// 接口方法，在实例化 bean 后调用.
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		// 仅对容器中 car bean 进行处理
		if ("car".equals(beanName)) {
			System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
		}
		return true;
	}

	// 接口方法，在设置某个属性时调用.
	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
			throws BeansException {
		// 仅对容器中的 car bean 进行处理
		if ("car".equals(beanName)) {
			System.out.println("InstantiationAwareBeanPostProcessor.postProcessProperties");
		}
		return pvs;
	}
}
