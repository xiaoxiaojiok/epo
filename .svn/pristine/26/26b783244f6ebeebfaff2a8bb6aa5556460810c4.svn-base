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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;
import org.springside.modules.utils.Collections3;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gzgb.epo.publics.Constants;

/**
 * 
 * <pre>
 * 角色实体
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-14
 */
@Entity
@Table(name = "role", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_role", sequenceName = "gzgb_role_seq", allocationSize = 1)
public class Role extends BaseEntity{

	private static final long serialVersionUID = 995235545427631654L;
	
	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 角色名称
	 */
	@NotEmpty
	private String name;
	
	/**
	 * 角色描述
	 */
	private String description;
	
	/**
	 * 角色状态(-1、停用, 1、启用)
	 */
	private int status;

	/**
	 * 权限集合
	 */
	@JsonBackReference 
	private List<Permission> permissionList;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_role")
	@Column(name = "roleId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name",nullable=false,length=200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "status",columnDefinition = "INTEGER default 1")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	// 多对多定义
	@ManyToMany(targetEntity=Permission.class,cascade = { CascadeType.PERSIST,CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "permission_role" ,schema=Constants.GZGB_SCH, joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = { @JoinColumn(name = "perm_id") })
	// Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	// 集合按id排序
	@OrderBy("id ASC")
	// 缓存策略
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	
	/**
	 * <pre>
	 * 取得角色的权限名
	 * </pre>
	 * @return
	 */
	@Transient
	@JsonIgnore
	public String getPermissionNames() {
		return Collections3.extractToString(permissionList, "permName", ", ");
	}
	
	/**
	 * <pre>
	 * 取得角色的权限值
	 * </pre>
	 * @return
	 */
	@Transient
	@JsonIgnore
	public String getPermissionValues(){
		return Collections3.extractToString(permissionList, "permValue", ", ");
	}
	
	/**
	 * <pre>
	 * 取得角色权限值集合
	 * </pre>r
	 * @return List<String>
	 */
	@SuppressWarnings("unchecked")
	@Transient
	@JsonIgnore
	public List<String> getPermissions(){
		return Collections3.extractToList(permissionList, "permValue");
	}
	
	
	
}
