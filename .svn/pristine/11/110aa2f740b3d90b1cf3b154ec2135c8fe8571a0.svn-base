package com.gzgb.epo.dao.role;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.gzgb.epo.dao.base.BaseDaoImpl;
import com.gzgb.epo.entity.Role;

/**
 * 
 * <pre>
 * 角色管理DAO实现类
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-15
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao
{

	@Override
	public void updateRoleByStatus(int status, Long id)
	{
		try{
			Query query = getSession().createQuery("update Role set status=? where id=?");
			query.setParameter(0, status);
			query.setParameter(1, id);
			query.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
