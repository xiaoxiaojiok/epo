package com.gzgb.epo.controller.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gzgb.epo.entity.Menu;
import com.gzgb.epo.entity.Permission;
import com.gzgb.epo.publics.StringView;
import com.gzgb.epo.service.menu.MenuService;
import com.gzgb.epo.service.permission.PermissionService;

/**
 * 
 * <pre>
 * 权限管理
 * </pre>
 * @author 肖坚
 * @version 1.0, 2014-3-17
 */
@Controller
@RequestMapping(value = "/permission")
public class PermissionController
{
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private MenuService menuService;
	Logger log = LoggerFactory.getLogger(PermissionController.class);
	
	/**
	 * 
	 * <pre>
	 * 查询权限列表
	 * </pre>
	 * @param pageNumber
	 * @param menuName
	 * @param model
	 * @return
	 */
	@RequiresPermissions("perm:view")
	@RequestMapping(value = "/index/{pMenuId}")
	public String list(@PathVariable Long pMenuId,Integer page,Integer rows,String menuName, Model model)
	{
		menuService.getLeftMenu(pMenuId,model);
		return "permission/list";
	}
	
	/**
	 * 
	 * <pre>
	 * 查询权限列表
	 * </pre>
	 * @param pageNumber
	 * @param menuName
	 * @param model
	 * @return
	 */
	@RequiresPermissions("perm:view")
	@RequestMapping(value = "/query")
	@ResponseBody
	public Map<String,Object> query(Integer page,Integer rows,String sort, String order,String menuName, Model model)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Long> mapLong = new HashMap<String, Long>();
		if(menuName!=null){
			Menu menu = menuService.findByMenuName(menuName);
			if(menu!=null){
				mapLong.put("menu.id", menu.getId());
			}
		}
		map = permissionService.getAll(Permission.class, null, null, null, mapLong, page, rows, sort, order);
		return map;
	}
	
	/**
	 * <pre>
	 * 添加页面
	 * </pre>
	 * @param model
	 * @return
	 */
	@RequiresPermissions("perm:edit")
	@RequestMapping(value="/edit/{id}")
	public String create(@PathVariable Long id,Model model)
	{
		Permission permission = null;
		if(id!=null && id!=0l){
			permission = this.permissionService.findById(id, Permission.class);
			model.addAttribute("permission", permission);
		}
//		List<Menu> list = (List<Menu>) menuService.findAll(Menu.class);
		List<Menu> list = (List<Menu>) menuService.findAll();
		model.addAttribute("mlist",list);
		Menu menu = menuService.findByMenuName("权限管理");
		menuService.getLeftMenu(menu.getId(),model);
		return "permission/edit";
	}
	/**
	 * <pre>
	 * 保存
	 * </pre>
	 * @param role
	 * @param result
	 * @return
	 */
	@RequiresPermissions("perm:edit")
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView  save(HttpServletRequest request,Permission permission,Long menuId)
	{
		StringView view=new StringView();
		try{
			Menu menu = this.menuService.findById(menuId);
			permission.setMenu(menu);
			if(permission.getId()==null){
				this.permissionService.save(permission);
			}else{
				Permission perm = this.permissionService.findById(permission.getId(), Permission.class);
				perm.setDescript(permission.getDescript());
				perm.setPermName(permission.getPermName());
				perm.setMenu(permission.getMenu());
				perm.setPermType(permission.getPermType());
				perm.setPermValue(permission.getPermValue());
				this.permissionService.update(perm);
			}
			view.setContent("success");
		}catch (Exception e) {
			view.setContent("faild");
		}
		return new ModelAndView(view);
	}
	
	/**
	 * <pre>
	 * 批量删除
	 * </pre>
	 * @param ids
	 * @return
	 */
	@RequiresPermissions("perm:delete")
	@RequestMapping(value = "/delete")
	public ModelAndView delete(HttpServletRequest request,String ids){		
		StringView view = new StringView();
		if(StringUtils.isNotEmpty(ids)){
			String[] arr= ids.split(",");
			try{
				for(int i=0;i<arr.length;i++){
					long id=Long.parseLong(arr[i]);
					Permission perm = this.permissionService.findById(id, Permission.class);
					this.permissionService.delete(perm);
				}
				view.setContent("success");	
			}catch (Exception e) {
				view.setContent("false");
			}
		}
		return new ModelAndView(view);
		
	}
	
	/**
	 * 
	 * <pre>
	 * 权限值的唯一判断
	 * </pre>
	 * @param request
	 * @param permValue
	 * @return
	 */
	@RequestMapping(value = "/checkValue")
	public ModelAndView checkPvalue(HttpServletRequest request,String permValue){
		StringView view = new StringView();
		List<Permission> plist = this.permissionService.getPermByPvalue(permValue);
		if(plist==null || plist.size()==0){
			view.setContent("true");
		}else{
			view.setContent("false");
		}
		return new ModelAndView(view);
	}
	
	
}
