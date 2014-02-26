package com.gzgb.epo.dao.remakRecord;

import java.util.List;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.LeaderHistoryRecord;
import com.gzgb.epo.entity.RemarkRecord;

/**
 * 
 * <pre>
 * 言论记录Dao
 * </pre>
 * @author LiuYongbin
 * @version 1.0, 2014-2-25
 */
public interface RemarkRecordDao extends BaseDao<RemarkRecord>{

	/**
	 * 
	 * <pre>
	 * 根据社交账号获得记录
	 * </pre>
	 * @param socialAccount
	 * @return
	 */
	public  List<RemarkRecord> findBySocialAccount(String socialAccount);
}
