package com.gzgb.epo.controller.systemManage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gzgb.epo.entity.User;
import com.gzgb.epo.entity.WebSiteMain;
import com.gzgb.epo.service.user.UserService;
import com.gzgb.epo.service.websitemain.WebSiteMainService;
import com.gzgb.epo.util.Encrypt;

/**
 * 
 * <pre>
 * 站点管理控制器
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Controller
@RequestMapping(value = "/webSiteMain")
public class WebSiteMainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private WebSiteMainService webSiteMainService;
	
	Logger logger = LoggerFactory.getLogger(SystemManageController.class);
	
	/**
	 * 
	 * <pre>
	 * 通过参数搜索站点信息
	 * </pre>
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "search")
	public @ResponseBody
	Map<String, Object> search(HttpServletRequest request, Byte wsmProperty,
			Byte wsmIsAbroad, Byte wsmClass,
			Byte wsmRegion, String wsmName, Integer page) {
		Map<String, String> mapString = new HashMap<String, String>();
		mapString.put("wsmName", wsmName);
		Map<String, Byte> mapByte = new HashMap<String, Byte>();
		mapByte.put("wsmProperty", wsmProperty);
		mapByte.put("wsmIsAbroad", wsmIsAbroad);
		mapByte.put("wsmClass", wsmClass);
		mapByte.put("wsmRegion", wsmRegion);

		Map<String, Object> myMap = webSiteMainService.getAll(WebSiteMain.class, mapString,
				mapByte, null, null, page, null, null, null);

		if (page == null || page == 0) {
			page = 1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		if (myMap != null && !"".equals(myMap.get("rows").toString())) {
			List<WebSiteMain> list = (List<WebSiteMain>) myMap.get("rows");
			for (int i = 0; i < list.size(); i++) {
				WebSiteMain webSiteMain = list.get(i);
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("id", webSiteMain.getId());
				map1.put("name", webSiteMain.getWsmName());
				map1.put("url", webSiteMain.getWsmHome());
				map1.put("type", webSiteMainService.getWsmClass(webSiteMain.getWsmClass()));
				map1.put("region",webSiteMainService.getWsmRegion(webSiteMain.getWsmRegion()));
				map1.put("status", webSiteMain.getWsmStatus());
				map1.put("updateUrl", "/webSiteMain/toUpdate/" + webSiteMain.getId() + "/"
						+ page);
				map1.put("manageUrl", "/systemManage/toGatherManage?webSiteID=" + webSiteMain.getId());
				map1.put("deleteUrl", "/webSiteMain/delete?id=" + webSiteMain.getId());

				dataList.add(map1);
			}
		}
		Map<String, Object> pageList = new HashMap<String, Object>();
		int total = (myMap == null) ? 0 : Integer.parseInt(myMap.get("total")
				.toString());
		pageList.put("size", 10); // 默认为10
		int size = 1;
		if (total > 10) {
			if (total % 10 != 0) {
				size = total / 10 + 1;
			} else {
				size = total / 10;
			}
		}
		pageList.put("count", size);
		pageList.put("current", page);
		pageList.put("total", total);

		map.put("data", dataList);
		map.put("page", pageList);
		return map;
	}
	
	/**
	 * 
	 * <pre>
	 * 进入更新站点页面
	 * </pre>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "toUpdate/{id}/{page}")
	public ModelAndView toUpdate(HttpServletRequest request,
			@PathVariable String id, @PathVariable Integer page) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("systemManage/systemManageToUpdateSite");
		if (page == null) {
			page = 1;
		}
		WebSiteMain webSiteMain = webSiteMainService.findById(Long.parseLong(id), WebSiteMain.class);
		mv.addObject("page", page);
		mv.addObject("webSiteMain", webSiteMain);
		return mv;
	}

	/**
	 * 
	 * <pre>
	 * 更新站点
	 * </pre>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "update")
	public @ResponseBody
	Map<String, Object> update(HttpServletRequest request, WebSiteMain webSiteMain, String old_wsmName) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		if(webSiteMain.getWsmName()!=null && !webSiteMain.getWsmName().equals(old_wsmName)){
			flag = webSiteMainService.checkWsmNameIsExits(webSiteMain.getWsmName());
		}
		if(flag){
			WebSiteMain wsm = webSiteMainService.findWebSiteMainByWsmName(webSiteMain.getWsmName());
			map.put("wsmName", "已存在，<a href=\"/webSiteMain/toUpdate/"+wsm.getId()+"/1\">点击更新</a>");
			return map;
		}

		try {
			WebSiteMain wsm = null;
			if(webSiteMain.getId()!=null){
				wsm = webSiteMainService.findById(webSiteMain.getId(), WebSiteMain.class);
			}
			if(wsm!=null){
				wsm.setWsmUpdateTime(new Date());
				wsm.setWsmName(webSiteMain.getWsmName());
				wsm.setWsmClass(webSiteMain.getWsmClass());
				wsm.setWsmHome(webSiteMain.getWsmHome());
				wsm.setWsmIsAbroad(webSiteMain.getWsmIsAbroad());
				wsm.setWsmProperty(webSiteMain.getWsmProperty());
				wsm.setWsmRegion(webSiteMain.getWsmRegion());
				webSiteMainService.save(wsm);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			map.put("success", false);
		}
		map.put("success", true);
		return map;

	}
	
	/**
	 * 
	 * <pre>
	 * 删除站点
	 * </pre>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "delete")
	public @ResponseBody
	Map<String, Object> delete(HttpServletRequest request, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (id != null) {
				webSiteMainService.deleteWebSiteMain(Long.parseLong(id));
				map.put("data", true);
			} else {
				map.put("data", false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return map;
	}
	
	/**
	 * 
	 * <pre>
	 * 增加站点
	 * </pre>
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "addSite")
	public @ResponseBody
	Map<String, Object> addSite(HttpServletRequest request, WebSiteMain webSiteMain) {
		Map<String, Object> map = new HashMap<String, Object>();

		boolean flag = false;
		if(webSiteMain.getWsmName()!=null){
			flag = webSiteMainService.checkWsmNameIsExits(webSiteMain.getWsmName());
		}
		if(flag){
			WebSiteMain wsm = webSiteMainService.findWebSiteMainByWsmName(webSiteMain.getWsmName());
			map.put("wsmName", "已存在，<a href=\"/webSiteMain/toUpdate/"+wsm.getId()+"/1\">点击更新</a>");
			return map;
		}
		webSiteMain.setWsmStatus((byte)1);
		webSiteMain.setWsmCreateTime(new Date());
		webSiteMain.setWsmUpdateTime(new Date());
		webSiteMain.setWsmDelete((byte)0);
		try {
			webSiteMainService.save(webSiteMain);
		} catch (Exception ex) {
			ex.printStackTrace();
			map.put("success", false);
		}
		map.put("success", true);
		return map;
	}
	
	/**
	 * 
	 * <pre>
	 * 通过站点名称检查唯一性
	 * </pre>
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "ajaxUnique")
	public @ResponseBody
	Map<String, Object> ajaxUnique(HttpServletRequest request, WebSiteMain webSiteMain, String old_wsmName) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			boolean flag = false;
			if(webSiteMain.getWsmName()!=null && !webSiteMain.getWsmName().equals(old_wsmName)){
				flag = webSiteMainService.checkWsmNameIsExits(webSiteMain.getWsmName());
			}
			if(flag){
				WebSiteMain wsm = webSiteMainService.findWebSiteMainByWsmName(webSiteMain.getWsmName());
				map.put("id", wsm.getId());
				map.put("name", wsm.getWsmName());
				map.put("url", "/webSiteMain/toUpdate/"+wsm.getId()+"/1");
				return map;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	

}
