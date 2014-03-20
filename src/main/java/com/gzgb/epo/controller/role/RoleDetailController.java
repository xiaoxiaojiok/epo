package com.gzgb.epo.controller.role;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzgb.epo.entity.Menu;
import com.gzgb.epo.entity.Permission;
import com.gzgb.epo.entity.Role;
import com.gzgb.epo.publics.Constants;
import com.gzgb.epo.service.menu.MenuService;
import com.gzgb.epo.service.permission.PermissionService;
import com.gzgb.epo.service.role.RoleService;
import com.gzgb.epo.service.shiro.ShiroDbRealm.ShiroUser;

/**
 * <pre>
 * 角色管理
 *  使用@ModelAttribute, 实现Struts2 Preparable二次绑定的效果。 
 * 	因为@ModelAttribute被默认执行, 而其他的action url中并没有${id}，所以需要独立出一个Controller.
 * 授权信息: role:edit 编辑角色  role:permission 角色授权
 * </pre>
 * @author 肖坚
 * @version 1.0, 2014-3-16
 */
@Controller
@RequestMapping(value = "/role")
public class RoleDetailController
{
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private PermissionListEditor permissionListEditor;
	
//	@RequiresPermissions("role:edit")
	@RequestMapping(value = "update/{id}")
	public String update(@ModelAttribute("role") Role role,HttpServletRequest request,Model model,@PathVariable Long id)
	{
//		int currentIndex = Integer.parseInt(StringUtils.trimToEmpty(request.getParameter("currentIndex")));
//		model.addAttribute("currentIndex",currentIndex);
		Role role1 = roleService.findById(id, Role.class);
		model.addAttribute("role", role1);
		Menu menu = menuService.findByMenuName("角色管理");
		menuService.getLeftMenu(menu.getId(),model);
		return "role/edit";
	}
	
//	@RequiresPermissions("role:edit")
	@RequestMapping(value = "save/{id}",method=RequestMethod.POST)
	public String save(@Valid Role role,BindingResult result,HttpServletRequest request,Model model)
	{
		int currentIndex = Integer.parseInt(StringUtils.trimToEmpty(request.getParameter("currentIndex")));
		Menu menu = menuService.findByMenuName("角色管理");
		menuService.getLeftMenu(menu.getId(),model);
		if(result.hasErrors())
		{
			return "role/edit";
		}
		else
		{
			roleService.save(role);
			return "redirect:/role/list/"+currentIndex;
		}
	}
	
//	@RequiresPermissions("role:edit")
	@RequestMapping(value = "stop/{id}",method=RequestMethod.GET)
	@ResponseBody
	public boolean stopRole(@PathVariable("id") Long id)
	{
		boolean success = true;
		roleService.updateRoleByStatus(Constants.ROLE_STOP_STATUS, id);
		return success;
	}
	
//	@RequiresPermissions("role:edit")
	@RequestMapping(value = "start/{id}",method=RequestMethod.GET)
	@ResponseBody
	public boolean startRole(@PathVariable("id") Long id)
	{
		boolean success = true;
		roleService.updateRoleByStatus(Constants.ROLE_START_STATUS, id);
		return success;
	}
	
	/**
	 * <pre>
	 * 授权
	 * </pre>
	 * @param id
	 * @return
	 */
//	@RequiresPermissions("role:permission")
	@RequestMapping(value = "accredit/{id}",method=RequestMethod.GET)
	public String accredit(@ModelAttribute("role") Role role,Model model)
	{
		List<Menu> list = menuService.getMenuListByLevel(1);
		String jValue = "[";
		jValue = menuService.getJsonStringForZTree(list,jValue);
		if(list.size() > 0){
			jValue = jValue.substring(0,jValue.length() - 1);
		}
		jValue += "]";
		//StringUtil.debug(jValue);
		
		model.addAttribute("jValue", jValue);
		model.addAttribute("role",role);
		Menu menu = menuService.findByMenuName("角色管理");
		menuService.getLeftMenu(menu.getId(),model);
		
		return "role/accredit";
	}
	/**
	 * <pre>
	 * 菜单授权页
	 * </pre>
	 * @param id
	 * @param roleid
	 * @param model
	 * @return
	 */
//	@RequiresPermissions("role:permission")
	@RequestMapping(value = "menu/crt/{id}")
	public String roleMenuAccredit(@PathVariable("id") Long id, Long menuId,Model model)
	{
//		Menu menu = menuService.findById(menuId);
		Role role = (Role) roleService.findById(id, Role.class);
		List<Menu> menuList = (List<Menu>) menuService.getMenuListByLevel(2);
		List<Permission> allPermList = this.permissionService.findAll(Permission.class);
		List<List<Permission>> permList = new ArrayList<List<Permission>>();
		for(Menu menu:menuList){
//			permList.add(null);
			List<Permission> plist =permissionService.getPermissionsByMenuAndPermLists(menu.getId(),allPermList);
			permList.add(plist);
			if(menu.getHasNext()==1){
				List<Menu> list  = menu.getSubMenuList();
				for(Menu m :list){
					List<Permission> plist1 =permissionService.getPermissionsByMenuAndPermLists(m.getId(),allPermList);
					permList.add(plist1);
				}
			}
		}
		model.addAttribute("menuList",menuList);
		model.addAttribute("permList",permList);
		model.addAttribute("role",role);
		return "role/accredited";
	}
	
	@ModelAttribute("role")
	public Role getRole(@PathVariable("id") Long id) {
		return (Role) roleService.findById(id, Role.class);
	}

	@InitBinder
	public void initBinder(WebDataBinder b) {
		b.registerCustomEditor(List.class, "permissionList", permissionListEditor);
	}
	

	
}