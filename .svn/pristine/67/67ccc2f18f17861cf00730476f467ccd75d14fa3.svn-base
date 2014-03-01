package com.gzgb.epo.service.warning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.warning.SensitiveListDao;
import com.gzgb.epo.entity.SensitiveList;
import com.gzgb.epo.service.base.BaseService;

/**
 * 
 * <pre>
 * 敏感信息service
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-1
 */
@Service
@Transactional(readOnly = true)
public class SensitiveListService extends BaseService<SensitiveList> {
	
	private static Logger logger = LoggerFactory
	.getLogger(SensitiveListService.class);

	@Autowired
	private SensitiveListDao sensitiveListDao;

}
