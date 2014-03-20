package com.gzgb.epo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gzgb.epo.publics.Constants;

/**
 * 
 * <pre>
 * 权限实体
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-14
 */
@Entity
@Table(name = "permission", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_permission", sequenceName = "gzgb_permission_seq", allocationSize = 1)
public class Permission extends BaseEntity{
	
	private static final long serialVersionUID = 995235545427631654L;
	
	/**
	 * 自增ID
	 */
	private Long id;

	/**
	 * 权限名
	 */
	@NotEmpty
	private String permName;
	
	/**
	 * 权限描述
	 */
	private String descript;
	
	/**
	 * 权限值
	 */
	@NotEmpty
	private String permValue;
	
	/**
	 * 权限类型(区分菜单权限 -1 与功能权限 1 )
	 */
	private Integer permType;
	
	/**
	 * 从属菜单
	 */
	@JsonBackReference
	private Menu menu;
	
	/**
	 * 临时权限名称
	 */
	private String permTypeName;
	
	/**
	 * 临时菜单名称
	 */
	private String menuName;

	/**
	 * 角色列表
	 */
	@JsonBackReference 
	public List<Role> roleList;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_permission")
	@Column(name = "permId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="permName")
	public String getPermName() {
		return permName;
	}

	public void setPermName(String permName) {
		this.permName = permName;
	}

	@Column(name="descript")
	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@Column(name="permValue")
	public String getPermValue() {
		return permValue;
	}

	public void setPermValue(String permValue) {
		this.permValue = permValue;
	}

	@Column(name="permType")
	public Integer getPermType() {
		return permType;
	}

	public void setPermType(Integer permType) {
		this.permType = permType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="menu")
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		final Permission p = (Permission)obj;
		
		if(this.getId() != p.getId())
		{
			return false;
		}
		return true;
	}

	@Transient
	public String getPermTypeName()
	{
		if(this.permType!=null ){
			String reName="";
			if(this.permType==-1){
				reName= "菜单权限";
			}else if(this.permType==1){
				reName= "功能权限";
			}
			return reName;
		}else{
			return "";
		}
	}

	public void setPermTypeName(String permTypeName)
	{
		this.permTypeName = permTypeName;
	}

	@Transient
	public String getMenuName()
	{
		if(this.menu!=null){
			return this.menu.getMenuName();
		}else{
			return "";
		}
	}

	public void setMenuName(String menuName)
	{
		this.menuName = menuName;
	}

	@ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "permissionList", fetch = FetchType.LAZY)
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	
}
