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
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gzgb.epo.publics.Constants;

/**
 * <pre>
 * 涉穂博客实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-2-25
 */
@Entity
@Table(name = "epo_warningbloglist", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_warningbloglist", sequenceName = "gzgb_warningbloglist_seq", allocationSize = 1)
public class BlogList extends BaseEntity  {

	private static final long serialVersionUID = 995235545418631655L;

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 博客标题
	 */
	private String wblTitle;
	
	/**
	 * 博客文章
	 */
	private String wblContent;
	
	/**
	 * 关键词
	 */
	private String wblKeywords;
	
	/**
	 * URL
	 */
	private String wblUrl;
	
	/**
	 * 博客作者
	 */
	private String wblAuthor;
	
	/**
	 * 发布时间
	 */
	private Date wblDate;
	
	/**
	 * 发布时间戳
	 */
	private Integer wblTimestamp;
	
	/**
	 * 评论数
	 */
	private Integer wblComment;
	
	/**
	 * 查看数 
	 */
	private Integer wblView;
	
	/**
	 * 热度
	 */
	private Integer wblHots;
	
	/**
	 * 敏感度
	 */
	private Double wblSensitivity;
	
	/**
	 * 来源网站
	 */
	@JsonBackReference
	private WebSiteMain wsmId;
	
	/**
	 * 临时站点名称
	 */
	private String weBSiteName;
	
	/**
	 * 是否为部门博客
	 */
	private Byte wblIsDepartment;
	
	/**
	 * 涉及部门ID
	 */
	private DepartmentBaseInfo dbiId;
	
	/**
	 * 是否为区县博客
	 */
	private Byte wblIsRegion;
	
	/**
	 * 涉及区县ID
	 */
	private RegionBaseInfo rbiId;
	
	/**
	 * 是否隐藏
	 */
	private Byte wblHide;
	
	/**
	 * 是否更新
	 */
	private Byte wblUpdate;
	
	/**
	 * UUID对照
	 */
	private String wblUniqueId;
	
	/**
	 * 更新时间
	 */
	private Integer wblUpdateTime;
	
	/**
	 * 创建时间
	 */
	private Integer wblCreateTime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_warningbloglist")
	@Column(name = "wblUUID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "wblTitle", nullable = false)
	public String getWblTitle() {
		return wblTitle;
	}

	public void setWblTitle(String wblTitle) {
		this.wblTitle = wblTitle;
	}

	@Column(name = "wblContent", nullable = true, length = 1024)
	public String getWblContent() {
		return wblContent;
	}

	public void setWblContent(String wblContent) {
		this.wblContent = wblContent;
	}

	@Column(name = "wblKeywords", nullable = false)
	public String getWblKeywords() {
		return wblKeywords;
	}

	public void setWblKeywords(String wblKeywords) {
		this.wblKeywords = wblKeywords;
	}

	@Column(name = "wblUrl", nullable = false)
	public String getWblUrl() {
		return wblUrl;
	}

	public void setWblUrl(String wblUrl) {
		this.wblUrl = wblUrl;
	}

	@Column(name = "wblAuthor", nullable = false)
	public String getWblAuthor() {
		return wblAuthor;
	}

	public void setWblAuthor(String wblAuthor) {
		this.wblAuthor = wblAuthor;
	}

	@Column(name = "wblDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getWblDate() {
		return wblDate;
	}

	public void setWblDate(Date wblDate) {
		this.wblDate = wblDate;
	}

	@Column(name = "wblTimestamp", nullable = false)
	public Integer getWblTimestamp() {
		return wblTimestamp;
	}

	public void setWblTimestamp(Integer wblTimestamp) {
		this.wblTimestamp = wblTimestamp;
	}

	@Column(name = "wblComment", nullable = false)
	public Integer getWblComment() {
		return wblComment;
	}

	public void setWblComment(Integer wblComment) {
		this.wblComment = wblComment;
	}

	@Column(name = "wblView", nullable = false)
	public Integer getWblView() {
		return wblView;
	}

	public void setWblView(Integer wblView) {
		this.wblView = wblView;
	}

	@Column(name = "wblHots", nullable = false)
	public Integer getWblHots() {
		return wblHots;
	}

	public void setWblHots(Integer wblHots) {
		this.wblHots = wblHots;
	}

	@Column(name = "wblSensitivity", nullable = false)
	public Double getWblSensitivity() {
		return wblSensitivity;
	}

	public void setWblSensitivity(Double wblSensitivity) {
		this.wblSensitivity = wblSensitivity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wsmId", nullable = false)
	public WebSiteMain getWsmId() {
		return wsmId;
	}

	public void setWsmId(WebSiteMain wsmId) {
		this.wsmId = wsmId;
	}

	@Column(name = "wblIsDepartment", nullable = false)
	public Byte getWblIsDepartment() {
		return wblIsDepartment;
	}

	public void setWblIsDepartment(Byte wblIsDepartment) {
		this.wblIsDepartment = wblIsDepartment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dbiId", nullable = true)
	public DepartmentBaseInfo getDbiId() {
		return dbiId;
	}

	public void setDbiId(DepartmentBaseInfo dbiId) {
		this.dbiId = dbiId;
	}

	@Column(name = "wblIsRegion", nullable = false)
	public Byte getWblIsRegion() {
		return wblIsRegion;
	}

	public void setWblIsRegion(Byte wblIsRegion) {
		this.wblIsRegion = wblIsRegion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rbiId", nullable = true)
	public RegionBaseInfo getRbiId() {
		return rbiId;
	}

	public void setRbiId(RegionBaseInfo rbiId) {
		this.rbiId = rbiId;
	}

	@Column(name = "wblHide", nullable = false)
	public Byte getWblHide() {
		return wblHide;
	}

	public void setWblHide(Byte wblHide) {
		this.wblHide = wblHide;
	}

	@Column(name = "wblUpdate", nullable = false)
	public Byte getWblUpdate() {
		return wblUpdate;
	}

	public void setWblUpdate(Byte wblUpdate) {
		this.wblUpdate = wblUpdate;
	}

	@Column(name = "wblUniqueId", nullable = false)
	public String getWblUniqueId() {
		return wblUniqueId;
	}

	public void setWblUniqueId(String wblUniqueId) {
		this.wblUniqueId = wblUniqueId;
	}

	@Column(name = "wblUpdateTime", nullable = false)
	public Integer getWblUpdateTime() {
		return wblUpdateTime;
	}

	public void setWblUpdateTime(Integer wblUpdateTime) {
		this.wblUpdateTime = wblUpdateTime;
	}

	@Column(name = "wblCreateTime", nullable = false)
	public Integer getWblCreateTime() {
		return wblCreateTime;
	}

	public void setWblCreateTime(Integer wblCreateTime) {
		this.wblCreateTime = wblCreateTime;
	}
	
	@Transient
	public String getWeBSiteName() {
		return weBSiteName;
	}

	public void setWeBSiteName(String weBSiteName) {
		this.weBSiteName = weBSiteName;
	}
	
}
