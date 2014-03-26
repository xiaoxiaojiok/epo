package com.gzgb.epo.controller.mcode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gzgb.epo.entity.Mcode;
import com.gzgb.epo.entity.Menu;
import com.gzgb.epo.entity.NewsList;
import com.gzgb.epo.entity.User;
import com.gzgb.epo.publics.StringView;
import com.gzgb.epo.service.mcode.McodeService;
import com.gzgb.epo.service.menu.MenuService;
import com.gzgb.epo.service.shiro.ShiroDbRealm.ShiroUser;
import com.gzgb.epo.service.user.UserService;

/**
 * 码表管理控制器
 * <pre>
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-25
 */
@Controller
@RequestMapping(value="/mcode")
public class McodeController
{
	@Autowired
	private McodeService mcodeService;
	
	Logger log = LoggerFactory.getLogger(McodeController.class);
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * <pre>
	 * 码表管理首页
	 * </pre>
	 * @return
	 */
	@RequiresPermissions("mcode:view")
	@RequestMapping(value="/index/{pMenuId}")
	public String index(@PathVariable Long pMenuId,HttpServletRequest request, Model model){
		menuService.getLeftMenu(pMenuId,model);
		return "/mcode/index";
	}
	
	@RequiresPermissions("mcode:view")
	@RequestMapping(value="/index")
	public String index1(HttpServletRequest request, Model model){
		Menu menu = menuService.findByMenuName("码表管理");
		menuService.getLeftMenu(menu.getId(),model);
		return "/mcode/index";
	}
	
	@RequiresPermissions("mcode:view")
	@RequestMapping(value="/query")
	@ResponseBody
	public Map<String,Object> query(Integer page,Integer rows,String sort, String order,String mtype,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, String> mapString = new HashMap<String, String>();
		if(mtype!=null){
			mapString.put("mtype", mtype);
		}
		map = mcodeService.getAll(Mcode.class, mapString, null, null, null, page, rows, sort, order);
		if (map != null && !"".equals(map.get("rows").toString())) {
			List<Mcode> list = (List<Mcode>) map.get("rows");
			for (int i = 0; i < list.size(); i++) {
				Mcode mcode = list.get(i);
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd"); // 格式化日期
				mcode.setDate(f.format(mcode.getCreatdate()));

			}
		}
		return map;
	}
	
	/**
	 * 
	 * <pre>
	 * 进入编辑码表信息页面
	 * </pre>
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequiresPermissions("mcode:edit")
	@RequestMapping(value="/edit/{id}")
	public String query(@PathVariable Long id,Model model,HttpServletRequest request){
		Mcode mcode = null;
		if(id!=0l){
			mcode = this.mcodeService.findById(id, Mcode.class);
			model.addAttribute("mcode", mcode);
		}
		model.addAttribute("key", id==0l);
		Menu menu = menuService.findByMenuName("码表管理");
		menuService.getLeftMenu(menu.getId(),model);
		return "/mcode/edit";
	}
	
	/**
	 * 删除码表信息，支持多个码表信息勾选批量删除
	 * @param ids(格式："1,2,3")
	 * @return
	 */
	@RequiresPermissions("mcode:delete")
	@RequestMapping(value = "/delete")
	public ModelAndView delete(HttpServletRequest request,String ids){		
		StringView view = new StringView();
		if(StringUtils.isNotEmpty(ids)){			
			String[] arr= ids.split(",");
			try{				
				for(int i=0;i<arr.length;i++){
					long id=Long.parseLong(arr[i]);
					Mcode mcode = this.mcodeService.findById(id, Mcode.class);
					mcodeService.delete(mcode);
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
	 * 保存码表信息
	 * </pre>
	 * @param mcode
	 * @param request
	 * @return
	 */
	@RequiresPermissions("mcode:edit")
	@RequestMapping(value = "/save")
	public ModelAndView save(Mcode mcode,HttpServletRequest request){		
		StringView view = new StringView();
		try{
			if(mcode.getId()==null){
				mcode.setCreatdate(new Date());
				ShiroUser user = (ShiroUser)SecurityUtils.getSubject().getPrincipal();
				User u = userService.findById(user.getId(), User.class);
				mcode.setCreatedBy(u);
				this.mcodeService.save(mcode);
			}else{
				Mcode m = this.mcodeService.findById(mcode.getId(), Mcode.class);
				m.setDatelevel(mcode.getDatelevel());
				m.setMtype(mcode.getMtype());
				m.setMkey(mcode.getMkey());
				m.setMvalue(mcode.getMvalue());
				m.setRemark(mcode.getRemark());
				m.setOrderNum(mcode.getOrderNum());
				this.mcodeService.update(m);
			}
			view.setContent("success");
		}catch(Exception ex){
			log.error(ex.toString());
			view.setContent("faild");
		}
		return new ModelAndView(view);
	}

}
