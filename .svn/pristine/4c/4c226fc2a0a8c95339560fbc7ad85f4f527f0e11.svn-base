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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.gzgb.epo.publics.Constants;

/**
 * 
 * <pre>
 * 新闻实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-28
 */
@Entity
@Table(name = "reports", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_reports", sequenceName = "gzgb_reports_seq", allocationSize = 1)
public class Report extends BaseEntity {

	private static final long serialVersionUID = 985235445427631655L;

	/**
	 * 自增ID
	 */
	private Long id;

	/**
	 * 新闻标题
	 */
	private String title;

	/**
	 * 新闻链接
	 */
	private String url;

	/**
	 * 新闻发布时间
	 */
	private Date pubDate;

	/**
	 * 新闻词频
	 */
	private String tf;

	/**
	 * 新闻关键字
	 */
	private String keywords;

	/**
	 * 新闻转载数
	 */
	private Integer reprinted;

	/**
	 * 新闻评论数
	 */
	private Integer comments;

	/**
	 * 媒体名称
	 */
	private String medianame;

	/**
	 * 所属话题
	 */
	private Topic topic;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_reports")
	@Column(name = "report_id")
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

	@Column(name = "url", nullable = true)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "time", nullable = false)
	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	@Column(name = "tf", nullable = false, length = 10000)
	public String getTf() {
		return tf;
	}

	public void setTf(String tf) {
		this.tf = tf;
	}

	@Column(name = "keywords", nullable = false)
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "reprinted")
	public Integer getReprinted() {
		return reprinted;
	}

	public void setReprinted(Integer reprinted) {
		this.reprinted = reprinted;
	}

	@Column(name = "comments")
	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	@Column(name = "medianame")
	public String getMedianame() {
		return medianame;
	}

	public void setMedianame(String medianame) {
		this.medianame = medianame;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topic_id")
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
