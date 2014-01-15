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
 * 热点话题实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-28
 */
@Entity
@Table(name = "hotspots", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_hotspots", sequenceName = "gzgb_hotspots_seq", allocationSize = 1)
public class HotSpot extends BaseEntity {
	
	private static final long serialVersionUID = 985235545427631155L;

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 热点开始时间
	 */
	private Date startTime;
	
	/**
	 * 热点结束时间
	 */
	private Date endTime;
	
	/**
	 * 对应话题
	 */
	private Topic topic;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_hotspots")
	@Column(name = "hotspot_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "starttime")
	@Temporal(TemporalType.DATE)
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name = "endtime")
	@Temporal(TemporalType.DATE)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topics_id",nullable = false)
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	

}
