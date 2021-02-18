package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.domain.SecurityUser;
import com.example.security.mapper.SecurityUserMapper;

/**
 * 
 * @author jiang
 *
 */
@Service
public class SecurityUserService {

	@Autowired
	SecurityUserMapper securityUserMapper;
	
	public SecurityUser selectByUserName(String username)
	{
		return securityUserMapper.selectByUserName(username);
	}
}
