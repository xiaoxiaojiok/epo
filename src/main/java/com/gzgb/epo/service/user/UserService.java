package com.gzgb.epo.service.user;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.user.UserDao;
import com.gzgb.epo.entity.User;
import com.gzgb.epo.service.base.BaseService;

/**
 * 
 * <pre>
 * 用户管理service
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Service
@Transactional(readOnly = true)
public class UserService extends BaseService<User> {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;

	private static String[] userTypeArray = new String[] { "系统管理员", "部负责人",
			"处室负责人", "处室人员", "中心负责人", "中心人员" };

	/**
	 * 获取所有的已启用用户
	 * 
	 * @param pageable
	 * @return
	 */
	public List<User> getAllAbleUser() {
		try {
			logger.info("---getAllAbleUser()方法");
			return (List<User>) userDao.findAllUser(0);
		} catch (Exception ex) {
			logger.error(ex.toString());
			return null;
		}

	}

	/**
	 * 获取所有用户（包括已启用和已停用的用户）
	 * 
	 * @param pageable
	 * @return
	 */
	public void getAllUsers() {
		try {
			logger.info("---getAllUsers()方法");
			userDao.findAllUser(2);
		} catch (Exception ex) {
			logger.error(ex.toString());
		}

	}

	/**
	 * 根据用户ID查找用户
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(Long id) {
		try {
			logger.info("---getUser()方法");
			User user = (User) userDao.findById(id, User.class);
			return user;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return null;
		}

	}

	/**
	 * 
	 * <pre>
	 * 检查登录名是否存在
	 * </pre>
	 * 
	 * @param loginName
	 * @return
	 */
	public boolean checkLoginNameIsExits(String loginName) {
		try {
			logger.info("---checkLoginNameIsExits()方法");
			boolean isExits = userDao.checkLoginNameIsExits(loginName);
			return isExits;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return true;
		}
	}

	/**
	 * 根据登录名查找用户（登录名控制唯一）
	 * 
	 * @param loginName
	 * @return
	 */
	@Transactional(readOnly = true)
	public User findUserByLoginName(String loginName) {
		try {
			logger.info("---findUserByLoginName()方法");
			User user = userDao.findUserByLoginName(loginName);
			return user;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return null;
		}

	}

	/**
	 * 返回当前用户
	 * 
	 * @param request
	 * @return
	 */
	public User getUser(HttpServletRequest request) {
		try {
			logger.info("---getUser()方法");
			String loginName = request.getRemoteUser();
			User user = findUserByLoginName(loginName);
			return user;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return null;
		}

	}

	/**
	 * 用户真实姓名可能不唯一 根据用户的真实姓名查找用户
	 * 
	 * @param loginName
	 * @return
	 */
	public List<User> findByUsername(String username) {
		try {
			logger.info("---findByUsername()方法");
			List<User> list = (List<User>) userDao.findUserByUserName(username);
			return list;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return null;
		}

	}

	/**
	 *保存用户 用于用户的增加、修改
	 * 
	 * @param user
	 */
	@Transactional(readOnly = false)
	public void saveUser(User user) {
		try {
			logger.info("---saveUser()方法");
			// 基础信息保存不成功，不往下执行
			if (user.getId() == null || user.getId() == 0) {
				userDao.save(user);
			} else {
				userDao.update(user);
			}

		} catch (Exception ex) {
			logger.error(ex.toString());
		}

	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	@Transactional(readOnly = false)
	public void deleteUser(Long id) {
		try {
			logger.info("---deleteUser()方法");
			if (isSupervisor(id)) {
				return;
			}
			User user = this.userDao.findById(id, User.class);
			userDao.delete(user);
		} catch (Exception ex) {
			logger.error(ex.toString());
		}

	}

	/**
	 * 判断是否超级管理员.
	 */
	public boolean isSupervisor(Long id) {
		try {
			logger.info("---isSupervisor()方法");
			return getUser(id).getUserType() == 1;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return false;
		}

	}

	/**
	 * 
	 * <pre>
	 * 得到超级管理员
	 * </pre>
	 * 
	 * @return
	 */
	public Collection<User> getSuperManager() {
		try {
			logger.info("---getSuperManager()方法");
			return this.userDao.getSuperManager();
		} catch (Exception ex) {
			logger.error(ex.toString());
			return null;
		}

	}

	/**
	 * 
	 * <pre>
	 * 得到用户类型
	 * </pre>
	 * 
	 * @param userType
	 * @return
	 */
	public String getUserType(Byte userType) {
		logger.info("---getUserType()方法");
		if (userType != null) {
			return userTypeArray[userType - 1];
		}
		return null;
	}

}
