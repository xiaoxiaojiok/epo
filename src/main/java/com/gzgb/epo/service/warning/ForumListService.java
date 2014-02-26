package com.gzgb.epo.service.warning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.warning.ForumListDao;
import com.gzgb.epo.entity.ForumList;
import com.gzgb.epo.service.base.BaseService;

/**
 * 
 * <pre>
 * 论坛帖子舆情service
 * </pre>
 * 
 * @author JiangRundong
 * @version 1.0, 2014-2-25
 */
@Service
@Transactional(readOnly = true)

public class ForumListService extends BaseService<ForumList>{
	private static Logger logger = LoggerFactory
	.getLogger(ForumListService.class);
	
	@Autowired
	private ForumListDao forumListMainDao;

}
