package com.gzgb.epo.dao.mainMedia;

import java.util.Map;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.CommentList;

/**
 * 
 * <pre>
 * 评论舆情DAO
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2014-2-26
 */
public interface CommentListDao extends BaseDao<CommentList>{
	

	/**
	 * 
	 * <pre>
	 * 根据时间戳、境内外、评论内容查询评论
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
	public Map<String, Object> findComment(Integer startTime, Integer endTime,
			Integer site, String content, Integer page, Integer rows,
			String sort, String order);

}
