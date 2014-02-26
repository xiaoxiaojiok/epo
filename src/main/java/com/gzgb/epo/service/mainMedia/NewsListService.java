package com.gzgb.epo.service.mainMedia;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.entity.NewsList;
import com.gzgb.epo.service.base.BaseService;

/**
 * 
 * <pre>
 * 新闻舆情service
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2014-2-26
 */
@Service
@Transactional(readOnly = true)
public class NewsListService extends BaseService<NewsList> {

}
