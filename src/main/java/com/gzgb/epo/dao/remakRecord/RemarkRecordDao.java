package com.gzgb.epo.dao.remakRecord;

import java.util.List;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.RemarkRecord;

/**
 * 
 * <pre>
 * 言论记录Dao
 * </pre>
 * 
 * @author LiuYongbin
 * @version 1.0, 2014-2-25
 */
public interface RemarkRecordDao extends BaseDao<RemarkRecord> {

	/**
	 * 
	 * <pre>
	 * 根据社交账号获得记录
	 * </pre>
	 * 
	 * @param socialAccount
	 * @return
	 */
	public List<RemarkRecord> findByNetWorkId(Long id);
	
	/**
	 * 
	 * <pre>
	 *查找在特定月里面的不同的类型的数量list<正面的数量，中立的数量，负面的数量>
	 * </pre>
	 * 
	 * @param startAndEnd
	 * @return
	 */
	public List<RemarkRecord> getListBetweenTime(List<Integer> startAndEnd, Long networkId);
}
