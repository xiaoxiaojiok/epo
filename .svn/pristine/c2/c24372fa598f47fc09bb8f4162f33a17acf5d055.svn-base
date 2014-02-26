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
 * 舆论领袖影响分布
 * </pre>
 * 
 * @author LiuYongbin
 * @version 1.0, 2014-2-14
 */
@Entity
@Table(name = "epo_countchange", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_countchange", sequenceName = "gzgb_countchange_seq", allocationSize = 1)
public class MessageCountChange extends BaseEntity {

	private static final long serialVersionUID = 996785545427631654L;

	/**
	 * 自增ID
	 */
	private Long id;

	/**
	 * 社交账号
	 */
	private String socialaccount;

	/**
	 * 发布或转载
	 */
	
	private String type;
		
	/**
	 * 连接
	 */
	private Long count;
	
	/**
	 * 时间
	 */
	private String time;

	/**
	 * @return id 
	 * @see com.gzgb.epo.entity.MessageCountChange#id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_countchange")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	/**
	 * @param id id
	 * @see com.gzgb.epo.entity.MessageCountChange#id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return socialaccount 
	 * @see com.gzgb.epo.entity.MessageCountChange#socialaccount
	 */
	@Column(name="socialaccount")
	public String getSocialaccount() {
		return socialaccount;
	}

	/**
	 * @param socialaccount socialaccount
	 * @see com.gzgb.epo.entity.MessageCountChange#socialaccount
	 */
	public void setSocialaccount(String socialaccount) {
		this.socialaccount = socialaccount;
	}

	/**
	 * @return type 
	 * @see com.gzgb.epo.entity.MessageCountChange#type
	 */
	@Column(name="type")
	public String getType() {
		return type;
	}

	/**
	 * @param type type
	 * @see com.gzgb.epo.entity.MessageCountChange#type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return count 
	 * @see com.gzgb.epo.entity.MessageCountChange#count
	 */
	@Column(name="count")
	public Long getCount() {
		return count;
	}

	/**
	 * @param count count
	 * @see com.gzgb.epo.entity.MessageCountChange#count
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * @return time 
	 * @see com.gzgb.epo.entity.MessageCountChange#time
	 */
	@Column(name="time")
	public String getTime() {
		return time;
	}

	/**
	 * @param time time
	 * @see com.gzgb.epo.entity.MessageCountChange#time
	 */
	public void setTime(String time) {
		this.time = time;
	}

	
}
