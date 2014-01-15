package com.gzgb.epo.dao.knowledgeDictItem;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.QueryException;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.KnowledgeDictItem;
import com.gzgb.epo.entity.KnowledgeDictLib;
/**
 * 
 * <pre>
 * 词条管理DAO
 * </pre>
 * @author LiuYongbin
 * @version 1.0, 2014-1-2
 */
public interface KnowledgeDictItemDao extends BaseDao<KnowledgeDictItem>{
	
/**
*
* <pre>
* 获得本月新增词条
* </pre>
* @param 
* @return 
*/
public int getNewCountsOfThisMonth();

/**
*
* <pre>
* 获得本年新增词条
* </pre>
* @param 
* @return 
*/
public int getNewCountsOfThisYear();

/**
*
* <pre>
* 获得词条总数
* </pre>
* @param 
* @return 
*/
public long getCountOfAll();

/**
*
* <pre>
* 获得最新的10条词条
* </pre>
* @param 
* @return 
*/
public List<KnowledgeDictItem> getNewItem();


/**
*
* <pre>
*根据所属词库、词性、以及模糊查询
* </pre>
* @param 
* @return 
*/
public Map<String, Object> searchItem(Long parentId, Long kdqId, String fuzzy,Integer page, Integer rows,
		String sort, String order);

/**
 * 
 * <pre>
 * 根据词条的名字查找词条
 * </pre>
 * 
 * @param
 * @return
 */
public KnowledgeDictItem findByName(String kdlName);


}
