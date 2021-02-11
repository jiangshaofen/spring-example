package com.example.spring.beanLifeCycle.applicationContextBeanLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// 管理bean生命周期接口
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean, ApplicationContextAware {
	private String brand = "";
	private String color = "";
	private int speed = 0;

	@SuppressWarnings("unused")
	private BeanFactory beanFactory;
	@SuppressWarnings("unused")
	private String beanName;

	public Car() {
		System.out.println("调用了 Car() 构造函数。");
	}

	public Car(String brand, String color, int speed) {
		super();
		this.brand = brand;
		this.color = color;
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", color=" + color + ", speed=" + speed + "]";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		System.out.println("调用 setBrand() 设置属性。");
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		System.out.println("调用 setColor() 设置属性。");
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		System.out.println("调用 setSpeed() 设置属性。");
		this.speed = speed;
	}

	public void introduce() {
		System.out.println("brand=" + brand + ", color=" + color + ", speed=" + speed);
	}

	// BeanFactoryAware 接口方法
	@Override
	public void setBeanFactory(BeanFactory beanFactory) {
		System.out.println("调用 BeanFactoryAware.setBeanFactory()。");
		this.beanFactory = beanFactory;
	}

	// BeanNameAware 接口方法
	@Override
	public void setBeanName(String beanName) {
		System.out.println("调用 BeanNameAware.setBeanName()。");
		this.beanName = beanName;
	}

	// InitializingBean 接口方法
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("调用 InitializingBean.afterPropertiesSet()。");
	}

	// DisposableBean 接口方法
	@Override
	public void destroy() throws Exception {
		System.out.println("调用 DisposableBean.destroy()。");
	}

	// 通过 <bean> 的 init-method 属性指定的初始化方法
	public void myInit() {
		System.out.println("调用 init-method 所指定的 myInit()，将 speed 设置为240。");
		this.setSpeed(240);
	}

	// 通过 <bean> 的 destroy-method 属性指定的销毁方法
	public void myDestroy() {
		System.out.println("调用 destroy-method 所指定的 myDestroy()。");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		 System.out.println("调用 ApplicationContextAware.setApplicationContext()。");
		
	}

}
