package com.example.mybatis.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mybatis.domain.Employee;

@Repository
public class EmployeeMapper {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public Employee selectByPrimaryKey(Integer id) {
		
		return sqlSessionTemplate.selectOne(this.getClass().getName()+".selectByPrimaryKey", id);
	}

}