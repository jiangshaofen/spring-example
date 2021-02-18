package com.example.security.security.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.security.domain.SecurityUser;
import com.example.security.service.SecurityUserService;

/**
 * 用户登录认证成功后
 * @author jiang
 *
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Autowired
	private SecurityUserService securityUserService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// UserDetails 中存放着用户名等信息
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		// 获取该用户信息，根据自己的业务规则写
		SecurityUser serurityUser = securityUserService.selectByUserName(userDetails.getUsername());
		// 将用户放到 Session
		request.getSession().setAttribute("_secuser", serurityUser);
		// 跳转到主页
		response.sendRedirect(request.getContextPath() + "/main/common");
	}

}
