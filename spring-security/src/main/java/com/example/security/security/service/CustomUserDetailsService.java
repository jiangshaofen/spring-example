package com.example.security.security.service;


import java.util.ArrayList;  
import java.util.Collection;  
import java.util.List;  
import org.apache.log4j.Logger;

import com.example.security.domain.SecurityUser;
import com.example.security.service.SecurityUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;  
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;  
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;  
import org.springframework.security.core.userdetails.UserDetails;  
import org.springframework.security.core.userdetails.UserDetailsService;  
import org.springframework.security.core.userdetails.UsernameNotFoundException;  
import org.springframework.util.StringUtils;
  
/**
 * 一个自定义的service用来和数据库进行操作. 即以后我们要通过数据库保存权限.则需要我们继承UserDetailsService
 * @author jiang
 *
 */
public class CustomUserDetailsService implements UserDetailsService {  
    protected static Logger logger = Logger.getLogger("service");
    
    @Autowired
    private SecurityUserService securityUserService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {  
    	if(!StringUtils.hasLength(username)) {
            throw new BadCredentialsException("用户名不能为空");
        }
    	
    	UserDetails userdetails = null;  

        try {
	    	//根据用户名从数据库查询用户信息，根据自己的业务规则去写
	        SecurityUser serurityUser = securityUserService.selectByUserName(username);
	        if(serurityUser == null) {
	            throw new BadCredentialsException("用户名不存在");
	        }
			int access = 0;
			if ("admin".equals(username))
				access = 1;
	        
	        userdetails = new User(
	        		serurityUser.getUsername(),
	        		serurityUser.getPassword(),
	        		true,               //激活状态，true:yes;false:no
	                true,               //账号过期状态，true:no;false;yes
	                true,               //证书过期状态，true:no;false;yes
	                true,               //账号锁定状态，true:no;false;yes
	                getAuthorities(access)
	                //AuthorityUtils.createAuthorityList("ROLE_USER")
	                );
  
        } catch (Exception e) {  
            logger.error("Error in retrieving user");  
            throw new UsernameNotFoundException("Error in retrieving user");  
        }  
  
        return userdetails;  
    }  
  
    /** 
     * 访问角色权限，可根据业务情况自行扩展
     *  
     * @param access 
     * @return 
     */  
    public Collection<GrantedAuthority> getAuthorities(Integer access) {  
  
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);  
  
        //所有的用户默认拥有ROLE_USER权限  
        logger.debug("Grant ROLE_USER to this user");  
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));  
  
        //如果参数access为1.则拥有ROLE_ADMIN权限  
        if (access.compareTo(1) == 0) {
            logger.debug("Grant ROLE_ADMIN to this user");  
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));  
        }  
  
        return authList;  
    }  
}  
