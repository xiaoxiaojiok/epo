package com.gzgb.epo.dao.mcode;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.QueryException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gzgb.epo.dao.base.BaseDaoImpl;
import com.gzgb.epo.entity.Mcode;

/**
 * 
 * <pre>
 * 码表DAO实现类
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-25
 */
@Repository
public class McodeDaoImpl extends BaseDaoImpl<Mcode> implements McodeDao
{
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Mcode> findByMtype(final String mtype) throws QueryException
	{
		try {
			Criteria cri = getSession().createCriteria(Mcode.class);
			if(mtype!=null && !mtype.equals("")){
				cri.add(Restrictions.eq("mtype", mtype));
			}
//			cri.add(Restrictions.ne("datelevel", 0));
			cri.addOrder(Order.asc("orderNum"));
			Collection<Mcode> objList = cri.list();
			return objList;
		} catch (QueryException e) {
			throw e;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Mcode findByMtypeAndMvalue(String mtype, String mvalue) throws QueryException
	{
		Mcode mcode = null;
		Criteria cri = getSession().createCriteria(Mcode.class);
		cri.add(Restrictions.eq("mtype", mtype));
		cri.add(Restrictions.eq("mvalue", mvalue));
		List<Mcode> mlist = cri.list();
		if(mlist!=null && mlist.size()>0){
			mcode = mlist.get(0);
		}
		return mcode;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Mcode> findByMtypeAndLevel(final String mtype,final Integer level) throws QueryException 
	{
		try{
			Criteria cri = getSession().createCriteria(Mcode.class);
			if(mtype!=null && !mtype.equals("")){
				cri.add(Restrictions.eq("mtype", mtype));
			}
			if(level!=null){
				cri.add(Restrictions.eq("datelevel", level));
			}
			Collection<Mcode> objList = cri.list();
			return objList;
		}catch(QueryException ex){
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Mcode> findByMtypeAndLevel(final String mtype, final Collection<String> values) throws QueryException 
	{
		try{
			Criteria cri = getSession().createCriteria(Mcode.class);
			if(mtype!=null && !mtype.equals("")){
				cri.add(Restrictions.eq("mtype", mtype));
			}
			if(values!=null && values.size()>0){
				cri.add(Restrictions.in("mvalue", values));
			}
			Collection<Mcode> objList = cri.list();
			return objList;
		}catch(QueryException ex){
			throw ex;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Mcode> findByMtypeAndMkey(final String mtype,final String mkey) throws QueryException 
	{
		try{
			Criteria cri = getSession().createCriteria(Mcode.class);
			if(mtype!=null && !mtype.equals("")){
				cri.add(Restrictions.eq("mtype", mtype));
			}
			if(mkey!=null && !mkey.equals("")){
				cri.add(Restrictions.eq("mkey", mkey));
			}
			Collection<Mcode> objList = cri.list();
			return objList;
		}catch(QueryException ex){
			throw ex;
		}
	}

}
