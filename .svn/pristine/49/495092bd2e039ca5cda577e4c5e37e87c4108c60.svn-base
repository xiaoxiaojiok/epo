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
 * 阶层数据库
 * </pre>
 * @author LiuYongbin
 * @version 1.0, 2014-2-26
 */
@Entity
@Table(name = "epo_education", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_Education", sequenceName = "gzgb_Education_seq", allocationSize = 1)
public class Education extends BaseEntity{
	
	private static final long serialVersionUID = 995239090418631655L;

	/**
	 * 自增id
	 */
	private Long id;
	
	/**
	 * 媒体名称
	 */
	private String name;

	/**
	 * @return id 
	 * @see com.gzgb.epo.entity.Education#id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_Education")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	/**
	 * @param id id
	 * @see com.gzgb.epo.entity.Education#id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return name 
	 * @see com.gzgb.epo.entity.Education#name
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}

	/**
	 * @param name name
	 * @see com.gzgb.epo.entity.Education#name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
