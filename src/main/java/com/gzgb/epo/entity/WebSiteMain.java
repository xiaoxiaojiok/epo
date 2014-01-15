package com.gzgb.epo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.gzgb.epo.publics.Constants;

/**
 * <pre>
 * 站点管理实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Entity
@Table(name = "epo_websitemain", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_websitemain", sequenceName = "gzgb_websitemain_seq", allocationSize = 1)
public class WebSiteMain extends BaseEntity  {
	
	private static final long serialVersionUID = 995235545418631654L;

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 站点名称
	 */
	private String wsmName;
	
	/**
	 * 站点性质
	 */
	private Byte wsmProperty;
	
	/**
	 * 所在地区
	 */
	private Byte wsmRegion;
	
	/**
	 * 站点类别
	 */
	private Byte wsmClass;
	
	/**
	 * 首页地址
	 */
	private String wsmHome;
	
	/**
	 * 站点状态
	 */
	private Byte wsmStatus;
	
	/**
	 * 是否境外
	 */
	private Byte wsmIsAbroad;
	
	/**
	 * 更新时间
	 */
	private Date wsmUpdateTime;
	
	/**
	 * 创建时间
	 */
	private Date wsmCreateTime;
	
	/**
	 * 是否删除
	 */
	private Byte wsmDelete;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_websitemain")
	@Column(name = "wsmId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "wsmName", nullable = false)
	public String getWsmName() {
		return wsmName;
	}

	public void setWsmName(String wsmName) {
		this.wsmName = wsmName;
	}

	@Column(name = "wsmProperty", nullable = false)
	public Byte getWsmProperty() {
		return wsmProperty;
	}

	public void setWsmProperty(Byte wsmProperty) {
		this.wsmProperty = wsmProperty;
	}

	@Column(name = "wsmRegion", nullable = false)
	public Byte getWsmRegion() {
		return wsmRegion;
	}

	public void setWsmRegion(Byte wsmRegion) {
		this.wsmRegion = wsmRegion;
	}

	@Column(name = "wsmClass", nullable = false)
	public Byte getWsmClass() {
		return wsmClass;
	}

	public void setWsmClass(Byte wsmClass) {
		this.wsmClass = wsmClass;
	}

	@Column(name = "wsmHome", nullable = false)
	public String getWsmHome() {
		return wsmHome;
	}

	public void setWsmHome(String wsmHome) {
		this.wsmHome = wsmHome;
	}

	@Column(name = "wsmStatus", nullable = false)
	public Byte getWsmStatus() {
		return wsmStatus;
	}

	public void setWsmStatus(Byte wsmStatus) {
		this.wsmStatus = wsmStatus;
	}

	@Column(name = "wsmIsAbroad", nullable = false)
	public Byte getWsmIsAbroad() {
		return wsmIsAbroad;
	}

	public void setWsmIsAbroad(Byte wsmIsAbroad) {
		this.wsmIsAbroad = wsmIsAbroad;
	}

	@Column(name = "wsmUpdateTime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getWsmUpdateTime() {
		return wsmUpdateTime;
	}

	public void setWsmUpdateTime(Date wsmUpdateTime) {
		this.wsmUpdateTime = wsmUpdateTime;
	}

	@Column(name = "wsmCreateTime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getWsmCreateTime() {
		return wsmCreateTime;
	}

	public void setWsmCreateTime(Date wsmCreateTime) {
		this.wsmCreateTime = wsmCreateTime;
	}

	@Column(name = "wsmDelete", nullable = false)
	public Byte getWsmDelete() {
		return wsmDelete;
	}

	public void setWsmDelete(Byte wsmDelete) {
		this.wsmDelete = wsmDelete;
	}
	
}
