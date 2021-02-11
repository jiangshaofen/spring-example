package com.example.spring.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
	private String carInfo;

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	/**
	 * 实例化 Car bean.
	 */
	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		String[] infos = carInfo.split(",");
		car.setBrand(infos[0]);
		car.setColor(infos[1]);
		car.setSpeed(Integer.parseInt(infos[2]));
		return car;
	}

	/**
	 * 返回 Car 的类型.
	 */
	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	/**
	 * 通过 FactoryBean 返回的 bean 不是 singleton,<br/>
	 * 接口中此方法是默认实现方法，默认值是 true.
	 */
	@Override
	public boolean isSingleton() {
		return false;
	}
}
