package com.gzgb.epo.dao.permission;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.Permission;

/**
 * 
 * <pre>
 * 权限管理DAO
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-15
 */
public interface PermissionDao extends BaseDao<Permission> {

	/**
	 * 
	 * <pre>
	 * 根据id字符串批量删除权限
	 * </pre>
	 * @param ids
	 */
	void deleteByIds(String ids);
	
	/**
	 * 
	 * <pre>
	 * 根据菜单id得到权限
	 * </pre>
	 * @param menuId
	 * @return
	 */
	List<Permission> getPermissionsByMenuId(Long menuId);
	
	/**
	 * <pre>
	 * 根据菜单ID和角色ID查询权限
	 * </pre>
	 * @param menuId
	 * @param roleId
	 * @return
	 */
	List<Permission> getPermissionsByMenuIdAndRoleId(Long menuId,Long roleId);
	
	/**
	 * <pre>
	 * 根据角色集合查询菜单权限
	 * </pre>
	 * @param roleids
	 * @return
	 */
	List<Permission> getPermissionByRoles(String roleids);
	
	/**
	 * 
	 * <pre>
	 * 根据权限id集合得到权限集合
	 * </pre>
	 * @param permIds
	 * @return
	 */
	List<Permission> getPermissionByPermIds(String permIds);
	
	/**
	 * 
	 * <pre>
	 * 根据菜单名称，获取相关的所属权限集合
	 * </pre>
	 * @param menuName
	 * @return
	 */
	public Page<Permission> queryByMenuName(String menuName,Pageable pageable);
	
	/**
	 * 
	 * <pre>
	 * 判读某个用户是否有某个权限
	 * </pre>
	 * @param user_id
	 * @param perm_value
	 * @return
	 */
	public boolean ifUserHasPermission(Long user_id, String perm_value);
	
	/**
	 * <pre>
	 * 根据角色集合查询菜单权限
	 * </pre>
	 * @param roleids
	 * @return
	 */
	List<Permission> getPermissionByRoleId(Long roleId);
	
	/**
	 * 
	 * <pre>
	 * 根据权限值得到权限信息集合
	 * </pre>
	 * @param permValue
	 * @return
	 */
	List<Permission> getPermByPvalue(String permValue);
}
