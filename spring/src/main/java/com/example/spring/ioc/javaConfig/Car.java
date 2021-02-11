package com.example.spring.ioc.javaConfig;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car {
	private String brand = "";
	private String color = "";
	private int speed = 0;

	public Car() {
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
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	// 可注入多个@PostConstruct，但是在 xml中只可以配置一个 init-method
	@PostConstruct
	public void init1() {
		System.out.println("execute in init1");
	}

	@PostConstruct
	public void init2() {
		System.out.println("exceute in init2");
	}

	// 可注入多个@PreDestroy，但是在 xml中只可以配置一个 destroy-method
	@PreDestroy
	public void destroy1() {
		System.out.println("execute in destroy1");
	}

	@PreDestroy
	public void destroy2() {
		System.out.println("execute in destroy1");
	}
}
