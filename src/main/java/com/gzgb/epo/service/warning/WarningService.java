package com.gzgb.epo.service.warning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * <pre>
 * 舆情预警实体类
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-4
 */
@Service
@Transactional(readOnly = true)
public class WarningService {
	
	private static Logger logger = LoggerFactory
	.getLogger(WarningService.class);
	
	@Autowired
	private BlogListService blogListService;
	
	@Autowired
	private ForumListService forumListService;
	
	@Autowired
	private WeiBoListService weiboListService;
	
	/**
	 * 
	 * <pre>
	 * 查找实时舆情
	 * </pre>
	 * @param number
	 * @return
	 */
	public Map<String,Object> findSensitive(Integer number){
		List<Map<String, Object>> blogList = blogListService.findSensitive(number);
		List<Map<String, Object>> forumList = forumListService.findSensitive(number);
		List<Map<String, Object>> weiboList = weiboListService.findSensitive(number);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.addAll(blogList);
		list.addAll(forumList);
		list.addAll(weiboList);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("data", list);
		
		return map;
		
	}
	
	

}
