package com.gzgb.epo.controller.mainMedia;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzgb.epo.entity.Topic;
import com.gzgb.epo.service.mainMedia.TopicListService;
import com.gzgb.epo.util.DateUtil;

/**
 * 
 * <pre>
 * 热点话题控制器
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-2-27
 */
@Controller
@RequestMapping(value = "/topic")
public class TopicController {
	
	@Autowired
	private TopicListService topicListService;
	Logger logger = LoggerFactory.getLogger(TopicController.class);
	
	@RequestMapping(value = "monitorTopic")
	public String monitorTopic(Model model, HttpServletRequest request) {

		return "mainMedia/monitorTopic";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "topicSearch")
	public @ResponseBody
	Map<String, Object> topicSearch(HttpServletRequest request, String content,
			String start, String end, Integer sortOrder, Integer wsmId,
			Integer page) {
		if (page == null || page == 0) {
			page = 1;
		}

		Map<String, Object> myMap = null;
		if (sortOrder == 0) {
			// 按时间 升序排序
			myMap = topicListService.findTopic(start, end, wsmId,
					content, page, null, "mmnTimestamp", "asc");
		} else {
			// 默认按转载量降序排列
			myMap = topicListService.findTopic(start, end, wsmId,
					content, page, null, null, null);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		if (myMap != null && !"".equals(myMap.get("rows").toString())) {
			List<Topic> list = (List<Topic>) myMap.get("rows");
			for (int i = 0; i < list.size(); i++) {
				Topic topic = list.get(i);
				Map<String, Object> inMap = new HashMap<String, Object>();
				inMap.put("url", "");
				inMap.put("fullContent", topic.getTitle());
				inMap.put("source", "");
				inMap.put("title", topic.getTitle());
				inMap.put("mmnReserved", topic.getComments());
				inMap.put("mmnReservedTime", topic.getReports());
				inMap.put("ftorwarding", topic.getKeywords());
				inMap.put("fullAuthor", "");
				inMap.put("mmnIsAbroad", "0");
				
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // 格式化日期
				inMap.put("date", f.format(topic.getCreateDate()));
				inMap.put("updateUrl", topic.getId());

				dataList.add(inMap);
			}
		}
		Map<String, Object> pageList = new HashMap<String, Object>();
		int total = (myMap == null) ? 0 : Integer.parseInt(myMap.get("total")
				.toString());
		pageList.put("size", 20); // 默认为20
		int size = 1;
		if (total > 20) {
			if (total % 20 != 0) {
				size = total / 20 + 1;
			} else {
				size = total / 20;
			}
		}
		pageList.put("count", size);
		pageList.put("current", page);
		pageList.put("total", total);

		map.put("data", dataList);
		map.put("page", pageList);
		return map;
	}

	@RequestMapping(value = "topicIndex")
	public @ResponseBody
	List<Map<String, Object>> topicIndex(HttpServletRequest request,
			Integer day, Integer site) {
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (day != null) {
			Long a = DateUtil.parseSimpleDate("2013-11-28").getTime() / 1000;
			// Long a = new Date().getTime()/1000;
			Long b = a - day * 3600 * 24;
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 格式化日期
			String startTime =  f.format(new Date(b*1000));
			String endTime = f.format(new Date(a*1000));
			dataList = topicListService
					.findTopicTop20(startTime, endTime, site);
		}
		return dataList;
	}

}
