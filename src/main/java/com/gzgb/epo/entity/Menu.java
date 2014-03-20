package com.gzgb.epo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.gzgb.epo.publics.Constants;

/**
 * 
 * <pre>
 * 菜单实体
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-14
 */
@Entity
@Table(name = "menu", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_menu", sequenceName = "gzgb_menu_seq", allocationSize = 1)
public class Menu extends BaseEntity{
	
	private static final long serialVersionUID = 995235545427631654L;
	
	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 菜单的级别(一级菜单：1，二级菜单：2，依此类推)
	 */
	private int menuLevel;
	
	
	/**
	 * 菜单的名称
	 */
	private String menuName;
	
	/**
	 * 菜单的链接地址
	 */
	private String menuUrl;
	
	/**
	 * 菜单的排序（所在级别的排序）
	 */
	private int orderNum;
	
	/**
	 * 上级菜单
	 */
	private Menu menu;
	
	/**
	 * 菜单的状态（0：停用。1：启用（默认值）,系统实现中采用菜单的停用而不是删除）
	 */
	private int status;
	
	/**
	 * 菜单创建者
	 */
	private User creater;
	
	/**
	 * 临时存储容器，存储当前菜单的下一级别子菜单
	 */
	private List<Menu> subMenuList = new ArrayList<Menu>();
	
	/**
	 * 临时属性,判断是否存在下一级别(子菜单) 存在:1    不存在:0;
	 */
	private int hasNext;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_menu")
	@Column(name = "menuId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "menuLevel",nullable = true, columnDefinition="INTEGER default 1")
	public int getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}

	@Column(name = "menuName",length=50 ,nullable=false)
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "menuUrl",nullable=true)
	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	@Column(name = "orderNum")
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="upmenuId")
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Column(name="status",nullable = true,columnDefinition="INTEGER default 1")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="createrId")
	public User getCreater() {
		return creater;
	}

	public void setCreater(User creater) {
		this.creater = creater;
	}

	@Transient
	public List<Menu> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<Menu> subMenuList) {
		this.subMenuList = subMenuList;
	}

	@Transient
	public int getHasNext() {
		return hasNext;
	}

	public void setHasNext(int hasNext) {
		this.hasNext = hasNext;
	}
	

}
