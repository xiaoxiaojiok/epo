package com.gzgb.epo.dao.reportFocusDistribution;

import java.util.List;
import java.util.Map;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.PublicEmotion;
import com.gzgb.epo.entity.ReportDistribution;
import com.gzgb.epo.entity.ReportFocusDistribution;

/**
 * 
 * <pre>
 * 报道焦点区域分布Dao
 * </pre>
 * 
 * @author LiuYongbin
 * @version 1.0, 2014-2-26
 */
public interface ReportFocusDistributionDao extends BaseDao<ReportFocusDistribution> {

	
	/**
	 * 
	 * <pre>
	 *查找从指定月以来的记录
	 * </pre>
	 * 
	 * @param startTime   开始时间
	 * @param isAbout 是否涉穂
	 * @param map   对属性名加以限制
	 * @return
	 */
    public List<ReportFocusDistribution> getListAfterTime(Integer startTime, Map<String, Long> map, Integer isAbout);
    
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
   public List<String> getTopNumberFocusName(Integer startTime, Long cityRegionId, Integer isAbout, Integer number);
   
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
     public List<ReportFocusDistribution> findSpecialList(Integer startTime, Long cityRegionId, Integer isAbout, String name);
     
     
}
