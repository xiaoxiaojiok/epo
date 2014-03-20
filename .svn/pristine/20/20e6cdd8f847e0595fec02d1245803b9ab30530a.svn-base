package com.gzgb.epo.service.role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.role.RoleDao;
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
public class RoleService extends BaseService<Role>
{
	@Autowired 
	private RoleDao roleDao;
	Logger log = LoggerFactory.getLogger(RoleService.class);
	
	/**
	 * <pre>
	 * 修改角色状态
	 * </pre>
	 * @param status
	 * @param id
	 */
	@Transactional(readOnly = false)
	public void updateRoleByStatus(int status ,Long id)
	{
		log.info("---updateRoleByStatus()方法");
		roleDao.updateRoleByStatus(status, id);
	}
	


}

