package com.example.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybatis.domain.Employee;
import com.example.mybatis.mapper.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	 @Transactional
	public Employee getEmployee(Employee emp) {
		return employeeMapper.selectByPrimaryKey(emp);
	}
}
