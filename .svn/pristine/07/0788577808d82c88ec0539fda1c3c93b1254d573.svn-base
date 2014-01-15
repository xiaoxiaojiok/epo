package com.gzgb.epo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gzgb.epo.entity.User;
import com.gzgb.epo.service.user.UserService;
import com.gzgb.epo.util.Encrypt;

/**
 * 
 * <pre>
 * 系统主页入口
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

	@Autowired
	private UserService userService;
	Logger logger = LoggerFactory.getLogger(IndexController.class);

	/**
	 * 进入首页
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index(Model model,HttpServletRequest request,String loginName,String password){
		if(loginName!=null&&password!=null){
			Map<String,String> map = new HashMap<String,String>();
			map.put("loginName", loginName);
			map.put("password",Encrypt.MD5(password));
			List<User> list = userService.getAll(User.class, map);
			User user= null;
			if(list!=null && list.size() > 0){
				user = list.get(0);
			}
			if(user!=null){
				user.setLoginCount(user.getLoginCount()+1);
				user.setLastLoginIP(request.getRemoteAddr());
				Long time = new Date().getTime();
				time = time / 1000;  //java中的毫秒转换成数据库中的秒数
				user.setLastLoginTime(time.intValue());
				try{
					userService.save(user);
				}catch(Exception e){
					e.printStackTrace();
				}
				request.getSession().setAttribute("loginName", loginName);
				request.getSession().setAttribute("userId", user.getId());
				request.getSession().setAttribute("userType", user.getUserType());
				
				return "mainMedia/mainMediaIndex";
			}else{
				return "redirect:/login";
			}
		}
		return "login";
	}
	
	/**
	 * 欢迎页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "welcome")
	public String welcome(HttpServletRequest request,Model model) {

		return "welcome";
	}

}
