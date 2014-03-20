package com.gzgb.epo.dao.reportFocusDistribution;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gzgb.epo.dao.base.BaseDaoImpl;
import com.gzgb.epo.entity.DepartmentBaseInfo;
import com.gzgb.epo.entity.ReportDistribution;
import com.gzgb.epo.entity.ReportFocusDistribution;

/**
 * 
 * <pre>
 * 报道焦点区域 分布DaoImpl
 * </pre>
 * 
 * @author LiuYongbin
 * @version 1.0, 2014-2-26
 */
@Repository
public class ReportFocusDistributionDaoImpl extends BaseDaoImpl<ReportFocusDistribution>
		implements ReportFocusDistributionDao {

	/**
	 * 
	 * <pre>
	 *查找从指定月以来的记录
	 * </pre>
	 * 
	 * @param startTime
	 * @param isAbout 是否涉穂
	 * @param map   对属性名加以限制
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ReportFocusDistribution> getListAfterTime(Integer startTime, Map<String, Long> map, Integer isAbout)
			throws QueryException {
		try {
			Criteria criteria = getSession().createCriteria(ReportDistribution.class);
			
			if(map != null && !map.isEmpty()){
				for(String key : map.keySet()){
					criteria.add(Restrictions.eq(key, map.get(key)));
				}
			}
			if(isAbout != null)
				criteria.add(Restrictions.eq("isAbout", isAbout));
			criteria.add(Restrictions.gt("time", startTime));
			List<ReportFocusDistribution> list = criteria.list();
			if (list.size() == 0 || list == null) {
				return null;
			}
			return list;
		} catch (QueryException qe) {
			throw qe;
		}
	}
	
	
	   /**
		 * 
		 * <pre>
		 * 根据cityRegionId和开始时间查找前number个关键字
		 * </pre>
		 * @param month 月份
		 * @param cityRegionId 地区的Id
		 * @param isAbout 是否涉穂
		 * 
		 * @return
		 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTopNumberFocusName(Integer startTime, Long cityRegionId, Integer isAbout, Integer number)throws QueryException {
		try {
			List<String> returnList = new ArrayList<String>();
			String sql = "select name,sum(weigth) total from epo_reportfocusdistribution where time > ? and isabout = ? and cityregionId = ? group by name order by total desc limit 0,?;";
			Query query = getSession().createSQLQuery(sql);
			query.setParameter(0, startTime);
			query.setParameter(1, isAbout);
			query.setParameter(2, cityRegionId);
			query.setParameter(3, number);
			List list = query.list();
			for(Iterator iterator = list.iterator();iterator.hasNext();){ 
	            Object[] objects = (Object[]) iterator.next(); 
	            String name  = ((String) objects[0]);
	            returnList.add(name);
		    } 
			return returnList;
		} catch (QueryException qe) {
			throw qe;
		}
	}
	
	/**
	 * 
	 * <pre>
	 *根据cityRegionId和开始时间,情感倾向/政治倾向类型，关注焦点的名字查找对应的List<正面/右倾的数量， 中立的数量， 负面/左倾的数量>
	 * </pre>
	 * @param cityRegionId 地区的Id
	 * @param type 情感/政治类型
	 * @param startTime 开始时间
	 * @param name 关注焦点名称
	 * @param isAbout 是否涉穂
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ReportFocusDistribution> findSpecialList(Integer startTime, Long cityRegionId, Integer isAbout, String name)throws QueryException {
		try {
			Criteria criteria = getSession().createCriteria(ReportFocusDistribution.class);
			criteria.add(Restrictions.eq("cityRegionId.id",cityRegionId));
			if(isAbout != null)
				criteria.add(Restrictions.eq("isAbout", isAbout));
			criteria.add(Restrictions.gt("time", startTime));
			criteria.add(Restrictions.eq("name", name));
			List<ReportFocusDistribution> list = criteria.list();
			return list;
		} catch (QueryException qe) {
			throw qe;
		}
	}
	
	
}
