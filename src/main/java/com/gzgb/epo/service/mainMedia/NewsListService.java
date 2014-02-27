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

import com.gzgb.epo.dao.mainMedia.NewsListDao;
import com.gzgb.epo.entity.NewsList;
import com.gzgb.epo.entity.WeiBoList;
import com.gzgb.epo.service.base.BaseService;

/**
 * 
 * <pre>
 * 新闻舆情service
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2014-2-26
 */
@Service
@Transactional(readOnly = true)
public class NewsListService extends BaseService<NewsList> {
	

	private static Logger logger = LoggerFactory
			.getLogger(NewsListService.class);

	@Autowired
	private NewsListDao newsListMainDao;
	
	/**
	 * 
	 * <pre>
	 * 根据时间戳、境内外、新闻内容查询新闻
	 * </pre>
	 * 
	 * @param startTime
	 *            开始时间戳
	 * @param endTime
	 *            结束时间戳
	 * @param site
	 *            境内外
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
	public Map<String, Object> findNews(Integer startTime, Integer endTime,
			Integer site, String content, Integer page, Integer rows,
			String sort, String order) {
		logger.info("--findNews()方法");
		Map<String, Object> map = newsListMainDao.findNews(startTime,
				endTime, site, content, page, rows, sort, order);
		return map;
	}

	/**
	 * 
	 * <pre>
	 * 根据时间戳、境内外查询热度最高的20条新闻
	 * </pre>
	 * 
	 * @param startTime
	 *            开始时间戳
	 * @param endTime
	 *            结束时间戳
	 * @param site
	 *            境内外
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findNewsTop20(Integer startTime,
			Integer endTime, Integer site) {
		logger.info("--findNewsTop20()方法");
		Map<String, Object> map = findNews(startTime, endTime, site, null,
				null, null, null, null);
		List<Map<String, Object>> myMap = null;
		if (map != null && !"".equals(map.get("rows").toString())) {
			myMap = new ArrayList<Map<String, Object>>();
			List<NewsList> objList = (List<NewsList>) map.get("rows");
			if(objList!=null){
				int count = 20;
				if(objList.size()<20){
					count = objList.size();
				}
				for (int i = 0; i < count; i++) {
					NewsList newsList = objList.get(i);
					Map<String, Object> inMap = new HashMap<String, Object>(); 
					inMap.put("url", newsList.getMmnUrl());
					inMap.put("fullContent", newsList.getMmnContent());
					inMap.put("wsmId", newsList.getWsmId().getId());
					inMap.put("content", newsList.getMmnTitle());
					inMap.put("mmnReserved", newsList.getMmnReserved());
					SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd"); // 格式化日期
					inMap.put("ftorwarding", f.format(new Date(Long.parseLong(newsList.getMmnReservedTime().toString()) * 1000)));
					inMap.put("author", newsList.getMmnEditor());
					Long time = Long.parseLong(newsList.getMmnTimestamp().toString()) * 1000;
					 f = new SimpleDateFormat("yyyy-MM-dd  HH:mm"); // 格式化日期
					inMap.put("date", f.format(new Date(time)));
					myMap.add(inMap);
				}
			}
		}
		return myMap;
	}

}
