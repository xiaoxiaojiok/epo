package com.gzgb.epo.dao.mcode;

import java.util.Collection;

import com.gzgb.epo.dao.base.BaseDao;
import com.gzgb.epo.entity.Mcode;

/**
 * 
 * <pre>
 * 码表DAO
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-25
 */
public interface McodeDao extends BaseDao<Mcode>
{
	/**
	 * 
	 * <pre>
	 * 根据码类型查找码集合
	 * </pre>
	 * @return
	 */
	public Collection<Mcode> findByMtype(String mtype);
	
	/**
	 * 
	 * <pre>
	 * 根据码类型和码值查找码对象
	 * </pre>
	 * @param mtype
	 * @param mvalue
	 * @return
	 */
	public Mcode findByMtypeAndMvalue(String mtype,String mvalue);
	
	/**
	 * 
	 * <pre>
	 * 根据码类型和码名查找
	 * </pre>
	 * @param mtype
	 * @param mkey
	 * @return
	 */
	public Collection<Mcode> findByMtypeAndMkey(String mtype,String mkey);
	
	/**
	 * 
	 * <pre>
	 * 根据码类型和level查找
	 * </pre>
	 * @param mtype
	 * @param level
	 * @return
	 */
	public Collection<Mcode> findByMtypeAndLevel(String mtype,Integer level);
	
	/**
	 * 
	 * <pre>
	 * 根据码类型和码值集合查找码集合
	 * </pre>
	 * @param mtype
	 * @param values
	 * @return
	 */
	public Collection<Mcode> findByMtypeAndLevel(String mtype,Collection<String> values);


}
