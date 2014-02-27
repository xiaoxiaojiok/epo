package com.gzgb.epo.service.publicEmotion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzgb.epo.dao.publicEmotion.PublicEmotionDao;
import com.gzgb.epo.entity.PublicEmotion;
import com.gzgb.epo.service.base.BaseService;
import com.gzgb.epo.service.knowledgeDictItem.KnowledgeDictItemService;

/**
 * 
 * <pre>
 * 公众情感Service
 * </pre>
 * @author LiuYongbin
 * @version 1.0, 2014-2-26
 */
@Service
public class PublicEmotionService extends BaseService<PublicEmotion>{
 
	private static Logger logger = LoggerFactory.getLogger(PublicEmotionService.class);
	@Autowired
	private PublicEmotionDao peDao;
	/**
	 * 
	 * <pre>
	 * 根据情感类型获得总数
	 * </pre>
	 * 
	 * @param
	 * @return
	 */
	public long getCountByType(String type, String value) throws QueryException{
		try {
			logger.info("---getCountByType()方法");
			Map<String, String> map = new HashMap<String, String>();
			map.put(type, value);
			List<PublicEmotion> list = peDao.getAll(PublicEmotion.class, map);
			long total = 0;
			if(list.size() == 0){
				return 0;
			}	
			else{
				for(PublicEmotion pe : list){
					total+=pe.getCount();
				}
			}
			return total;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return 0;
		}
		
	}
	/**
	 * 
	 * <pre>
	 * 根据类型获得按时间排序的 数量
	 * </pre>
	 * 
	 * @param
	 * @return
	 */
	public Map<String, Long> getMapTimeByType(String type, String value) throws QueryException{
		try {
			logger.info("---getMapByType()方法");
			Map<String, Long> map = new HashMap<String, Long>();
			List<PublicEmotion> list = peDao.getListByType(type, value);
			if(list.size() == 0){
				return null;
			}	
			else{
				for(PublicEmotion pe : list){
					map.put(pe.getTime(), pe.getCount());
				}
			}
			return map;	
		} catch (Exception ex) {
			logger.error(ex.toString());
			return null;
		}
			
	}
	
	/**
	 * 
	 * <pre>
	 * 根据类型获得map数量（按情感分类）
	 * </pre>
	 * 
	 * @param
	 * @return
	 */
	public Map<String, Long> getMapByType(String type, String value) throws QueryException{
		try {
			logger.info("---getMapByType()方法");
			List<PublicEmotion> list = peDao.getListByType(type, value);
			Map<String, Long> targetMap = new HashMap<String, Long>();
			if(list.size() == 0){
				return null;
			}	
			else{
				long neutral = 0;
				long positive = 0;
				long negative = 0;
				for(PublicEmotion pe : list){
					if("正面".equals(pe.getEmotion()))
						positive+=pe.getCount();
					else if("负面".equals(pe.getEmotion()))
						negative+=pe.getCount();
					else
						neutral+=pe.getCount();
				}
				targetMap.put("正面", positive);
				targetMap.put("负面", negative);
				targetMap.put("中立", neutral);
			}
			return targetMap;	
		} catch (Exception ex) {
			logger.error(ex.toString());
			return null;
		}
		
		
	}
}
