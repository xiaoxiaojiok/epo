package com.gzgb.epo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.gzgb.epo.publics.Constants;

/**
 * 
 * <pre>
 * 区县实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-29
 */
@Entity
@Table(name = "epo_regionbaseinfo", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_regionbaseinfo", sequenceName = "gzgb_regionbaseinfo_seq", allocationSize = 1)
public class RegionBaseInfo extends BaseEntity {
	
	
	private static final long serialVersionUID = 985235541117634455L;

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 区县名称
	 */
	private String rbiName;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_regionbaseinfo")
	@Column(name = "rbiId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "rbiName",nullable=false)
	public String getRbiName() {
		return rbiName;
	}

	public void setRbiName(String rbiName) {
		this.rbiName = rbiName;
	}

}
