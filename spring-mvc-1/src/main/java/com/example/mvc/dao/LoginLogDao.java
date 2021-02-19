package com.example.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mvc.domain.LoginLog;

@Repository
public class LoginLogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertLoginLog(LoginLog loginLog) {
		String sqlStr = "INSERT INTO T_LOGIN_LOG(user_id,login_ip,login_datetime) VALUES(?,?,?)";

		jdbcTemplate.update(sqlStr, new Object[] { loginLog.getUserId(), loginLog.getLoginIp(), loginLog.getLoginDateTime() });
	}
}
