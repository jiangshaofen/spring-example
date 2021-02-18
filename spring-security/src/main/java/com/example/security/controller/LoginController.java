package com.example.security.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author jiang
 *
 */
@Controller
@RequestMapping(value = "/auth")
public class LoginController {

	protected static Logger logger = Logger.getLogger("LoginController");

	/**
	 * 指向登录页面
	 */
	@RequestMapping(value = "/login")
	public String getLoginPage(@RequestParam(value = "error", required = false) boolean error, ModelMap model) {
		logger.debug("Received request to show login page");
		if (error == true) {
			model.put("error", "账号或密码错误.");
		} else {
			model.put("error", "");
		}
		return "login";

	}

	/**
	 * 取消登录
	 */
	@RequestMapping(value = "/logout")
	public String getLogoutPage(@RequestParam(value = "error", required = false) boolean error, ModelMap model) {
		logger.debug("Received request to show login page");
		if (error == true) {
			model.put("error", "账号或密码错误.");
		} else {
			model.put("error", "");
		}
		return "login";
	}

	/**
	 * 指定无访问权限页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String getDeniedPage(ModelMap model) {
		logger.debug("Received request to show denied page");
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		model.put("loginName", name);
		return "denied";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("error", "Hi " + user.getName() + ", 你的权限不够!");
		} else {
			model.addObject("error", "你的权限不够!");
		}

		model.setViewName("error");
		return model;
	}

}
