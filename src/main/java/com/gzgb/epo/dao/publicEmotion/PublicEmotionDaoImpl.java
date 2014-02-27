package com.gzgb.epo.dao.publicEmotion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gzgb.epo.dao.base.BaseDaoImpl;
import com.gzgb.epo.entity.MessageCountChange;
import com.gzgb.epo.entity.PublicEmotion;

/**
 * 
 * <pre>
 * 公众情感DaoImpl
 * </pre>
 * @author LiuYongbin
 * @version 1.0, 2014-2-26
 */
@Repository
public class PublicEmotionDaoImpl extends BaseDaoImpl<PublicEmotion> implements PublicEmotionDao {
	
	/**
	 * 
	 * <pre>
	 * 根据情感类型获得map 数量
	 * </pre>
	 * 
	 * @param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PublicEmotion> getListByType(String type, String value) throws QueryException{
		try {
			Criteria criteria = getSession().createCriteria(PublicEmotion.class);
			criteria.add(Restrictions.eq(type, value));
			criteria.addOrder(Order.asc("time"));
			List<PublicEmotion> list = criteria.list();
			if(list.size() == 0){
				return null;
			}	
			return list;	
		} catch (QueryException qe) {
			throw qe;
		}
	}
}
