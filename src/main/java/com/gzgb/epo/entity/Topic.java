package com.gzgb.epo.entity;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.gzgb.epo.publics.Constants;

/**
 * 
 * <pre>
 * 话题实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-28
 */
@Entity
@Table(name = "topics", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_topics", sequenceName = "gzgb_topics_seq", allocationSize = 1)
public class Topic extends BaseEntity {

	private static final long serialVersionUID = 985235545427637655L;

	/**
	 * 自增ID
	 */
	private Long id;

	/**
	 * 话题标题
	 */
	private String title;

	/**
	 * 话题创建时间
	 */
	private Date createDate;

	/**
	 * 话题关联新闻数量
	 */
	private Integer reports;

	/**
	 * 话题评论数量
	 */
	private Integer comments;

	/**
	 * 话题关键字
	 */
	private String keywords;

	/**
	 * 话题质心
	 */
	private String centroid;

	/**
	 * 话题级别
	 */
	private Integer level;

	/**
	 * 父话题
	 */
	private Topic father;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_topics")
	@Column(name = "topic_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "time", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "reports")
	public Integer getReports() {
		return reports;
	}

	public void setReports(Integer reports) {
		this.reports = reports;
	}

	@Column(name = "comments")
	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	@Column(name = "keywords", nullable = true)
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "centroid", nullable = false, length = 10000)
	public String getCentroid() {
		return centroid;
	}

	public void setCentroid(String centroid) {
		this.centroid = centroid;
	}

	@Column(name = "levels")
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "father")
	public Topic getFather() {
		return father;
	}

	public void setFather(Topic father) {
		this.father = father;
	}

}
