package com.gzgb.epo.entity;

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
 * 报道的焦点分布实体类
 * </pre>
 * @author LiuYongbin
 * @version 1.0, 2014-3-14
 */
@Entity
@Table(name = "epo_reportfocusdistribution", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_reportFocusDistribution", sequenceName = "gzgb_reportFocusDistribution_seq", allocationSize = 1)
public class ReportFocusDistribution extends BaseEntity{
	
	private static final long serialVersionUID = 994333000027631654L;

	/**
	 * 自增id
	 */
	private Long id;
	
	/**
	 * 区域所属Id
	 */
	private CityRegion cityRegionId;
	/**
	 * 报道的关注焦点
	 */
	private String name;

	/**
	 * 报道的关注焦点情感倾向：  1    代表喜欢	  2	代表中立 		3 ：代表讨厌
	 */
	private Integer focusEmotion;

	/**
	 * 报道的政治倾向         1    代表右倾  		2  代表中立 		3 ：代表左倾
	 */
	private Integer focusPolitical;
	
	/**
	 * 焦点的去权重
	 */
    private Float weigth;
    
    /**
     * 是否涉穂  默认为1
     * 1：表示涉穂		0：表示不涉穂
     */
    
    private Integer isAbout;
	/**
	 * 时间
	 */
	private Integer time;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_reportFocusDistribution")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "focusemotion" ,nullable = false)
	public Integer getFocusEmotion() {
		return focusEmotion;
	}
	public void setFocusEmotion(Integer focusEmotion) {
		this.focusEmotion = focusEmotion;
	}
	
	@Column(name = "focuspolitical", nullable = false)
	public Integer getFocusPolitical() {
		return focusPolitical;
	}
	public void setFocusPolitical(Integer focusPolitical) {
		this.focusPolitical = focusPolitical;
	}
	@Column(name = "weigth", nullable = false)
	public Float getWeigth() {
		return weigth;
	}
	public void setWeigth(Float weigth) {
		this.weigth = weigth;
	}
	
	@Column(name = "time", nullable = false)
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cityregionId", nullable = false)
	public CityRegion getCityRegionId() {
		return cityRegionId;
	}
	public void setCityRegionId(CityRegion cityRegionId) {
		this.cityRegionId = cityRegionId;
	}
	
	@Column(name = "isabout", nullable = false, columnDefinition="INT default 1")
	public Integer getIsAbout() {
		return isAbout;
	}
	public void setIsAbout(Integer isAbout) {
		this.isAbout = isAbout;
	}
	
	

}
