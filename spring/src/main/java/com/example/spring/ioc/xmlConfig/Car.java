package com.example.spring.ioc.xmlConfig;

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

	public void initMethod() {
		System.out.println("这是在 xml 中配置的 init-method 方法，采用注解方式时，可同时注册多个");
	}

	public void destroyMethod() {
		System.out.println("这是在 xml 中配置的 destroy-method 方法，采用注解方式时，可同时注册多个");
	}
}
