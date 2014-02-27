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
 * 主流媒体关注度
 * </pre>
 * @author LiuYongbin
 * @version 1.0, 2014-2-26
 */
@Entity
@Table(name="epo_mainmediaattention", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_mainmediaAttention", sequenceName = "gzgb_mainmediaAttention_seq", allocationSize = 1)
public class MainmediaAttention extends BaseEntity{

	private static final long serialVersionUID = 994333688827631654L;
	
	/**
	 * 自增id
	 */
	private Long id;
	
	/**
	 * 媒体名称
	 */
	private String name;
	
	/**
	 * 情感类型
	 */
	private String type;
	
	/**
	 * 数量
	 */
	private Long count;

	/**
	 * @return id 
	 * @see com.gzgb.epo.entity.MainmediaAttention#id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_mainmediaAttention")
	public Long getId() {
		return id;
	}

	/**
	 * @param id id
	 * @see com.gzgb.epo.entity.MainmediaAttention#id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return name 
	 * @see com.gzgb.epo.entity.MainmediaAttention#name
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}

	/**
	 * @param name name
	 * @see com.gzgb.epo.entity.MainmediaAttention#name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return type 
	 * @see com.gzgb.epo.entity.MainmediaAttention#type
	 */
	@Column(name="type")
	public String getType() {
		return type;
	}

	/**
	 * @param type type
	 * @see com.gzgb.epo.entity.MainmediaAttention#type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return count 
	 * @see com.gzgb.epo.entity.MainmediaAttention#count
	 */
	@Column(name="count")
	public Long getCount() {
		return count;
	}

	/**
	 * @param count count
	 * @see com.gzgb.epo.entity.MainmediaAttention#count
	 */
	public void setCount(Long count) {
		this.count = count;
	}
	
	
	
}
