package com.example.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mvc.domain.User;

@Repository
public class UserDao {

//	@Autowired
//	private JdbcTemplate  jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public int getMathcCount(String userName, String passWord) {
//		String sqlStr = "SELECT COUNT(*) FROM T_USER WHERE user_name=? and password=?";
//		return jdbcTemplate.queryForObject(sqlStr, new Object[] { userName, passWord }, Integer.class);
		
		// 使用支持具名参数的jdbc
		String sqlStr = "SELECT COUNT(*) FROM T_USER WHERE user_name=:username and password=:password";
		Map<String,String> paramMap=new HashMap<>();
		paramMap.put("username", userName);
		paramMap.put("password", passWord);		
		return namedParameterJdbcTemplate.queryForObject(sqlStr, paramMap, Integer.class);
	}

	public User findUserByUserName(String userName) {
//		String sqlStr = "SELECT user_id,user_name,credits,last_visit,last_ip FROM T_USER WHERE user_name=?";
		String sqlStr = "SELECT user_id,user_name,credits,last_visit,last_ip FROM T_USER WHERE user_name=:username";
		
		Map<String,String> paramMap=new HashMap<>();
		paramMap.put("username",userName);
		User user = new User();
//		jdbcTemplate.query(sqlStr, new Object[] { userName }, new RowCallbackHandler() {
		namedParameterJdbcTemplate.query(sqlStr, paramMap, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(userName);
				user.setCredits(rs.getInt("credits"));
				user.setLastVisit(rs.getDate("last_visit"));
				user.setLastIp(rs.getString("last_ip"));
			}
		});
		return user;
	}

	public void updateLoginInfo(User user) {
//		String sqlStr = "UPDATE T_USER SET last_visit=?,last_ip=?,credits=? WHERE user_id=?";
		String sqlStr = "UPDATE T_USER SET last_visit=:visit,last_ip=:lastIp,credits=:credits WHERE user_id=:userId";
		
		Map<String,Object> paramMap=new HashMap<>();
		paramMap.put("visit",user.getLastVisit());
		paramMap.put("lastIp", user.getLastIp());
		paramMap.put("credits",user.getCredits());
		paramMap.put("userId", user.getUserId());
		
//		jdbcTemplate.update(sqlStr, new Object[] { user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId() });
		namedParameterJdbcTemplate.update(sqlStr, paramMap);
	}

}
