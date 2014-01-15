package com.gzgb.epo.dao.user;

import java.util.Collection;
import java.util.List;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.User;

/**
 * 
 * <pre>
 * 用户管理DAO
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
public interface UserDao extends BaseDao<User> {
	/**
	 * 
	 * <pre>
	 * 根据状态查找所有用户
	 * </pre>
	 * 
	 * @param status
	 * @return
	 */
	public Collection<User> findAllUser(int status);

	/**
	 * 
	 * <pre>
	 * 检查登录名是否存在
	 * </pre>
	 * 
	 * @param loginName
	 * @return
	 */
	public boolean checkLoginNameIsExits(String loginName);

	/**
	 * 
	 * <pre>
	 * 根据登录名获取用户
	 * </pre>
	 * 
	 * @param loginName
	 * @return
	 */
	public User findUserByLoginName(String loginName);

	/**
	 * 
	 * <pre>
	 * 根据用户名称获取用户
	 * </pre>
	 * 
	 * @param userName
	 * @return
	 */
	public Collection<User> findUserByUserName(String userName);

	/**
	 * 
	 * <pre>
	 * 得到系统的超管
	 * </pre>
	 * 
	 * @return
	 */
	public Collection<User> getSuperManager();

}
