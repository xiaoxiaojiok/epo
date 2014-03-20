package com.gzgb.epo.service.shiro;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.gzgb.epo.entity.Role;
import com.gzgb.epo.entity.User;
import com.gzgb.epo.service.menu.MenuService;
import com.gzgb.epo.service.role.RoleService;
import com.gzgb.epo.service.user.UserService;
import com.gzgb.epo.util.DateUtil;
import com.gzgb.epo.util.Encrypt;
import com.mysql.jdbc.log.Log;

/**
 * 
 * <pre>
 * 自定义用户权限查询
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-3-15
 */
public class ShiroDbRealm extends AuthorizingRealm
{
	
	private UserService userService;
	private RoleService roleService;
	private MenuService menuService;

	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	/**
	 * 认证回调函数, 登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException
	{
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userService.findUserByLoginName(token.getUsername().trim());
		if (user == null){
			return null;
		}else{

			List<Role> rlist = user.getRoleList();
			List<Long> menuids = menuService.getMenuIdsByCurrUser(user);
			return new SimpleAuthenticationInfo(new ShiroUser(user.getLoginName(), user.getPassword(), user.getId(),
					rlist,  user.getUsername(),menuids,(int)user.getUserType()), user.getPassword(), getName());
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
	{
		ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName()).iterator().next();
		User user = userService.findUserByLoginName(shiroUser.getLoginName());
		if (user != null)
		{
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for (Role role : user.getRoleList())
			{
				// 基于Role的权限信息
				info.addRole(role.getName());
				// 基于Permission的权限信息
				info.addStringPermissions(role.getPermissions());
			}
			return info;
		}else{
			return null;
		}
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal)
	{
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		principals.getRealmNames();
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo()
	{
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null)
		{
			for (Object key : cache.keys())
			{
				cache.remove(key);
			}
		}
	}

	public ShiroUser getShiroUser()
	{
		return new ShiroUser();
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public class ShiroUser implements Serializable,HttpSessionBindingListener{

		private static final long serialVersionUID = -1748602382963711884L;

		private String loginName;

		private String password;

		private Long id;

		private List<Role> rolelist;

		private String realName; // 真实名字
		
		private Integer userType;
		
		private List<Long> menuIds;

		public ShiroUser(){}

		public ShiroUser(String loginName, String password, long id, List<Role> rolelist, String realName,List<Long> menuIds,Integer userType)
		{
			this.loginName = loginName;
			this.password = password;
			this.id = id;
			this.rolelist = rolelist;
			this.realName = realName;
			this.menuIds = menuIds;
			this.userType = userType;
		}

		public String getLoginName() {
			return loginName;
		}

		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public List<Role> getRolelist() {
			return rolelist;
		}

		public void setRolelist(List<Role> rolelist) {
			this.rolelist = rolelist;
		}

		public String getRealName() {
			return realName;
		}

		public void setRealName(String realName) {
			this.realName = realName;
		}

		public Integer getUserType() {
			return userType;
		}

		public void setUserType(Integer userType) {
			this.userType = userType;
		}

		public List<Long> getMenuIds() {
			return menuIds;
		}

		public void setMenuIds(List<Long> menuIds) {
			this.menuIds = menuIds;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString()
		{
			return loginName;
		}



		public void valueBound(HttpSessionBindingEvent event)
		{

		}

		public void valueUnbound(HttpSessionBindingEvent event)
		{
			
		}
	}
	
	/**
	 * 
	 * <pre>
	 * 扩展用户登陆鉴权验证，针对数据库用户密码加密的问题
	 * </pre>
	 */
	public class CustomCredentialsMatcher extends HashedCredentialsMatcher {
	    @Override
	    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
	        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
	        Object tokenCredentials = Encrypt.MD5((String.valueOf(token.getPassword())));
	        Object accountCredentials = getCredentials(info);
	        //将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
	        return equals(tokenCredentials, accountCredentials);
	    }
	}

}
