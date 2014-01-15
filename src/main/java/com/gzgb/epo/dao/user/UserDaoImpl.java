package com.gzgb.epo.dao.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.QueryException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.gzgb.epo.dao.base.BaseDaoImpl;
import com.gzgb.epo.entity.User;

/**
 * <pre>
 * 用户管理dao
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> findAllUser(final int status) throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(User.class);
			if (status < 2) {
				cri.add(Restrictions.eq("status", status));
			}
			Collection<User> objList = cri.addOrder(Order.asc("id")).list();
			return objList;
		} catch (QueryException ex) {
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkLoginNameIsExits(final String loginName)
			throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(User.class).add(
					Restrictions.eq("loginName", loginName));
			Collection<User> objList = cri.list();
			if (objList != null && objList.size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (QueryException ex) {
			throw ex;
		}
	}

	@Override
	public User findUserByLoginName(final String loginName)
			throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(User.class).add(
					Restrictions.eq("loginName", loginName)).add(
					Restrictions.eq("status", 1));
			User user = (User) cri.uniqueResult();
			return user;
		} catch (QueryException ex) {
			throw ex;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> findUserByUserName(final String userName)
			throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(User.class).add(
					Restrictions.eq("userName", userName)).add(
					Restrictions.eq("status", 1));
			Collection<User> objList = cri.addOrder(Order.asc("id")).list();
			return objList;
		} catch (QueryException ex) {
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> getSuperManager() throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(User.class).add(
					Restrictions.eq("superManager", 1)).add(
					Restrictions.eq("status", 1));
			Collection<User> objList = cri.addOrder(Order.asc("id")).list();
			return objList;
		} catch (QueryException ex) {
			throw ex;
		}
	}
}
