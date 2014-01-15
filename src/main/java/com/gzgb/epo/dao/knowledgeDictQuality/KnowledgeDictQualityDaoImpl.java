package com.gzgb.epo.dao.knowledgeDictQuality;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.gzgb.epo.dao.base.BaseDaoImpl;

import com.gzgb.epo.entity.KnowledgeDictItem;
import com.gzgb.epo.entity.KnowledgeDictQuality;
import com.gzgb.epo.util.DateUtil;


/**
 * 
 * <pre>
 * 部门DAOImpl
 * </pre>
 * 
 * @author LiuYongbin
 * @version 1.0, 2014-01-6
 */
@Repository
public class KnowledgeDictQualityDaoImpl extends BaseDaoImpl<KnowledgeDictQuality> implements KnowledgeDictQualityDao {

	/**
	*
	* <pre>
	* findByName
	* </pre>
	* @param 
	* @return 
	*/
	@SuppressWarnings("unchecked")
	@Override
	public KnowledgeDictQuality findByName(String name) throws QueryException{
		try {
			Criteria cri = getSession().createCriteria(KnowledgeDictQuality.class).add(
					Restrictions.eq("kdqName", name));
			if (cri.list() != null && cri.list().size() != 0) {
				return  (KnowledgeDictQuality) cri.list().get(0);
			} else {
				return null;
			}
		} catch (QueryException ex) {
			throw ex;
		}
	}
}
