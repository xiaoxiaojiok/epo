package com.gzgb.epo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "epo_remarkrecord", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_remarkrecord", sequenceName = "gzgb_remarkrecord_seq", allocationSize = 1)
public class RemarkRecord extends BaseEntity {

	private static final long serialVersionUID = 995235599927631654L;

	/**
	 * 自增ID
	 */
	private Long id;

	/**
	 * 社交账号
	 */
	private String socialaccount;

	/**
	 * 言论名称
	 */
	
	private String remarkname;
	
	/**
	 * 言论类型
	 */
	private String type;

	/**
	 * 连接
	 */
	private String href;
	
	/**
	 * 时间
	 */
	private Integer time;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_remarkrecord")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return remarkname 
	 * @see com.gzgb.epo.entity.RemarkRecord#remarkname
	 */
	@Column(name="remarkname")
	public String getRemarkname() {
		return remarkname;
	}

	/**
	 * @param remarkname remarkname
	 * @see com.gzgb.epo.entity.RemarkRecord#remarkname
	 */
	public void setRemarkname(String remarkname) {
		this.remarkname = remarkname;
	}

	/**
	 * @return href 
	 * @see com.gzgb.epo.entity.RemarkRecord#href
	 */
	@Column(name="href")
	public String getHref() {
		return href;
	}

	/**
	 * @param href href
	 * @see com.gzgb.epo.entity.RemarkRecord#href
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * @return time 
	 * @see com.gzgb.epo.entity.RemarkRecord#time
	 */
	@Column(name="time")
	public Integer getTime() {
		return time;
	}
	
	/**
	 * @param time time
	 * @see com.gzgb.epo.entity.RemarkRecord#time
	 */
	public void setTime(Integer time) {
		this.time = time;
	}


	/**
	 * @return socialaccount 
	 * @see com.gzgb.epo.entity.RemarkRecord#socialaccount
	 */
	@Column(name="socialaccount")
	public String getSocialaccount() {
		return socialaccount;
	}

	/**
	 * @param socialaccount socialaccount
	 * @see com.gzgb.epo.entity.RemarkRecord#socialaccount
	 */
	public void setSocialaccount(String socialaccount) {
		this.socialaccount = socialaccount;
	}

	/**
	 * @return type 
	 * @see com.gzgb.epo.entity.RemarkRecord#type
	 */
	@Column(name="type")
	public String getType() {
		return type;
	}

	/**
	 * @param type type
	 * @see com.gzgb.epo.entity.RemarkRecord#type
	 */
	public void setType(String type) {
		this.type = type;
	}

	
	
	
}
