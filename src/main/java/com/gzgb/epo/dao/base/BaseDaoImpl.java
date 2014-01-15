package com.gzgb.epo.dao.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * <pre>
 * 基础dao接口实现类
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void delete(T e) throws QueryException {
		try {
			getSession().delete(e);
		} catch (QueryException ex) {
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Object id, Class<T> cls) throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(cls).add(
					Restrictions.idEq(id));
			if (cri.list() != null && cri.list().size() != 0) {
				return (T) cri.list().get(0);
			} else {
				return null;
			}
		} catch (QueryException ex) {
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> cls) throws QueryException {
		try {
			List<T> objList = getSession().createCriteria(cls).addOrder(
					Order.asc("id")).list();
			return objList;
		} catch (QueryException ex) {
			throw ex;
		}
	}

	@Override
	public void save(T t) throws QueryException {
		try {
			this.getSession().save(t);
		} catch (QueryException ex) {
			throw ex;
		}
	}

	@Override
	public void update(T t) throws QueryException {
		try {
			this.getSession().update(t);
		} catch (QueryException ex) {
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> cls, final Map map) throws QueryException {
		try {
			Criteria c = getSession().createCriteria(cls);
			if (map != null && map.keySet() != null) {
				Iterator it = map.keySet().iterator();
				while (it.hasNext()) {
					String property = (String) it.next();
					String value = (String) map.get(property);
					if (value != null && !"".equals(value.trim())) {
						c.add(Restrictions.like(property, value));
					}
				}
			}
			List<T> objList = c.addOrder(Order.asc("id")).list();
			return objList;
		} catch (QueryException ex) {
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getAll(Class<T> cls,
			final Map<String, String> mapString,
			final Map<String, Byte> mapByte, final Map<String, Integer> mapInt,
			final Map<String, Long> mapLong, Integer page, Integer rows,
			String sort, String order) throws QueryException {
		try {
			Criteria c = getSession().createCriteria(cls);
			if (mapString != null && mapString.keySet() != null) {
				Iterator it = mapString.keySet().iterator();
				while (it.hasNext()) {
					String property = (String) it.next();
					String value = (String) mapString.get(property);
					if (value != null && !"".equals(value.trim())) {
						value = "%" + value + "%";
						c.add(Restrictions.like(property, value));
					}
				}
			}
			if (mapByte != null && mapByte.keySet() != null) {
				Iterator it = mapByte.keySet().iterator();
				while (it.hasNext()) {
					String property = (String) it.next();
					Byte value = (Byte) mapByte.get(property);
					if (value != null) {
						c.add(Restrictions.eq(property, value));
					}
				}
			}
			if (mapInt != null && mapInt.keySet() != null) {
				Iterator it = mapInt.keySet().iterator();
				while (it.hasNext()) {
					String property = (String) it.next();
					Integer value = (Integer) mapInt.get(property);
					if (value != null) {
						c.add(Restrictions.eq(property, value));
					}
				}
			}
			if (mapLong != null && mapLong.keySet() != null) {
				Iterator it = mapLong.keySet().iterator();
				while (it.hasNext()) {
					String property = (String) it.next();
					Long value = (Long) mapLong.get(property);
					if (value != null) {
						c.add(Restrictions.eq(property, value));
					}
				}
			}
			List<T> list = c.list();
			int total = 0;
			if (list != null) {
				total = list.size();
			}
			if (page == null || page == 0) {
				page = 1;
			}
			if (rows == null || rows == 0) {
				rows = 10;
			}
			if (sort != null && order != null) {
				if ("asc".equals(order)) {
					c.addOrder(Order.asc(sort));
				} else {
					c.addOrder(Order.desc(sort));
				}
			} else {
				// 默认按照ID升序排序
				c.addOrder(Order.asc("id"));
			}
			List<T> objList = c.setFirstResult((page - 1) * rows)
					.setMaxResults(rows).list();
			Map<String, Object> returnMap = new HashMap<String, Object>();
			if (objList != null && objList.size() > 0) {
				returnMap.put("total", total);
				returnMap.put("rows", objList);
				return returnMap;
			} else {
				returnMap.put("total", total);
				returnMap.put("rows", "");
				return returnMap;
			}

		} catch (QueryException ex) {
			throw ex;
		}
	}

}
