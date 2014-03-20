package com.gzgb.epo.controller.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gzgb.epo.entity.Menu;
import com.gzgb.epo.entity.Permission;
import com.gzgb.epo.entity.User;
import com.gzgb.epo.publics.StringView;
import com.gzgb.epo.service.menu.MenuService;
import com.gzgb.epo.service.permission.PermissionService;
import com.gzgb.epo.service.shiro.ShiroDbRealm.ShiroUser;
import com.gzgb.epo.service.user.UserService;

/**
 * 
 * <pre>
 * 菜单管理控制器
 * </pre>
 * @author 肖坚
 * @version 1.0, 2014-3-16
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private UserService userService;
//	@Autowired
//	private RemoteClient remoteClient;
	
	/**
	 * 菜单管理  -- 首页
	 * 
	 * @return
	 */
//	@RequiresPermissions("menu:view")
	@RequestMapping(value = "index/{pMenuId}")
	public String index(@PathVariable Long pMenuId,Model model){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Menu> list = (List<Menu>) menuService.getMenuListByLevel(1);
		String menuOptions = menuService.menuOptions(list, null);
		map.put("menuOptions", menuOptions);
		//this.remoteClient.testRemote();
		menuService.getLeftMenu(pMenuId,model);
		model.addAttribute("menuOptions", menuOptions);
		return "menu/index";
	}
	
	/**
	 * 菜单管理  -- 列表
	 * 
	 * @return
	 */
//	@RequiresPermissions("menu:view")
	@RequestMapping(value = "list")
	public String list(Model model){
		List<Menu> list = (List<Menu>) menuService.getMenuListByLevel(1);
		String jValue = "[";
		jValue = menuService.getJsonStringForZTree(list,jValue);
		if(list.size() > 0){
			jValue = jValue.substring(0,jValue.length() - 1);
		}
		jValue += "]";
		model.addAttribute("jValue", jValue);
		Menu menu = menuService.findByMenuName("菜单管理");
		menuService.getLeftMenu(menu.getId(),model);
		return "menu/list";
	}
	
	/**
	 * 菜单管理  -- 编辑
	 * 
	 * @param request
	 * @param id
	 * @param addType	正常添加0
	 * 					正常修改1
	 * 					添加下级2
	 * @return
	 */
//	@RequiresPermissions("menu:edit")
	@RequestMapping(value = "edit")
	public ModelAndView edit(HttpServletRequest request,Long id,Integer addType,Model model){
		Map<String,Object> map = new HashMap<String,Object>();
		Menu menu = (Menu) menuService.findById(id, Menu.class);
		List<Menu> list = (List<Menu>) menuService.getMenuListByLevel(1);
		String menuOptions = "";
		if(addType == 2){
			menuOptions = menuService.menuOptions(list, menu);
			menu = null;
		}else{
			menuOptions = menuService.menuOptions(list, menu == null ? null : menu.getMenu());
		}
		map.put("menuOptions", menuOptions);
		map.put("menu", menu);
		map.put("addType", addType);
		Menu menu1 = menuService.findByMenuName("菜单管理");
		menuService.getLeftMenu(menu1.getId(),model);
		return new ModelAndView("menu/edit",map);
	}
	
	/**
	 * 菜单管理  -- 保存
	 * 
	 * @return
	 */
//	@RequiresPermissions("menu:edit")
	@RequestMapping(value = "save")
	public ModelAndView save(HttpServletRequest request,Menu menu,Long pid){
		StringView view = new StringView();
		Menu pMenu = null;
		if(StringUtils.isEmpty(menu.getMenuUrl())){
			menu.setMenuUrl("/");
		}
		try{
			if(pid != 0){
				pMenu = (Menu) menuService.findById(pid,Menu.class);
			}else{
				pMenu = menuService.findByMenuName("ROOT");
			}
			if(menu.getId() == null || menu.getId()==0){	//新增菜单
				ShiroUser shiroUser = (ShiroUser)SecurityUtils.getSubject().getPrincipal();
				User user = userService.getUser(shiroUser.getId());
				menu.setMenu(pMenu);
				menu.setCreater(user);
				menuService.save(menu);
				if(menu.getMenuLevel() > 1){
					//新增菜单时，增加该菜单所属权限
					Permission p = new Permission();
					p.setPermName(menu.getMenuName() + "[菜单]");
					p.setDescript(menu.getMenuName());
					p.setPermType(-1);
					p.setPermValue(String.valueOf(menu.getId()));
					p.setMenu(menu);
					permissionService.save(p);
				}
			}else{	//修改菜单
				Menu m = (Menu) menuService.findById(menu.getId(),Menu.class);
				m.setMenuName(menu.getMenuName());
				m.setMenuUrl(menu.getMenuUrl());
				m.setOrderNum(menu.getOrderNum());
				m.setStatus(menu.getStatus());
				m.setMenuLevel(menu.getMenuLevel());
				m.setMenu(pMenu);
				menuService.update(m);
				
			}
			view.setContent("success");
		}catch(Exception ex){
			view.setContent("faild");
			ex.printStackTrace();
		}
		return new ModelAndView(view);
	}
	
	/**
	 * 菜单管理  -- 删除菜单及子菜单
	 * 
	 * @return
	 */
//	@RequiresPermissions("menu:delete")
	@RequestMapping(value = "delete")
	public ModelAndView delete(String ids){
		StringView view = new StringView();
		Menu m = null;
		try{
			if(StringUtils.isNotEmpty(ids)){
				String arr[] = ids.split(",");
				for (String string : arr)
				{
					m = (Menu) menuService.findById(new Long(string),Menu.class);
					List<Menu> allList = menuService.findAll();
					//有外键关联需删除所有子菜单
					List<Menu> list = menuService.getSubMenuListByPMenu(m,allList);
					menuService.deleteSubMenus(list);
					List<Permission> permlist = permissionService.getPermissionsByMenuId(m.getId());
					if(permlist!=null){
						for(Permission per:permlist){
							permissionService.delete(per);
						}
					}
					//删除菜单
					menuService.delete(m);
				}
 			}
			view.setContent("success");
		}catch(Exception ex){
			view.setContent("faild");
			ex.printStackTrace();
		}
		return new ModelAndView(view);
	}
	
	/**
	 * 菜单管理  -- 删除菜单及子菜单
	 * 
	 * @return
	 */
//	@RequiresPermissions("menu:delete")
	@RequestMapping(value = "/delNode")
	public ModelAndView delNode(Long id){
		StringView view = new StringView();
		Menu m = null;
		try{
			m = menuService.findById(id);
			//StringUtil.debug(m.getId());
			//有外键关联需删除所有子菜单
			List<Menu> allList = menuService.findAll();
			List<Menu> list = menuService.getSubMenuListByPMenu(m,allList);
			menuService.deleteSubMenus(list);
			//删除菜单
			menuService.delete(m.getId());
			view.setContent("success");
		}catch(Exception ex){
			view.setContent("faild");
			ex.printStackTrace();
		}
		return new ModelAndView(view);
	}
	
	/**
	 * 菜单管理  -- 禁用 / 启用
	 * 
	 * @return
	 */
//	@RequiresPermissions("menu:setup")
	@RequestMapping(value = "setup")
	public ModelAndView setup(Long id,Integer status){
		StringView view = new StringView();
		Menu m = null;
		try{
			m = (Menu) menuService.findById(id,Menu.class);
			m.setStatus(status);
			menuService.update(m);
			view.setContent("success");
		}catch(Exception ex){
			view.setContent("faild");
			ex.printStackTrace();
		}
		return new ModelAndView(view);
	}
	
	/**
	 * 根据上级菜单获取层级信息
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getLayerInfo")
	public ModelAndView getLayerInfo(HttpServletRequest request,Long id){
		StringView view = new StringView();
		Menu menu = (Menu) menuService.findById(id,Menu.class);
		List<Menu> allList = menuService.findAll();
		menu.setSubMenuList(menuService.getSubMenuListByPMenu(menu,allList));
		int maxOrderNum = 0;
		for (int i = 0 ; i < menu.getSubMenuList().size(); i++){
			Menu m = menu.getSubMenuList().get(i);
			if(i == 0) maxOrderNum = m.getOrderNum();
			if(m.getOrderNum() > maxOrderNum){
				maxOrderNum = m.getOrderNum();
			}
		}
		String result =  maxOrderNum + "," + menu.getMenuLevel();
		view.setContent(result);
		return new ModelAndView(view);
	}

	
}
