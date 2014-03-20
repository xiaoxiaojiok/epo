package com.gzgb.epo.entity;

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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.gzgb.epo.publics.Constants;

/**
 * 
 * <pre>
 * 主流媒体数据库
 * </pre>
 * 
 * @author LiuYongbin
 * @version 1.0, 2014-2-26
 */
@Entity
@Table(name = "epo_cityregionlist", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_cityregionlist", sequenceName = "gzgb_cityregionlist_seq", allocationSize = 1)
public class CityRegion extends BaseEntity {

	private static final long serialVersionUID = 995111165418631655L;

	/**
	 * 自增id
	 */
	private Long id;
	
	/**
	 * 父id
	 */
	private CityRegion parentid;

	/**
	 * 地区名称
	 */
	private String name;
	
	/**
	 * 地区级别
	 */
	private int level;

	/**
	 * @return id
	 * @see com.gzgb.epo.entity./**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_cityregionlist")
	@Column(name = "crlId")
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            id
	 * @see com.gzgb.epo.entity.Mainmedia#id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return name
	 * @see com.gzgb.epo.entity.Mainmedia#name
	 */
	@Column(name = "crlName", nullable = false, length = 120)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            name
	 * @see com.gzgb.epo.entity.Mainmedia#name
	 */
	public void setName(String name) {
		this.name = name;
	}
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "crlParentId", nullable = false)
	public CityRegion getParentid() {
		return parentid;
	}

	public void setParentid(CityRegion parentid) {
		this.parentid = parentid;
	}

	@Column(name = "crlLevel", nullable = false)
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	

}
