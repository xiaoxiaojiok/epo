package com.gzgb.epo.dao.publicEmotion;

import java.util.List;
import java.util.Map;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.PublicEmotion;

/**
 * 
 * <pre>
 * 公众情感Dao
 * </pre>
 * @author LiuYongbin
 * @version 1.0, 2014-2-26
 */
public interface PublicEmotionDao extends BaseDao<PublicEmotion>{

	/**
	 * 
	 * <pre>
	 * 根据情感的类型获得map 数量
	 * </pre>
	 * @param type
	 * @return
	 */
	public List<PublicEmotion> getListByType(String type, String value);
}
