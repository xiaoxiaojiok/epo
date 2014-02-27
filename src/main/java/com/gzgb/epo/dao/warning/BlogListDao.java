package com.gzgb.epo.dao.warning;

import java.util.Map;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.BlogList;

/**
 * 
 * <pre>
 * 博客舆情DAO
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2014-2-25
 */
public interface BlogListDao extends BaseDao<BlogList> {
	

	/**
	 * 
	 * <pre>
	 * 根据时间戳、博客站点、博客内容查询博客 
	 * </pre>
	 * 
	 * @param startTime
	 *            开始时间戳
	 * @param endTime
	 *            结束时间戳
	 * @param site
	 *            博客站点
	 * @param content
	 *            博客内容
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
	public Map<String, Object> findBlog(Integer startTime, Integer endTime,
			Integer site, String content, Integer page, Integer rows,
			String sort, String order);

}
