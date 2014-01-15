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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gzgb.epo.entity.User;
import com.gzgb.epo.entity.WebSiteMain;
import com.gzgb.epo.service.user.UserService;
import com.gzgb.epo.service.websitemain.WebSiteMainService;

/**
 * 
 * <pre>
 * 系统管理控制器
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Controller
@RequestMapping(value = "/systemManage")
public class SystemManageController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private WebSiteMainService webSiteMainService;
	
	Logger logger = LoggerFactory.getLogger(SystemManageController.class);

	/**
	 * 进入系统管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "index")
	public String index(Model model, HttpServletRequest request) {
		return "systemManage/systemManageIndex";
	}

	/**
	 * 进入站点管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toSiteManage")
	public String toSiteManage(Model model, HttpServletRequest request) {
		return "systemManage/systemManageToSiteManage";
	}

	/**
	 * 进入添加站点页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toAddSite")
	public String toAddSite(Model model, HttpServletRequest request) {
		return "systemManage/systemManageToAddSite";
	}

	/**
	 * 进入信息统计页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "statistics")
	public String statistics(Model model, HttpServletRequest request) {
		return "systemManage/systemManageStatistics";
	}

	/**
	 * 进入采集点管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toGatherManage")
	public String toGatherManage(Model model, HttpServletRequest request, Long webSiteID) {
		model.addAttribute("webSiteID", webSiteID);
		List<WebSiteMain> list= webSiteMainService.getAll(WebSiteMain.class, null);
		List<Map<Object,Object>> webSiteNameList = new ArrayList<Map<Object,Object>>();
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				WebSiteMain webSiteMain =list.get(i);
				Map<Object,Object> map = new HashMap<Object,Object>();
				map.put("key",webSiteMain.getId());
				map.put("value",webSiteMain.getWsmName());
				webSiteNameList.add(map);
			}
		}
		model.addAttribute("webSiteNameList", webSiteNameList);
		return "systemManage/systemManageToGatherManage";
	}

	/**
	 * 进入添加采集点页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toAddGather")
	public String toAddGather(Model model, HttpServletRequest request) {
		List<WebSiteMain> list= webSiteMainService.getAll(WebSiteMain.class, null);
		List<Map<Object,Object>> webSiteNameList = new ArrayList<Map<Object,Object>>();
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				WebSiteMain webSiteMain =list.get(i);
				Map<Object,Object> map = new HashMap<Object,Object>();
				map.put("key",webSiteMain.getId());
				map.put("value",webSiteMain.getWsmName());
				webSiteNameList.add(map);
			}
		}
		model.addAttribute("webSiteNameList", webSiteNameList);
		return "systemManage/systemManageToAddGather";
	}

	/**
	 * 进入个人中心页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "personalCenter")
	public String personalCenter(Model model, HttpServletRequest request) {
		Long id = (Long) request.getSession().getAttribute("userId");
		if(id!=null){
			User user = userService.findById(id, User.class);
			Long time = Long.parseLong(user.getLastLoginTime().toString())* 1000;
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 	//格式化日期 
			String lastTime = f.format(new Date(time));
			user.setLastTime(lastTime);
			user.setType(userService.getUserType(user.getUserType()));
			model.addAttribute("user", user);
		}
		
		return "systemManage/systemManagePersonalCenter";
	}

	/**
	 * 进入更改密码页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toChangePass")
	public String toChangePass(Model model, HttpServletRequest request) {
		return "systemManage/systemManageToChangePass";
	}

	/**
	 * 进入修改信息页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toEditUser")
	public String toEditUser(Model model, HttpServletRequest request) {
		Long id = (Long) request.getSession().getAttribute("userId");
		if(id!=null){
			User user = userService.findById(id, User.class);
			model.addAttribute("user", user);
		}
		return "systemManage/systemManageToEditUser";
	}

	/**
	 * 进入用户管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toUserManage")
	public String toUserManage(Model model, HttpServletRequest request) {
		return "systemManage/systemManageToUserManage";
	}

	/**
	 * 进入添加用户页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "toAddUser")
	public String toAddUser(Model model, HttpServletRequest request) {
		return "systemManage/systemManageToAddUser";
	}

}
