package com.gzgb.epo.controller.warning;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.gzgb.epo.entity.WebSiteMain;
import com.gzgb.epo.service.user.UserService;
import com.gzgb.epo.service.warning.BlogListService;

/**
 * 
 * <pre>
 * 舆情预警控制器
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Controller
@RequestMapping(value = "/warning")
public class WarningController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogListService blogListService;
	
	Logger logger = LoggerFactory.getLogger(WarningController.class);

	/**
	 * 进入舆情预警页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index(Model model, HttpServletRequest request) {
		return "warning/warningIndex";
	}

	/**
	 * 进入热点涉穗微博页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "warningHotWeibo")
	public String warningHotWeibo(Model model, HttpServletRequest request) {

		Long endTime = new Date().getTime() / 1000;
		Long startTime = endTime - 30 * 3600 * 24;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd"); // 格式化日期
		model.addAttribute("endTime", f.format(new Date(endTime*1000)));
		model.addAttribute("startTime", f.format(new Date(startTime*1000)));
		return "warning/warningHotWeibo";
	}

	/**
	 * 进入热点涉穗帖子页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "warningHotPost")
	public String warningHotPost(Model model, HttpServletRequest request) {
		return "warning/warningHotPost";
	}
	
	/**
	 * 进入热点涉穗博客页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "warningHotBlog")
	public String warningHotBlog(Model model, HttpServletRequest request) {

		Long endTime = new Date().getTime() / 1000;
		Long startTime = endTime - 30 * 3600 * 24;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd"); // 格式化日期
		model.addAttribute("endTime", f.format(new Date(endTime*1000)));
		model.addAttribute("startTime", f.format(new Date(startTime*1000)));
		
		List<Map<String,Object>> webSiteNameList= blogListService.findWsmId();
		model.addAttribute("webSiteNameList", webSiteNameList);
		return "warning/warningHotBlog";
	}

	/**
	 * 进入部门关注度页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "warningDepartment")
	public String warningDepartment(Model model, HttpServletRequest request) {
		return "warning/warningDepartment";
	}

	/**
	 * 进入敏感舆情页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "warningSensitive")
	public String warningSensitive(Model model, HttpServletRequest request) {
		return "warning/warningSensitive";
	}

	/**
	 * 进入实时预警舆情页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "warningNow")
	public String warningNow(Model model, HttpServletRequest request) {
		return "warning/warningNow";
	}

}
