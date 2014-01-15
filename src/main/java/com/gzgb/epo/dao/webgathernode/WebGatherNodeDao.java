package com.gzgb.epo.dao.webgathernode;

import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.WebGatherNode;

/**
 * 
 * <pre>
 * 采集点管理DAO
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
public interface WebGatherNodeDao extends BaseDao<WebGatherNode> {

	/**
	 * 
	 * <pre>
	 * 检查采集点名称是否存在
	 * </pre>
	 * 
	 * @param wgnName
	 * @return
	 */
	public boolean checkWgnNameIsExits(String wgnName);

	/**
	 * 根据采集点名称查找采集点（控制唯一）
	 * 
	 * @param wgnName
	 * @return
	 */
	@Transactional(readOnly = true)
	public WebGatherNode findWebGatherNodeByWgnName(String wgnName);
	
	/**
	 * 
	 * <pre>
	 * 检查采集点标记是否存在
	 * </pre>
	 * 
	 * @param wgnUniqueId
	 * @return
	 */
	public boolean checkWgnUniqueIdIsExits(String wgnUniqueId);

	/**
	 * 根据采集点标记查找采集点（控制唯一）
	 * 
	 * @param wgnUniqueId
	 * @return
	 */
	@Transactional(readOnly = true)
	public WebGatherNode findWebGatherNodeByWgnUniqueId(String wgnUniqueId);

}
