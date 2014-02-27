package com.gzgb.epo.controller.warning;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzgb.epo.service.warning.ForumListService;
import com.gzgb.epo.util.DateUtil;


/**
 * 
 * <pre>
 * 论坛帖子控制器
 * </pre>
 * 
 * @author JiangRundong
 * @version 1.0, 2013-2-25
 */
@Controller
@RequestMapping(value = "/forum")
public class ForumController {
	
	@Autowired
	private ForumListService forumListService;
	Logger logger = LoggerFactory.getLogger(ForumController.class);
	
	@RequestMapping(value = "forumTop20")
	public @ResponseBody String forumTop20(Model model,HttpServletRequest request){
		
		
			return "warning/warningHotForum";
	}
	
	@RequestMapping(value = "forumIndex")
	public @ResponseBody
	List<Map<String, Object>> forumIndex(HttpServletRequest request,
			Integer day, Integer site) {
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (day != null) {
			Long a = DateUtil.parseSimpleDate("2013-4-8").getTime() / 1000;
			// Long a = new Date().getTime()/1000;
			Long b = a - day * 3600 * 24;
			int startTime = b.intValue();
			int endTime = a.intValue();
			dataList = forumListService
					.findForumTop20(startTime, endTime, site);
		}
		return dataList;
	}


}
