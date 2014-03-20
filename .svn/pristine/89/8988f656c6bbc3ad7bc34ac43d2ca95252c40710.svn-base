package com.gzgb.epo.dao.menu;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.gzgb.epo.dao.base.BaseDaoImpl;
import com.gzgb.epo.entity.Menu;

/**
 * 
 * <pre>
 * 菜单管理DAO实现类
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-15
 */
@Repository
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getAll(Class<Menu> cls, final Map map) throws QueryException {
		try {
			Criteria c = getSession().createCriteria(cls);
			if(map!=null && map.keySet()!=null){
				Iterator it = map.keySet().iterator();
				while(it.hasNext()){
					String property = (String)it.next();
					String value =(String) map.get(property);
					if(!property.startsWith("_")){
						c.add(Restrictions.eq(property, value));
					}else if(property.startsWith("_order")){
						String[] str = property.split("_");
						if(str.length<=4 && str[3].equals("asc")){
							c.addOrder(Order.asc(str[2]));
						}else{
							c.addOrder(Order.desc(str[2]));
						}
					}
				}
			}
			List<Menu> objList = c.list();
			return objList;
		} catch (QueryException ex) {
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Menu> getMenuListByLevel(final int menuLevel) throws QueryException
	{
		try{
			Criteria cri = getSession().createCriteria(Menu.class);
			cri.add(Restrictions.eq("menuLevel", menuLevel));
			cri.addOrder(Order.asc("menuLevel"));
			cri.addOrder(Order.asc("orderNum"));
			Collection<Menu> menulist = cri.list();
			return menulist;
		}catch(QueryException ex){
			throw ex;
		}
		
	}
	
	@Override
	public Menu findByMenuName(String menuName)
	{
		Query query = getSession().createQuery(" FROM Menu m WHERE m.menuName = ? ");  
		query.setParameter(0, menuName);  
		if(query.list()!=null&&query.list().size()>0){
			return (Menu)query.list().get(0);
		}
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Page<Menu> getSubMenuListByPMenu(Long pid, Pageable pageable)
	{
		Query query = getSession().createQuery("FROM Menu m WHERE m.menu.id = ?");
		query.setParameter(0, pid);
		List<Menu> menuList = (List<Menu>)query.list();
		Object t = menuList.size();
		return new PageImpl(menuList, pageable, t!=null?Long.parseLong(t.toString()):0);
	}

	@Override
	public Integer nextLevelCount(Long currMenuId)
	{
		Query query = getSession().createQuery("SELECT COUNT(m.id) FROM Menu m WHERE m.menu.id = ?");
		query.setParameter(0, currMenuId);
		Integer count =  (Integer)query.list().get(0);
		return count;
	}


}
