package com.gzgb.epo.service.mcode;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.mcode.McodeDao;
import com.gzgb.epo.entity.Mcode;
import com.gzgb.epo.service.base.BaseService;

/**
 * 
 * <pre>
 * 码表Service
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-25
 */
@Component
@Transactional(readOnly = true)
public class McodeService extends BaseService<Mcode>{
	
	@Autowired
	private McodeDao mcodeDao;
	Logger log = LoggerFactory.getLogger(McodeService.class);
	
	
	/**
	 * 根据码类型查找
	 */
	public List<Mcode> findByMtye(String mtype){		
		
		return (List<Mcode>) this.mcodeDao.findByMtype(mtype);
	}
	
	/**
	 * 根据码类型和码名查找
	 */
	public List<Mcode> findByMtypeAndMkey(String mtype,String mkey){
		
		return (List<Mcode>) this.mcodeDao.findByMtypeAndMkey(mtype, mkey);
	}
	
	/**
	 * 根据码类型和码值得到一条码记录
	 */
	public Mcode findByMtypeAndMvalue(String mtype,String mvalue){
		
		return this.mcodeDao.findByMtypeAndMvalue(mtype, mvalue);
	}
	
	/**
	 * 根据码类型和level得到码集合
	 */
	public List<Mcode> findByMtypeAndLevel(String mtype,int level){
		
		return (List<Mcode>) this.mcodeDao.findByMtypeAndLevel(mtype, level);
	}
	
	/**
	 * 
	 * <pre>
	 * 根据码类型和码值集合返回码集合
	 * </pre>
	 * @param type
	 * @param gradeCodes
	 * @return
	 */
	public List<Mcode> findByMtypeAndValues(String type,Collection<String> gradeCodes){
		return (List<Mcode>) this.mcodeDao.findByMtypeAndLevel(type, gradeCodes);
	}
	
}
