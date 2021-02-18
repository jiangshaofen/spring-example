package com.example.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mybatis.domain.Employee;
import com.example.mybatis.mapper.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	public Employee getEmployee(Integer id) {
		return employeeMapper.selectByPrimaryKey(id);
	}
}
