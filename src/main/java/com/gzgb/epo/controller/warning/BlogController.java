package com.gzgb.epo.controller.warning;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzgb.epo.service.warning.BlogListService;

/**
 * 
 * <pre>
 * 博客控制器
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2014-2-25
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {
	
	@Autowired
	private BlogListService blogListService;
	Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@RequestMapping(value = "blogTop20")
	public @ResponseBody String blogTop20(Model model,HttpServletRequest request){
		
		
			return "";
	}

}
