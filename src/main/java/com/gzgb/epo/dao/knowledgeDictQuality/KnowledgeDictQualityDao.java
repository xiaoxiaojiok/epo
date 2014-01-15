package com.gzgb.epo.dao.knowledgeDictQuality;
import java.util.Collection;
import java.util.List;

import org.hibernate.QueryException;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.KnowledgeDictQuality;
/**
 * 
 * <pre>
 * 部门DAO
 * </pre>
 * @author LiuYongbin
 * @version 1.0, 2014-1-2
 */
	
public interface KnowledgeDictQualityDao extends BaseDao<KnowledgeDictQuality>{
	/**
	*
	* <pre>
	* findByName
	* </pre>
	* @param 
	* @return 
	*/
	public KnowledgeDictQuality findByName(String name);

}
