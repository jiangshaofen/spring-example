package com.example.spring.ioc.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean(name = "car")
	public Car car() {
		return new Car();
	}
}
