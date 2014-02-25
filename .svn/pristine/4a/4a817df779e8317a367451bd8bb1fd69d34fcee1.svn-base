package com.gzgb.epo.dao.warning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gzgb.epo.dao.base.BaseDaoImpl;
import com.gzgb.epo.entity.WeiBoList;

/**
 * 
 * <pre>
 * 微博舆情DAO实现类
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2014-2-25
 */

@Repository
public class WeiBoListDaoImpl extends BaseDaoImpl<WeiBoList> implements
		WeiBoListDao {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findWeiBo(Integer startTime, Integer endTime,
			Integer site, String content, Integer page, Integer rows, String sort, String order) {
		Criteria c = getSession().createCriteria(WeiBoList.class);
		c.add(Restrictions.between("wwlTimestamp", startTime, endTime));
		if(site!=null){
			if(site==18){
				c.add(Restrictions.like("wwlUrl", "http://weibo.cn/"));
			}else{
				c.add(Restrictions.like("wwlUrl", "http://t.qq.com/"));
			}
		}
		if(content!=null){
			c.add(Restrictions.like("wwlContent", content));
		}
		
		List<WeiBoList> list = c.list();
		int total = 0;
		if (list != null) {
			total = list.size();
		}
		if (page == null || page == 0) {
			page = 1;
		}
		if (rows == null || rows == 0) {
			rows = 20;
		}
		if (sort != null && order != null) {
			if ("asc".equals(order)) {
				c.addOrder(Order.asc(sort));
			} else {
				c.addOrder(Order.desc(sort));
			}
		} else {
			// 默认按照热度降序排序
			c.addOrder(Order.desc("wwlHots"));
		}
		List<WeiBoList> objList = c.setFirstResult((page - 1) * rows)
				.setMaxResults(rows).list();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		if (objList != null && objList.size() > 0) {
			returnMap.put("total", total);
			returnMap.put("rows", objList);
			return returnMap;
		} else {
			returnMap.put("total", total);
			returnMap.put("rows", "");
			return returnMap;
		}
		
	}

}
