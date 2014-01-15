package com.gzgb.epo.service.webgathernode;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzgb.epo.dao.webgathernode.WebGatherNodeDao;
import com.gzgb.epo.entity.WebGatherNode;
import com.gzgb.epo.entity.WebSiteMain;
import com.gzgb.epo.service.base.BaseService;
import com.gzgb.epo.service.websitemain.WebSiteMainService;

/**
 * 
 * <pre>
 * 采集点管理service
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Service
@Transactional(readOnly = true)
public class WebGatherNodeService extends BaseService<WebGatherNode>  {
	
	private static Logger logger = LoggerFactory.getLogger(WebGatherNodeService.class);

	@Autowired
	private WebGatherNodeDao webGatherNodeDao;
	
	@Autowired
	private WebSiteMainService webSiteMainService;
	
	private static String[] wgnTypeArray = new String[] { "新闻类", "评论类",
		"微博类", "论坛类", "博客类" };

	/**
	 * 删除采集点
	 * 
	 * @param id
	 */
	@Transactional(readOnly = false)
	public void deleteWebGatherNode(Long id) {
		try {
			logger.info("---delete()方法");
			WebGatherNode webGatherNode = this.webGatherNodeDao.findById(id, WebGatherNode.class);
			webGatherNodeDao.delete(webGatherNode);
		} catch (Exception ex) {
			logger.error(ex.toString());
		}

	}
	
	/**
	 * 
	 * <pre>
	 * 得到来源类别
	 * </pre>
	 * 
	 * @param wsmClass
	 * @return
	 */
	public String getWgnType(Byte wgnType) {
		logger.info("---getWgnType()方法");
		if (wgnType != null) {
			return wgnTypeArray[wgnType - 1];
		}
		return null;
	}
	
	/**
	 * 
	 * <pre>
	 * 检查采集点名称是否存在
	 * </pre>
	 * 
	 * @param wgnName
	 * @return
	 */
	public boolean checkWgnNameIsExits(String wgnName) {
		try {
			logger.info("---checkWgnNameIsExits()方法");
			boolean isExits = webGatherNodeDao.checkWgnNameIsExits(wgnName);
			return isExits;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return true;
		}
	}
	
	/**
	 * 根据采集点名称查找采集点（控制唯一）
	 * 
	 * @param wgnName
	 * @return
	 */
	@Transactional(readOnly = true)
	public WebGatherNode findWebGatherNodeByWgnName(String wgnName) {
		try {
			logger.info("---findWebGatherNodeByWgnName()方法");
			WebGatherNode webGatherNode = webGatherNodeDao.findWebGatherNodeByWgnName(wgnName);
			return webGatherNode;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return null;
		}

	}
	
	/**
	 * 
	 * <pre>
	 * 检查采集点标记是否存在
	 * </pre>
	 * 
	 * @param wgnUniqueId
	 * @return
	 */
	public boolean checkWgnUniqueIdIsExits(String wgnUniqueId) {
		try {
			logger.info("---checkWgnUniqueIdIsExits()方法");
			boolean isExits = webGatherNodeDao.checkWgnUniqueIdIsExits(wgnUniqueId);
			return isExits;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return true;
		}
	}
	
	/**
	 * 根据采集点标记查找采集点（控制唯一）
	 * 
	 * @param wgnUniqueId
	 * @return
	 */
	@Transactional(readOnly = true)
	public WebGatherNode findWebGatherNodeByWgnUniqueId(String wgnUniqueId) {
		try {
			logger.info("---findWebGatherNodeByWgnUniqueId()方法");
			WebGatherNode webGatherNode = webGatherNodeDao.findWebGatherNodeByWgnUniqueId(wgnUniqueId);
			return webGatherNode;
		} catch (Exception ex) {
			logger.error(ex.toString());
			return null;
		}

	}
	
	/**
	 * 
	 * <pre>
	 * 通过request得到采集字段配置
	 * </pre>
	 * @param request
	 * @return
	 */
	public String getConfigItem(HttpServletRequest request){
		logger.info("---getConfigItem()方法");
		String[] title = request.getParameterValues("item[title][]");
		String[] name = request.getParameterValues("item[name][]");
		String[] type = request.getParameterValues("item[type][]");
		String[] variable = request.getParameterValues("item[variable][]");
		String[] regex = request.getParameterValues("item[regex][]");
		String[] unit = request.getParameterValues("item[unit][]");
		String[] required = request.getParameterValues("item[required][]");
		
		JSONObject jSONObject = new JSONObject();
		JSONArray jtitle = new JSONArray();
		JSONArray jname = new JSONArray();
		JSONArray jtype = new JSONArray();
		JSONArray jvariable = new JSONArray();
		JSONArray jregex = new JSONArray();
		JSONArray junit = new JSONArray();
		JSONArray jrequired = new JSONArray();
		
		if(title != null){
			for(int i=0;i<title.length;i++){
				jtitle.put(title[i]);
			}
		}
		if(name!=null){
			for(int i=0;i<name.length;i++){
				jname.put(name[i]);
			}
		}
		if(type!=null){
			for(int i=0;i<type.length;i++){
				jtype.put(type[i]);
			}
		}
		if(variable!=null){
			for(int i=0;i<variable.length;i++){
				jvariable.put(variable[i]);
			}
		}
		if(regex!=null){
			for(int i=0;i<regex.length;i++){
				jregex.put(regex[i]);
			}
		}
		if(unit!=null){
			for(int i=0;i<unit.length;i++){
				junit.put(unit[i]);
			}
		}
		if(required!=null){
			for(int i=0;i<required.length;i++){
				jrequired.put(required[i]);
			}
		}

		jSONObject.put("title", jtitle);
		jSONObject.put("name", jname);
		jSONObject.put("type", jtype);
		jSONObject.put("variable", jvariable);
		jSONObject.put("regex", jregex);
		jSONObject.put("unit", junit);
		jSONObject.put("required", jrequired);
//		System.out.println("jSONObject --- "+jSONObject);
		return jSONObject.toString();
	}
	
	/**
	 * 
	 * <pre>
	 * 把一个采集点实体内容填充到另外一个采集点实体中
	 * </pre>
	 * @param wgn 目标填充采集点实体
	 * @param webGatherNode 源填充采集点实体
	 * @param request
	 */
	public void fillGatherNode(WebGatherNode wgn , WebGatherNode webGatherNode, HttpServletRequest request){
		logger.info("---fillGatherNode()方法");
		WebSiteMain webSiteMain = webSiteMainService.findById(webGatherNode.getWebSiteID(), WebSiteMain.class);
		wgn.setWsmId(webSiteMain);
		
		wgn.setWgnUpdateTime(new Date());
		wgn.setWgnName(webGatherNode.getWgnName());
		wgn.setWgnUniqueId(webGatherNode.getWgnUniqueId());
		wgn.setWgnEntryUrl(webGatherNode.getWgnEntryUrl());
		wgn.setWgnAllowRule(webGatherNode.getWgnAllowRule());
		wgn.setWgnDenyRule(webGatherNode.getWgnDenyRule());
		wgn.setWgnNextPage(webGatherNode.getWgnNextPage());
		wgn.setWgnAllowDomain(webGatherNode.getWgnAllowDomain());
		wgn.setWgnWeight(webGatherNode.getWgnWeight());
		wgn.setWgnType(webGatherNode.getWgnType());
		wgn.setWgnSpiderEnable(webGatherNode.getWgnSpiderEnable());
		wgn.setWgnDelay(webGatherNode.getWgnDelay());
		wgn.setWgnCookiesEnable(webGatherNode.getWgnCookiesEnable());
		wgn.setWgnProcessLinks(webGatherNode.getWgnProcessLinks());
		wgn.setWgnProxies(webGatherNode.getWgnProxies());
		wgn.setWgnLoginAccount(webGatherNode.getWgnLoginAccount());
		wgn.setWgnLoginEnable(webGatherNode.getWgnLoginEnable());
		wgn.setWgnLoginEntry(webGatherNode.getWgnLoginEntry());
		wgn.setWgnLoginPassword(webGatherNode.getWgnLoginPassword());
		wgn.setWgnDepthLimit(webGatherNode.getWgnDepthLimit());
		wgn.setWgnTimeInterval(webGatherNode.getWgnTimeInterval());
		wgn.setWgnTimeRefresh(webGatherNode.getWgnTimeRefresh());
		wgn.setWgnUserAgents(webGatherNode.getWgnUserAgents());
		wgn.setWgnTraditional(webGatherNode.getWgnTraditional());
		wgn.setWgnIsClean(webGatherNode.getWgnIsClean());
		
		String configItem = getConfigItem(request);
		wgn.setWgnConfigItem(configItem);
	}
}
