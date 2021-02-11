package com.example.spring.beanLifeCycle.applicationContextBeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 后处理器，也称容器级生命周期接口.<br/>
 * 实现类以容器附加配置的形式注册到spring容器中，通过接口反射为spring容器预先识别， <br/>
 * 当spring容器创建任何bean的时候，这些后处理器都会发生作用.
 * 
 * @author jiang
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	public MyBeanPostProcessor() {
		super();
		System.out.println("这是 BeanPostProcessor 实现类 MyBeanPostProcessor 构造器。");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("car".equals(beanName)) {
			Car car = (Car) bean;
			if ("黑色".equals(car.getColor())) {
				System.out.println("调用  BeanPostProcessor.postProcessBeforeInitialization(),color 设置为红色。");
				car.setColor("红色");
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("car".equals(beanName)) {
			Car car = (Car) bean;
			if (car.getSpeed() >= 200) {
				System.out.println("调用 BeanPostProcessor.postProcessAfterInitialization(),将 speed 调整为 200。");
				car.setSpeed(200);
			}
		}
		return bean;
	}
}
