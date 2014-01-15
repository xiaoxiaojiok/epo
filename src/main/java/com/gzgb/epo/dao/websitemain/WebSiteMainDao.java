package com.gzgb.epo.dao.websitemain;

import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.WebSiteMain;

/**
 * 
 * <pre>
 * 站点管理DAO
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
public interface WebSiteMainDao extends BaseDao<WebSiteMain> {

	/**
	 * 
	 * <pre>
	 * 检查站点名称是否存在
	 * </pre>
	 * 
	 * @param wsmName
	 * @return
	 */
	public boolean checkWsmNameIsExits(String wsmName);

	/**
	 * 
	 * <pre>
	 * 检查网路地址是否存在
	 * </pre>
	 * 
	 * @param wsmHome
	 * @return
	 */
	public boolean checkWsmHomeIsExits(String wsmHome);
	
	/**
	 * 根据站点名称查找站点（控制唯一）
	 * 
	 * @param wsmName
	 * @return
	 */
	@Transactional(readOnly = true)
	public WebSiteMain findWebSiteMainByWsmName(String wsmName) ;

}
