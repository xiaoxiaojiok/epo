package com.gzgb.epo.service.warning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.warning.SensitiveDayDao;
import com.gzgb.epo.entity.SensitiveDay;
import com.gzgb.epo.service.base.BaseService;

/**
 * 
 * <pre>
 * 每天敏感信息量service
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-1
 */
@Service
@Transactional(readOnly = true)
public class SensitiveDayService extends BaseService<SensitiveDay> {
	
	private static Logger logger = LoggerFactory
	.getLogger(SensitiveDayService.class);

	@Autowired
	private SensitiveDayDao sensitiveDayDao;

}
