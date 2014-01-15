package com.gzgb.epo.dao.websitemain;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gzgb.epo.dao.base.BaseDaoImpl;
import com.gzgb.epo.entity.User;
import com.gzgb.epo.entity.WebSiteMain;

/**
 * <pre>
 * 站点管理DAO实现类
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Repository
public class WebSiteMainDaoImpl extends BaseDaoImpl<WebSiteMain> implements
		WebSiteMainDao {

	@Override
	public boolean checkWsmHomeIsExits(String wsmHome) throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(WebSiteMain.class).add(
					Restrictions.eq("wsmHome", wsmHome));
			Collection<WebSiteMain> objList = cri.list();
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
	public boolean checkWsmNameIsExits(String wsmName) throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(WebSiteMain.class).add(
					Restrictions.eq("wsmName", wsmName));
			Collection<WebSiteMain> objList = cri.list();
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
	public WebSiteMain findWebSiteMainByWsmName(String wsmName)
			throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(WebSiteMain.class).add(
					Restrictions.eq("wsmName", wsmName));
			WebSiteMain webSiteMain = (WebSiteMain) cri.list().get(0);
			return webSiteMain;
		} catch (QueryException ex) {
			throw ex;
		}

	}
}
