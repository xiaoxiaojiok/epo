package com.gzgb.epo.service.hierarchy;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.regionBaseInfo.RegionBaseInfoDao;
import com.gzgb.epo.entity.Hierarchy;
import com.gzgb.epo.entity.RegionBaseInfo;
import com.gzgb.epo.service.base.BaseService;

/**
 * 
 * <pre>
 *  阶层service
 * </pre>
 * 
 * @author Liuyongbin
 * @version 1.0, 2014-1-6
 */
@Service
@Transactional(readOnly = true)
public class HierarchyService extends BaseService<Hierarchy>{

}
