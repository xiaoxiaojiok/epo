package com.gzgb.epo.dao.permission;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.gzgb.epo.dao.base.BaseDaoImpl;
import com.gzgb.epo.entity.Permission;

/**
 * 
 * <pre>
 * 权限管理DAO实现类
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-15
 */
@Repository
public class PermissionDaoImpl extends BaseDaoImpl<Permission> implements PermissionDao 
{
	
	@Override
	public void deleteByIds(String ids)
	{
		String[] id = ids.split(",");
		for(String pid:id){
			Permission p = findById(Long.parseLong(pid), Permission.class);
			delete(p);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getPermissionByPermIds(String permIds)
	{
		Query query = getSession().createQuery("from Permission p where p.id in (?)");
		query.setParameter(0, permIds);
		List<Permission> perlist = (List<Permission>)query.list();
		return perlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getPermissionByRoles(String roleids)
	{
		Query query = getSession().createQuery("select p from Permission p join p.roleList r where p.permType=-1 and r.id in("+roleids+")");
		List<Permission> perlist = (List<Permission>)query.list();
		return perlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getPermissionsByMenuId(Long menuId)
	{
		Query query = getSession().createQuery("from Permission p where p.menu.id=(?)");
		query.setParameter(0, menuId);
		List<Permission> perlist = (List<Permission>)query.list();
		return perlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getPermissionsByMenuIdAndRoleId(Long menuId, Long roleId)
	{
		Query query = getSession().createQuery("select p from Permission p join p.roleList r where p.menu.id=(?) and r.id=(?)");
		query.setParameter(0, menuId);
		query.setParameter(1, roleId);
		List<Permission> perlist = (List<Permission>)query.list();
		return perlist;
	}
	
	@SuppressWarnings("unchecked")
	public Page<Permission> queryByMenuName(String menuName,Pageable pageable){
		List<Permission> perlist = getSession().createCriteria(Permission.class).add(Expression.like("menu.menuName", "%" + menuName + "%")).list();
		Object t = perlist.size();
		return new PageImpl(perlist, pageable, t!=null?Long.parseLong(t.toString()):0);
	}

	@Override
	public boolean ifUserHasPermission(Long userId, String permValue)
	{
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(*) from ");
		sql.append(" (");
		sql.append("  select pr.perm_id as perm_id from USER_ROLE ur ");
		sql.append("  left join	PERMISSION_ROLE pr on ur.role_id=pr.role_id");
		sql.append("  where ur.user_id=").append(userId);
		sql.append(" ) upr");
		sql.append(" left join PERMISSION p on upr.perm_id=p.permId");
		sql.append(" where p.permValue='").append(permValue).append("'");		
		Integer count = (Integer) getSession().createSQLQuery(sql.toString()).list().get(0);
		return count>0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getPermissionByRoleId(Long roleId) throws QueryException
	{
		try{
			Query query = getSession().createQuery("select distinct p from Permission p join p.roleList r where r.id="+roleId);
			List<Permission> perlist = (List<Permission>)query.list();
			return perlist;
		}catch(QueryException ex){
			throw ex;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getPermByPvalue(final String permValue) throws QueryException
	{
		try{
			Criteria cri = getSession().createCriteria(Permission.class);
			cri.add(Restrictions.eq("permValue", permValue));
			Collection<Permission> permlist = cri.list();
			return (List<Permission>) permlist;
		}catch(QueryException ex){
			throw ex;
		}
	}

}
