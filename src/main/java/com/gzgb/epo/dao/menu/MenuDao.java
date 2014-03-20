package com.gzgb.epo.dao.menu;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.Menu;


/**
 * 
 * <pre>
 * 菜单管理DAO
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-15
 */
public interface MenuDao extends BaseDao<Menu> {
	
	/**
	 *  获取当前级别菜单
	 *  
	 * @param menuLevel
	 * @return
	 */
	Collection<Menu> getMenuListByLevel(int menuLevel);
	
	/**
	 *  根据当前菜单获取其下一级别子菜单
	 * 
	 * @param pid
	 * @return
	 */
	Page<Menu> getSubMenuListByPMenu(Long pid,Pageable pageable);
	
	/**
	 * 获取当前菜单下一级别数量
	 * 
	 * @param currMenuId
	 * @return
	 */
	Integer nextLevelCount(Long currMenuId);
	
	/**
	 * 根据菜单名字查询
	 * 
	 * @param menuName
	 * @return
	 */
	Menu findByMenuName(String menuName);

}
