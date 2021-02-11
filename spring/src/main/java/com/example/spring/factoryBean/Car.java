package com.example.spring.factoryBean;

public class Car {
	private String brand = "";
	private String color = "";
	private int speed = 0;

	public Car() {}
	
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
}
