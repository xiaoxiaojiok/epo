package com.gzgb.epo.dao.leaderInflence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gzgb.epo.dao.base.BaseDaoImpl;
import com.gzgb.epo.entity.LeaderHistoryRecord;
import com.gzgb.epo.entity.LeaderInfluence;

/**
 * 
 * <pre>
 * 舆论领袖影响DaoImpl
 * </pre>
 * @author LiuYongbin
 * @version 1.0, 2014-2-25
 */
@Repository
public class LeaderInfluenceDaoImpl extends BaseDaoImpl<LeaderInfluence> implements LeaderInfluenceDao{
    
	/**
	 * 
	 * <pre>
	 * 根据社交账号获得记录
	 * </pre>
	 * 
	 * @param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LeaderInfluence> findBySocialAccount(String socialAccount) throws QueryException{
		try {
			Criteria criteria = getSession().createCriteria(LeaderInfluence.class);
			criteria.add(Restrictions.eq("socialaccount", socialAccount));
			List<LeaderInfluence> list = criteria.list();
			if(list.size() == 0){
				return null;
			}	
			return list;	
		} catch (QueryException qe) {
			throw qe;
		}
	}
}
