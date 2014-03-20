package com.gzgb.epo.service.permission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.permission.PermissionDao;
import com.gzgb.epo.entity.Permission;
import com.gzgb.epo.entity.Role;
import com.gzgb.epo.service.base.BaseService;

/**
 * 
 * <pre>
 * 菜单管理service
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-3-15
 */
@Service
@Transactional(readOnly = true)
public class PermissionService extends BaseService<Permission>
{
	@Autowired
	private PermissionDao permissionDao;
	Logger log = LoggerFactory.getLogger(PermissionService.class);
	
	/**
	 * <pre>
	 * 根据菜单名查找权限(分页)
	 * </pre>
	 * @param menuName 菜单名
	 * @param pageable 分页组件
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page<Permission> findByAll(final String menuName,Pageable pageable)
	{
		if(StringUtils.isEmpty(menuName))
		{
			 List<Permission> perlist = (List<Permission>) this.permissionDao.findAll(Permission.class);
			 Object t = perlist.size();
			return new PageImpl(perlist, pageable, t!=null?Long.parseLong(t.toString()):0);
		}
		else
		{
			return this.permissionDao.queryByMenuName(menuName, pageable);
		}
	}
	
	/**
	 * <pre>
	 * 保存权限
	 * </pre>
	 * @param permission
	 */
	@Transactional(readOnly = false)
	public void save(Permission permission)
	{
		if(permission.getId()==null || permission.getId()==0){
			permissionDao.save(permission);
		}else{
			permissionDao.update(permission);
		}
	}
	
	/**
	 * <pre>
	 * 批量删除
	 * </pre>
	 * @param ids
	 */
	@Transactional(readOnly = false)
	public void deleteByIds(String ids)
	{
		permissionDao.deleteByIds(ids);
	}
	
	/**
	 * <pre>
	 * 根据菜单id查找该菜单的权限集
	 * </pre>
	 * @param menuId
	 * @return
	 */
	public List<Permission> getPermissionsByMenuId(Long menuId)
	{
		return permissionDao.getPermissionsByMenuId(menuId);
	}
	
	/**
	 * 
	 * <pre>
	 * 根据上级菜单，在权限集合里面循环遍历得到菜单下属权限
	 * </pre>
	 * @param menuId
	 * @param permlist
	 * @return
	 */
	public List<Permission> getPermissionsByMenuAndPermLists(Long menuId,List<Permission> permlist){
		List<Permission> relist = new ArrayList<Permission>();
		for(Permission p:permlist){
			if(p.getMenu().getId().equals(menuId)){
				relist.add(p);
			}
		}
		return relist;
	}
	
	/**
	 * <pre>
	 *  根据菜单ID和角色ID查找权限集
	 * </pre>
	 * @param menuId
	 * @param roleId
	 * @return
	 */
	public List<Permission> getPermissionByMenuIdAndRoleId(Long menuId,Long roleId)
	{
		return permissionDao.getPermissionsByMenuIdAndRoleId(menuId, roleId);
	}
	/**
	 * <pre>
	 * 根据权限ID集合查找权限集
	 * </pre>
	 * @param permList
	 * @return
	 */
	public List<Permission> getPermissionByPermIds(Collection<Permission> permList)
	{
		String permIds = "";
		for(Permission per:permList){
			permIds +=per.getId()+",";
		}
		if(permIds.length()>=2);
		permIds = permIds.substring(0, permIds.length()-1);
		return permissionDao.getPermissionByPermIds(permIds);
	}
	
	/**
	 * <pre>
	 * 根据角色ID集合查找菜单权限集
	 * </pre>
	 * @param roles
	 * @return
	 */
	public List<Permission> getPermissionByRoleIds(Collection<Role> roles)
	{
		String roleIds = "";
		for(Role role:roles){
			roleIds +=role.getId()+",";
		}
		if(roleIds.length()>=2);
		roleIds = roleIds.substring(0, roleIds.length()-1);
		return permissionDao.getPermissionByRoles(roleIds);
	}

	/**
	 * 
	 * <pre>
	 * 根据角色id集合得到菜单权限
	 * </pre>
	 * @param roleids
	 * @return
	 */
	public List<Permission> getPermissionByRoles(String roleids)
	{
		return permissionDao.getPermissionByRoles(roleids);
	}
	
	/**
	 * 
	 * <pre>
	 * 根据角色id得到该角色的所有权限集合
	 * </pre>
	 * @param roleId
	 * @return
	 */
	public List<Permission> getPermissionByRoleId(Long roleId)
	{
		return permissionDao.getPermissionByRoleId(roleId);
	}
	
	/**
	 * 
	 * <pre>
	 * 根据权限值得到权限信息集合
	 * </pre>
	 * @param permValue
	 * @return
	 */
	public List<Permission> getPermByPvalue(String permValue){
		try{
			return this.permissionDao.getPermByPvalue(permValue);
		}catch(Exception ex){
			log.error(ex.toString());
			return null;
		}
		
	}
	
}
