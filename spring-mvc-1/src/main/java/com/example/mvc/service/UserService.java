package com.example.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.dao.LoginLogDao;
import com.example.mvc.dao.UserDao;
import com.example.mvc.domain.LoginLog;
import com.example.mvc.domain.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;

	public boolean hasMatchUser(String userName, String passWord) {
		int count = userDao.getMathcCount(userName, passWord);
		return count > 0;
	}

	@Transactional(readOnly = true) // 覆盖类级别的 readOnly=false
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}

	public void loginSuccess(User user) {
		user.setCredits(5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setLoginIp(user.getLastIp());
		loginLog.setLoginDateTime(user.getLastVisit());

		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}
}
