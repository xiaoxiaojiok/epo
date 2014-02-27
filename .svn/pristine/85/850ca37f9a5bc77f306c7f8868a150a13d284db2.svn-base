package com.gzgb.epo.entity;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.gzgb.epo.publics.Constants;

/**
 * 
 * <pre>
 * 印象关键词Entity
 * </pre>
 * @author LiuYongbin
 * @version 1.0, 2014-2-26
 */
@Entity
@Table(name="epo_keywords", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_keywords", sequenceName = "gzgb_keywords_seq", allocationSize = 1)
public class KeyWords extends BaseEntity{
	
	private static final long serialVersionUID = 994444666627631654L;
	
	/**
	 * 自增的id
	 */
	private Long id;
	
	/**
	 * 关键词名字
	 */
	private String name;
	
	/**
	 * 词频
	 */
	private Long count;

	/**
	 * @return id 
	 * @see com.gzgb.epo.entity.KeyWords#id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_keywords")
	public Long getId() {
		return id;
	}

	/**
	 * @param id id
	 * @see com.gzgb.epo.entity.KeyWords#id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return name 
	 * @see com.gzgb.epo.entity.KeyWords#name
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}

	/**
	 * @param name name
	 * @see com.gzgb.epo.entity.KeyWords#name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return count 
	 * @see com.gzgb.epo.entity.KeyWords#count
	 */
	@Column(name="count")
	public Long getCount() {
		return count;
	}

	/**
	 * @param count count
	 * @see com.gzgb.epo.entity.KeyWords#count
	 */
	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
