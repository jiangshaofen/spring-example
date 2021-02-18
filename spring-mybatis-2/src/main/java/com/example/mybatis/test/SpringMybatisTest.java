package com.example.mybatis.test;

import java.io.IOException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.mybatis.domain.Employee;
import com.example.mybatis.service.EmployeeService;

public class SpringMybatisTest {

	public static void main(String[] args) throws IOException {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		EmployeeService employeService = ctx.getBean(EmployeeService.class);
		Employee employee = employeService.getEmployee(1);
		System.out.println(employee.toString());
		System.out.println(employee.getEmail());

		// 关闭容器
		ctx.close();
	}
}
