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
 * 
 * <pre>
 * 每日敏感信息量实体类
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-1
 */
@Entity
@Table(name = "epo_judgedsensitiveday", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_judgedsensitiveday", sequenceName = "gzgb_judgedsensitiveday_seq", allocationSize = 1)
public class SensitiveDay extends BaseEntity {

	private static final long serialVersionUID = 995235545418631655L;

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 敏感舆情总量
	 */
	private Integer jsdTotal;
	
	/**
	 * 敏感微博舆情量
	 */
	private Integer jsdWeibo;
	
	/**
	 * 敏感论坛舆情量
	 */
	private Integer jsdForum;
	
	/**
	 * 敏感新闻舆情量
	 */
	private Integer jsdNews;
	
	/**
	 * 敏感评论舆情量
	 */
	private Integer jsdComment;
	
	/**
	 * 敏感博客舆情量
	 */
	private Integer jsdBlog;
	
	/**
	 * 日期
	 */
	private Date jsdDate;
	
	/**
	 * 更新日期
	 */
	private Integer jsdUpdateTime;
	
	/**
	 * 创建日期
	 */
	private Integer jsdCreateTime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_judgedsensitiveday")
	@Column(name = "jsdId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "jsdTotal", nullable = false)
	public Integer getJsdTotal() {
		return jsdTotal;
	}

	public void setJsdTotal(Integer jsdTotal) {
		this.jsdTotal = jsdTotal;
	}

	@Column(name = "jsdWeibo", nullable = false)
	public Integer getJsdWeibo() {
		return jsdWeibo;
	}

	public void setJsdWeibo(Integer jsdWeibo) {
		this.jsdWeibo = jsdWeibo;
	}

	@Column(name = "jsdForum", nullable = false)
	public Integer getJsdForum() {
		return jsdForum;
	}

	public void setJsdForum(Integer jsdForum) {
		this.jsdForum = jsdForum;
	}

	@Column(name = "jsdNews", nullable = false)
	public Integer getJsdNews() {
		return jsdNews;
	}

	public void setJsdNews(Integer jsdNews) {
		this.jsdNews = jsdNews;
	}

	@Column(name = "jsdComment", nullable = false)
	public Integer getJsdComment() {
		return jsdComment;
	}

	public void setJsdComment(Integer jsdComment) {
		this.jsdComment = jsdComment;
	}

	@Column(name = "jsdBlog", nullable = false)
	public Integer getJsdBlog() {
		return jsdBlog;
	}

	public void setJsdBlog(Integer jsdBlog) {
		this.jsdBlog = jsdBlog;
	}

	@Column(name = "jsdDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getJsdDate() {
		return jsdDate;
	}

	public void setJsdDate(Date jsdDate) {
		this.jsdDate = jsdDate;
	}

	@Column(name = "jsdUpdateTime", nullable = false)
	public Integer getJsdUpdateTime() {
		return jsdUpdateTime;
	}

	public void setJsdUpdateTime(Integer jsdUpdateTime) {
		this.jsdUpdateTime = jsdUpdateTime;
	}

	@Column(name = "jsdCreateTime", nullable = false)
	public Integer getJsdCreateTime() {
		return jsdCreateTime;
	}

	public void setJsdCreateTime(Integer jsdCreateTime) {
		this.jsdCreateTime = jsdCreateTime;
	}
	

}
