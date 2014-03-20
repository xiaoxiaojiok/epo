package com.gzgb.epo.controller.role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gzgb.epo.entity.Menu;
import com.gzgb.epo.entity.Permission;
import com.gzgb.epo.entity.Role;
import com.gzgb.epo.publics.StringView;
import com.gzgb.epo.service.menu.MenuService;
import com.gzgb.epo.service.permission.PermissionService;
import com.gzgb.epo.service.role.RoleService;
import com.gzgb.epo.service.shiro.ShiroDbRealm;
import com.gzgb.epo.service.shiro.ShiroDbRealm.ShiroUser;
import com.gzgb.epo.service.user.UserService;

/**
 * <pre>
 * 角色管理controller
 * 授权信息: role:view 角色查询，role:add 角色添加，role:save 角色保存，role:delete 角色删除
 * </pre>
 * @author 肖坚
 * @version 1.0, 2014-3-16
 * 
 * Urls:
 * List   page        : GET/POST  /role/list/{pages}
 * Create page        : GET  /role/create
 * Create action      : POST /role/save
 * Update page        : GET  /role/update/{id}
 * Update action      : POST /role/save/{id}
 * Delete action      : POST /role/delete
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController
{
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private PermissionListEditor permissionListEditor;
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShiroDbRealm shiroDbRealm;
	
	@Autowired
	private MenuService menuService;
	
	@RequiresPermissions("role:view")
	@RequestMapping(value = "/index/{pMenuId}")
	public String index(@PathVariable Long pMenuId,Integer rows,Integer page,HttpServletRequest request, String roleName, Model model)
	{
		menuService.getLeftMenu(pMenuId,model);
		return "role/index";
	}
	
	@RequiresPermissions("role:view")
	@RequestMapping(value = "/list")
	@ResponseBody
	public Map<String,Object> list(Integer page,Integer rows,String sort, String order,HttpServletRequest request, String roleName, Model model)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, String> mapString = new HashMap<String, String>();
		if(roleName!=null){
			mapString.put("name", roleName);
		}
		map = roleService.getAll(Role.class, mapString, null, null, null, page, rows, sort, order);
		return map;
	}
	
	/**
	 * <pre>
	 * 添加
	 * </pre>
	 * @param model
	 * @return
	 */
	@RequiresPermissions("role:add")
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String add(Model model)
	{
		Menu menu = menuService.findByMenuName("角色管理");
		menuService.getLeftMenu(menu.getId(),model);
		model.addAttribute("role", new Role());
		return "role/edit";
	}
	
	/**
	 * <pre>
	 * 保存角色
	 * </pre>
	 * @param role
	 * @param result
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("role:save")
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView save(@Valid Role role,BindingResult result, RedirectAttributes redirectAttributes)
	{
		StringView view = new StringView();
		if(result.hasErrors())
		{
			view.setContent("faild");
			return new ModelAndView(view);
		}
		else
		{
			try{
				if(role.getId()==null){
					roleService.save(role);
				}else{
					roleService.update(role);
				}
//				redirectAttributes.addFlashAttribute("message", "保存角色" + role.getName() + "成功");
				view.setContent("success");
			}catch(Exception ex){
				view.setContent("faild");
				ex.printStackTrace();
			}
//			return "redirect:/role/list";
			return new ModelAndView(view);
		}
	}
	
	/**
	 * <pre>
	 * 批量删除
	 * </pre>
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("role:delete")
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public boolean delete(String ids)
	{
		boolean success = false;
		if(StringUtils.isNotEmpty(ids.trim()))
		{
			String[] roleids = ids.split(",");
			for(String id : roleids)
			{
				Role role = (Role) this.roleService.findById(Long.parseLong(id), Role.class);
				roleService.delete(role);
			}
			success=true;
		}
		return success;
	}
	
	/**
	 * <pre>
	 * 保存授权
	 * </pre>
	 * @param role
	 * @return
	 */
	@RequiresPermissions("role:permission")
	@RequestMapping(value = "menu/save",method=RequestMethod.POST)
	public String accreditRole(Role role,Long menuId,RedirectAttributes redirectAttributes)
	{
		Role r = (Role) roleService.findById(role.getId(), Role.class);
		List<Permission> rolePermList = permissionService.getPermissionByRoleId(role.getId());
		if(role.getPermissionList()== null ){
			//原来有权限现在没有了。
			if(rolePermList !=null && rolePermList.size()>0){
				r.getPermissionList().removeAll(rolePermList);
			}
		}else{
			//当原来的权限为空，且现在有授权时
			if(rolePermList==null || rolePermList.size()==0){
				r.getPermissionList().addAll(role.getPermissionList());
			}else{
				//过滤权限添加
				for(Permission p : role.getPermissionList()){
					if(!rolePermList.contains(p)){
						r.getPermissionList().add(p);
					}
				}
			   //过滤权限删除
				for(Permission p : rolePermList)
				{
					if(!role.getPermissionList().contains(p))
					{
						r.getPermissionList().remove(p);
					}
				}
			}
		}
		roleService.update(r);
		shiroDbRealm.clearAllCachedAuthorizationInfo();
		redirectAttributes.addFlashAttribute("message", "授权给" + r.getName() + "成功");
		return "redirect:/role/accredit/"+role.getId();
	}
	@InitBinder
	public void initBinder(WebDataBinder b) {
		b.registerCustomEditor(List.class, "permissionList", permissionListEditor);
	}
}
