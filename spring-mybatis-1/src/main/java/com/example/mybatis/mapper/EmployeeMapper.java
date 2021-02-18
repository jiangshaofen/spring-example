package com.example.mybatis.mapper;

import com.example.mybatis.domain.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Employee record);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}