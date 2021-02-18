package com.example.mybatis.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mybatis.domain.Employee;

@Repository
public class EmployeeMapper extends SqlSessionDaoSupport {

	// 使用SqlSessionDaoSupport必须注意，此处源码1.1.1中有自动注入，1.2中取消了自动注入，需要手工注入，侵入性强
	// 也可在spring-mybatis.xml中如下配置，但是这种有多少个dao就要配置到少个，多个dao就很麻烦。
	// <bean id="userDao" class="com.example.mybatis.dao.UserDao">
	// 		<property name="sqlSessionFactory" ref="sqlSessionFactory"/>
	// </bean>

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public Employee selectByPrimaryKey(int id) {
		return this.getSqlSession().selectOne(this.getClass().getName() + ".selectByPrimaryKey", 1);
	}
}