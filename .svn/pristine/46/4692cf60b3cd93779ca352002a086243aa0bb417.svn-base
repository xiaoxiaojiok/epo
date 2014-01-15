package com.gzgb.epo.dao.webgathernode;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gzgb.epo.dao.base.BaseDaoImpl;
import com.gzgb.epo.entity.WebGatherNode;
import com.gzgb.epo.entity.WebSiteMain;

/**
 * <pre>
 * 采集点管理DAO实现类
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Repository
public class WebGatherNodeDaoImpl extends BaseDaoImpl<WebGatherNode> implements
		WebGatherNodeDao {

	@Override
	public boolean checkWgnNameIsExits(String wgnName) throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(WebGatherNode.class)
					.add(Restrictions.eq("wgnName", wgnName));
			Collection<WebGatherNode> objList = cri.list();
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
	public WebGatherNode findWebGatherNodeByWgnName(String wgnName)
			throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(WebGatherNode.class)
					.add(Restrictions.eq("wgnName", wgnName));
			WebGatherNode webGatherNode = (WebGatherNode) cri.list().get(0);
			return webGatherNode;
		} catch (QueryException ex) {
			throw ex;
		}

	}

	@Override
	public boolean checkWgnUniqueIdIsExits(String wgnUniqueId)
			throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(WebGatherNode.class)
					.add(Restrictions.eq("wgnUniqueId", wgnUniqueId));
			Collection<WebGatherNode> objList = cri.list();
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
	public WebGatherNode findWebGatherNodeByWgnUniqueId(String wgnUniqueId)
			throws QueryException {
		try {
			Criteria cri = getSession().createCriteria(WebGatherNode.class)
					.add(Restrictions.eq("wgnUniqueId", wgnUniqueId));
			WebGatherNode webGatherNode = (WebGatherNode) cri.list().get(0);
			return webGatherNode;
		} catch (QueryException ex) {
			throw ex;
		}
	}

}
