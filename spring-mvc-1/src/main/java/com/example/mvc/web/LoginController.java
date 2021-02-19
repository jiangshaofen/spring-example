package com.example.mvc.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mvc.domain.User;
import com.example.mvc.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

	/**
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/loginCheck")
	public ModelAndView loginCheck(Model model, User user) {
		boolean hasMatchUser = userService.hasMatchUser(user.getUserName(), user.getPassWord());

		if (hasMatchUser) {
			User user2 = userService.findUserByUserName(user.getUserName());
			user2.setLastVisit(new Date());
			userService.loginSuccess(user2);

			model.addAttribute("user", user2);
			return new ModelAndView("main");

		} else {
			return new ModelAndView("login", "error", "用户名或密码错误.");
		}
	}
}
