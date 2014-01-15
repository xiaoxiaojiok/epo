package com.gzgb.epo.service.websitemain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.websitemain.WebSiteMainDao;
import com.gzgb.epo.entity.User;
import com.gzgb.epo.entity.WebSiteMain;
import com.gzgb.epo.service.base.BaseService;

/**
 * 
 * <pre>
 * 站点管理service
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Service
@Transactional(readOnly = true)
public class WebSiteMainService extends BaseService<WebSiteMain> {

	private static Logger logger = LoggerFactory
			.getLogger(WebSiteMainService.class);

	@Autowired
	private WebSiteMainDao webSiteMainDao;

	private static String[] wsmClassArray = new String[] { "综合门户", "新闻门户",
			"地方新闻", "消费资讯", "微博", "社区论坛", "博客", "其他" };
	
	private static String[] wsmRegionArray = new String[] { "北京", "上海", "天津",
			"重庆", "河北", "山西", "辽宁", "吉林", "黑龙江", "江苏", "浙江", "安徽", "福建", "江西",
			"山东", "河南", "湖北", "湖南", "广东", "海南", "四川", "贵州", "云南", "陕西", "甘肃",
			"青海", "台湾", "内蒙古", "西藏", "广西", "宁夏", "新疆", "香港", "澳门", "境外" };

	/**
	 * 删除站点
	 * 
	 * @param id
	 */
	@Transactional(readOnly = false)
	public void deleteWebSiteMain(Long id) {
		try {
			logger.info("---delete()方法");
			WebSiteMain webSiteMain = this.webSiteMainDao.findById(id,
					WebSiteMain.class);
			webSiteMainDao.delete(webSiteMain);
		} catch (Exception ex) {
			logger.error(ex.toString());
		}

	}

	/**
	 * 
	 * <pre>
	 * 得到站点类别
	 * </pre>
	 * 
	 * @param wsmClass
	 * @return
	 */
	public String getWsmClass(Byte wsmClass) {
		logger.info("---getWsmClass()方法");
		if (wsmClass != null) {
			return wsmClassArray[wsmClass - 1];
		}
		return null;
	}

	/**
	 * 
	 * <pre>
	 * 得到所属地区
	 * </pre>
	 * 
	 * @param wsmClass
	 * @return
	 */
	public String getWsmRegion(Byte wsmRegion) {
		logger.info("---getWsmRegion()方法");
		if (wsmRegion != null) {
			return wsmRegionArray[wsmRegion - 1];
		}
		return null;
	}
	
	/**
	 * 
	 * <pre>
	 * 检查站点名称是否存在
	 * </pre>
	 * 
	 * @param wsmName
	 * @return
	 */
	public boolean checkWsmNameIsExits(String wsmName) {
		try {
			logger.info("---checkWsmNameIsExits()方法");
			boolean isExits = webSiteMainDao.checkWsmNameIsExits(wsmName);
			return isExits;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return true;
		}
	}
	
	/**
	 * 
	 * <pre>
	 * 检查网路地址是否存在
	 * </pre>
	 * 
	 * @param wsmHome
	 * @return
	 */
	public boolean checkWsmHomeIsExits(String wsmHome) {
		try {
			logger.info("---checkWsmHomeIsExits()方法");
			boolean isExits = webSiteMainDao.checkWsmHomeIsExits(wsmHome);
			return isExits;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return true;
		}
	}
	
	/**
	 * 根据站点名称查找站点（控制唯一）
	 * 
	 * @param wsmName
	 * @return
	 */
	@Transactional(readOnly = true)
	public WebSiteMain findWebSiteMainByWsmName(String wsmName) {
		try {
			logger.info("---findWebSiteMainByWsmName()方法");
			WebSiteMain webSiteMain = webSiteMainDao.findWebSiteMainByWsmName(wsmName);
			return webSiteMain;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return null;
		}

	}
}
