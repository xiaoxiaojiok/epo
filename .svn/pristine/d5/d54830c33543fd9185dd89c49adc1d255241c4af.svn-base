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
 * 部门实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-29
 */
@Entity
@Table(name = "epo_departmentbaseinfo", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_departmentbaseinfo", sequenceName = "gzgb_departmentbaseinfo_seq", allocationSize = 1)
public class DepartmentBaseInfo extends BaseEntity {
	
	
	private static final long serialVersionUID = 985232145427634455L;

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 部门名称
	 */
	private String dbiName;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_departmentbaseinfo")
	@Column(name = "dbiId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "dbiName",nullable=false)
	public String getDbiName() {
		return dbiName;
	}

	public void setDbiName(String dbiName) {
		this.dbiName = dbiName;
	}
	
}
