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
 * <pre>
 * 评论实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-28
 */
@Entity
@Table(name = "comments", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_comments", sequenceName = "gzgb_comments_seq", allocationSize = 1)
public class Comment  extends BaseEntity {

	private static final long serialVersionUID = 985235545427631611L;

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 评论词频
	 */
	private String tf;
	
	/**
	 * 评论时间 
	 */
	private Date date;
	
	/**
	 * 评论者
	 */
	private User user;
	
	/**
	 * 评论者IP
	 */
	private String IP;
	
	/**
	 * 报道ID
	 */
	private Report report;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_comments")
	@Column(name = "comment_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "tf", nullable = false, length = 10000)
	public String getTf() {
		return tf;
	}

	public void setTf(String tf) {
		this.tf = tf;
	}

	@Column(name = "date", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "ip")
	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "report_id")
	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
	
}
