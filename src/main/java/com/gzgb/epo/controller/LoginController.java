package com.gzgb.epo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * <pre>
 * 登陆处理
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-31
 */
@Controller
@RequestMapping("/")
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginfail(HttpServletRequest request, Model model) {
		model.addAttribute("errorInfo", "用户名或密码错误");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) {
		model.addAttribute("errorInfo", "用户名或密码错误");
		return "login";
	}

	/**
	 * 退出
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws IllegalAccessException
	 */
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request, Model model)
			throws IllegalAccessException {
		request.getSession().invalidate(); // 销毁session
		return "login";
	}

}
