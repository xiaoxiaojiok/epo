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
 * 词性实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-29
 */
@Entity
@Table(name = "epo_knowledgedictquality", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_knowledgedictquality", sequenceName = "gzgb_knowledgedictquality_seq", allocationSize = 1)
public class KnowledgeDictQuality extends BaseEntity {
	
	private static final long serialVersionUID = 985235545427634455L;

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 词性标志
	 */
	private String kdqMark;
	
	/**
	 * 词性名称
	 */
	private String kdqName;
	
	/**
	 * 词性描述
	 */
	private String kdqDescription;
	
	/**
	 * 词性排序
	 */
	private Integer kdqOrder;
	
	/**
	 * 创建时间
	 */
	private Integer kdqCreateTime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_knowledgedictquality")
	@Column(name = "kdqId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "kdqMark", nullable = true)
	public String getKdqMark() {
		return kdqMark;
	}

	public void setKdqMark(String kdqMark) {
		this.kdqMark = kdqMark;
	}

	@Column(name = "kdqName", nullable = false)
	public String getKdqName() {
		return kdqName;
	}

	public void setKdqName(String kdqName) {
		this.kdqName = kdqName;
	}

	@Column(name = "kdqDescription", nullable = true,length=2048)
	public String getKdqDescription() {
		return kdqDescription;
	}

	public void setKdqDescription(String kdqDescription) {
		this.kdqDescription = kdqDescription;
	}

	@Column(name = "kdqOrder", nullable = false, columnDefinition = "INTEGER default 0")
	public Integer getKdqOrder() {
		return kdqOrder;
	}

	public void setKdqOrder(Integer kdqOrder) {
		this.kdqOrder = kdqOrder;
	}

	@Column(name = "kdqCreateTime", nullable = false, columnDefinition = "INTEGER default 0")
	public Integer getKdqCreateTime() {
		return kdqCreateTime;
	}

	public void setKdqCreateTime(Integer kdqCreateTime) {
		this.kdqCreateTime = kdqCreateTime;
	}
	

}
