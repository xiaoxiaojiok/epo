package com.gzgb.epo.service.mainMedia;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.mainMedia.TopicListDao;
import com.gzgb.epo.entity.Topic;
import com.gzgb.epo.service.base.BaseService;

/**
 * 
 * <pre>
 * 热点话题service
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2014-2-27
 */
@Service
@Transactional(readOnly = true)
public class TopicListService extends BaseService<Topic> {
	

	private static Logger logger = LoggerFactory
			.getLogger(TopicListService.class);

	@Autowired
	private TopicListDao topicListDao;
	
	/**
	 * 
	 * <pre>
	 * 根据时间戳、父子话题、话题内容查询话题
	 * </pre>
	 * 
	 * @param startTime
	 *            开始时间戳
	 * @param endTime
	 *            结束时间戳
	 * @param site
	 *            父子话题
	 * @param content
	 *            内容
	 * @param page
	 *            当前第几页
	 * @param rows
	 *            每页显示数目
	 * @param sort
	 *            按某字段排序
	 * @param order
	 *            升/降序
	 * @return
	 */
	public Map<String, Object> findTopic(String startTime, String endTime,
			Integer site, String content, Integer page, Integer rows,
			String sort, String order) {
		logger.info("--findTopic()方法");
		Map<String, Object> map = topicListDao.findTopic(startTime,
				endTime, site, content, page, rows, sort, order);
		return map;
	}

	/**
	 * 
	 * <pre>
	 * 根据时间戳、父子话题查询热度最高的20条话题
	 * </pre>
	 * 
	 * @param startTime
	 *            开始时间戳
	 * @param endTime
	 *            结束时间戳
	 * @param site
	 *            父子话题
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findTopicTop20(String startTime,
			String endTime, Integer site) {
		logger.info("--findTopicTop20()方法");
		Map<String, Object> map = findTopic(startTime, endTime, site, null,
				null, null, null, null);
		List<Map<String, Object>> myMap = null;
		if (map != null && !"".equals(map.get("rows").toString())) {
			myMap = new ArrayList<Map<String, Object>>();
			List<Topic> objList = (List<Topic>) map.get("rows");
			if(objList!=null){
				int count = 20;
				if(objList.size()<20){
					count = objList.size();
				}
				for (int i = 0; i < count; i++) {
					Topic topic = objList.get(i);
					Map<String, Object> inMap = new HashMap<String, Object>(); 
					inMap.put("url", "");
					inMap.put("fullContent", topic.getTitle());
					inMap.put("wsmId", "");
					inMap.put("content", topic.getTitle());
					inMap.put("mmnReserved", topic.getComments());
					inMap.put("ftorwarding", topic.getReports());
					inMap.put("author", topic.getKeywords());
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd  HH:mm"); // 格式化日期
					inMap.put("date", f.format(topic.getCreateDate()));
					myMap.add(inMap);
				}
			}
		}
		return myMap;
	}

}
