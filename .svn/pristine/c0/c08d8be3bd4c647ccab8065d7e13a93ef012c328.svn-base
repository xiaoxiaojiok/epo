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
 * 采集点管理实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-18
 */
@Entity
@Table(name = "epo_webgathernode", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_webgathernode", sequenceName = "gzgb_webgathernode_seq", allocationSize = 1)
public class WebGatherNode extends BaseEntity {
	
	private static final long serialVersionUID = 995235545427616654L;

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 站点ID
	 */
	@JsonBackReference
	private WebSiteMain wsmId;
	
	/**
	 * 临时站点名称
	 */
	private String weBSiteName;
	
	/**
	 * 临时站点ID
	 */
	private Long webSiteID;
	
	/**
	 * 采集点名称
	 */
	private String wgnName;
	
	/**
	 * 唯一标识
	 */
	private String wgnUniqueId;
	
	/**
	 * 入口地址
	 */
	private String wgnEntryUrl;
	
	/**
	 * 允许链接格式
	 */
	private String wgnAllowRule;
	
	/**
	 * 禁止链接格式
	 */
	private String wgnDenyRule;
	
	/**
	 * 分页匹配规则
	 */
	private String wgnNextPage;
	
	/**
	 * 采集域
	 */
	private String wgnAllowDomain;
	
	/**
	 * 采集权重
	 */
	private Byte wgnWeight;
	
	/**
	 * 所属类别
	 */
	private Byte wgnType;
	
	/**
	 * 是否有效
	 */
	private Byte wgnSpiderEnable;
	
	/**
	 * 采集延迟时间
	 */
	private Byte wgnDelay;
	
	/**
	 * 是否开启COOKIES
	 */
	private Byte wgnCookiesEnable;
	
	/**
	 * 处理链接
	 */
	private String wgnProcessLinks;
	
	/**
	 * 代理列表
	 */
	private String wgnProxies;
	
	/**
	 * 采集字段配置
	 */
	private String wgnConfigItem;
	
	/**
	 * 是否登录
	 */
	private Byte wgnLoginEnable;
	
	/**
	 * 登录入口
	 */
	private String wgnLoginEntry;
	
	/**
	 * 登录账号
	 */
	private String wgnLoginAccount;
	
	/**
	 * 登录密码
	 */
	private String wgnLoginPassword;
	
	/**
	 * 采集深度
	 */
	private Byte wgnDepthLimit;
	
	/**
	 * 采集频率
	 */
	private Integer wgnTimeInterval;
	
	/**
	 * 采集更新时间
	 */
	private Integer wgnTimeRefresh;
	
	/**
	 * 用户代理
	 */
	private String wgnUserAgents;
	
	/**
	 * 是否繁体采集点
	 */
	private Byte wgnTraditional;
	
	/**
	 * 是否过滤掉网页
	 */
	private Byte wgnIsClean;
	
	/**
	 * 蜘蛛任务ID
	 */
	private String wgnJobId;
	
	/**
	 * 更新时间
	 */
	private Date wgnUpdateTime;
	
	/**
	 * 创建时间
	 */
	private Date wgnCreateTime;
	
	/**
	 * 是否删除
	 */
	private Byte wgnDelete;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_webgathernode")
	@Column(name = "wgnId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wsmId", nullable = false, columnDefinition = "INTEGER default 0")
	public WebSiteMain getWsmId() {
		return wsmId;
	}

	public void setWsmId(WebSiteMain wsmId) {
		this.wsmId = wsmId;
	}

	@Column(name = "wgnName", nullable = false)
	public String getWgnName() {
		return wgnName;
	}

	public void setWgnName(String wgnName) {
		this.wgnName = wgnName;
	}

	@Column(name = "wgnUniqueId", nullable = false)
	public String getWgnUniqueId() {
		return wgnUniqueId;
	}

	public void setWgnUniqueId(String wgnUniqueId) {
		this.wgnUniqueId = wgnUniqueId;
	}

	@Column(name = "wgnEntryUrl", nullable = true, length = 1024)
	public String getWgnEntryUrl() {
		return wgnEntryUrl;
	}

	public void setWgnEntryUrl(String wgnEntryUrl) {
		this.wgnEntryUrl = wgnEntryUrl;
	}

	@Column(name = "wgnAllowRule", nullable = true, length = 1024)
	public String getWgnAllowRule() {
		return wgnAllowRule;
	}

	public void setWgnAllowRule(String wgnAllowRule) {
		this.wgnAllowRule = wgnAllowRule;
	}

	@Column(name = "wgnDenyRule", nullable = true, length = 1024)
	public String getWgnDenyRule() {
		return wgnDenyRule;
	}

	public void setWgnDenyRule(String wgnDenyRule) {
		this.wgnDenyRule = wgnDenyRule;
	}

	@Column(name = "wgnNextPage", nullable = true, length = 1024)
	public String getWgnNextPage() {
		return wgnNextPage;
	}

	public void setWgnNextPage(String wgnNextPage) {
		this.wgnNextPage = wgnNextPage;
	}

	@Column(name = "wgnAllowDomain", nullable = true, length = 1024)
	public String getWgnAllowDomain() {
		return wgnAllowDomain;
	}

	public void setWgnAllowDomain(String wgnAllowDomain) {
		this.wgnAllowDomain = wgnAllowDomain;
	}

	@Column(name = "wgnWeight", nullable = false)
	public Byte getWgnWeight() {
		return wgnWeight;
	}

	public void setWgnWeight(Byte wgnWeight) {
		this.wgnWeight = wgnWeight;
	}

	@Column(name = "wgnType", nullable = false)
	public Byte getWgnType() {
		return wgnType;
	}

	public void setWgnType(Byte wgnType) {
		this.wgnType = wgnType;
	}

	@Column(name = "wgnSpiderEnable", nullable = false)
	public Byte getWgnSpiderEnable() {
		return wgnSpiderEnable;
	}

	public void setWgnSpiderEnable(Byte wgnSpiderEnable) {
		this.wgnSpiderEnable = wgnSpiderEnable;
	}

	@Column(name = "wgnDelay", nullable = false)
	public Byte getWgnDelay() {
		return wgnDelay;
	}

	public void setWgnDelay(Byte wgnDelay) {
		this.wgnDelay = wgnDelay;
	}

	@Column(name = "wgnCookiesEnable", nullable = false)
	public Byte getWgnCookiesEnable() {
		return wgnCookiesEnable;
	}

	public void setWgnCookiesEnable(Byte wgnCookiesEnable) {
		this.wgnCookiesEnable = wgnCookiesEnable;
	}

	@Column(name = "wgnProcessLinks", nullable = true)
	public String getWgnProcessLinks() {
		return wgnProcessLinks;
	}

	public void setWgnProcessLinks(String wgnProcessLinks) {
		this.wgnProcessLinks = wgnProcessLinks;
	}

	@Column(name = "wgnProxies", nullable = true, length=1024)
	public String getWgnProxies() {
		return wgnProxies;
	}

	public void setWgnProxies(String wgnProxies) {
		this.wgnProxies = wgnProxies;
	}

	@Column(name = "wgnConfigItem", nullable = true, length=1024)
	public String getWgnConfigItem() {
		return wgnConfigItem;
	}

	public void setWgnConfigItem(String wgnConfigItem) {
		this.wgnConfigItem = wgnConfigItem;
	}

	@Column(name = "wgnLoginEnable", nullable = false)
	public Byte getWgnLoginEnable() {
		return wgnLoginEnable;
	}

	public void setWgnLoginEnable(Byte wgnLoginEnable) {
		this.wgnLoginEnable = wgnLoginEnable;
	}

	@Column(name = "wgnLoginEntry", nullable = true)
	public String getWgnLoginEntry() {
		return wgnLoginEntry;
	}

	public void setWgnLoginEntry(String wgnLoginEntry) {
		this.wgnLoginEntry = wgnLoginEntry;
	}

	@Column(name = "wgnLoginAccount", nullable = true)
	public String getWgnLoginAccount() {
		return wgnLoginAccount;
	}

	public void setWgnLoginAccount(String wgnLoginAccount) {
		this.wgnLoginAccount = wgnLoginAccount;
	}

	@Column(name = "wgnLoginPassword", nullable = true)
	public String getWgnLoginPassword() {
		return wgnLoginPassword;
	}

	public void setWgnLoginPassword(String wgnLoginPassword) {
		this.wgnLoginPassword = wgnLoginPassword;
	}

	@Column(name = "wgnDepthLimit", nullable = false)
	public Byte getWgnDepthLimit() {
		return wgnDepthLimit;
	}

	public void setWgnDepthLimit(Byte wgnDepthLimit) {
		this.wgnDepthLimit = wgnDepthLimit;
	}

	@Column(name = "wgnTimeInterval", nullable = false)
	public Integer getWgnTimeInterval() {
		return wgnTimeInterval;
	}

	public void setWgnTimeInterval(Integer wgnTimeInterval) {
		this.wgnTimeInterval = wgnTimeInterval;
	}

	@Column(name = "wgnTimeRefresh", nullable = false)
	public Integer getWgnTimeRefresh() {
		return wgnTimeRefresh;
	}

	public void setWgnTimeRefresh(Integer wgnTimeRefresh) {
		this.wgnTimeRefresh = wgnTimeRefresh;
	}

	@Column(name = "wgnUserAgents", nullable = true, length=1024)
	public String getWgnUserAgents() {
		return wgnUserAgents;
	}

	public void setWgnUserAgents(String wgnUserAgents) {
		this.wgnUserAgents = wgnUserAgents;
	}

	@Column(name = "wgnTraditional", nullable = false)
	public Byte getWgnTraditional() {
		return wgnTraditional;
	}

	public void setWgnTraditional(Byte wgnTraditional) {
		this.wgnTraditional = wgnTraditional;
	}

	@Column(name = "wgnIsClean", nullable = false)
	public Byte getWgnIsClean() {
		return wgnIsClean;
	}

	public void setWgnIsClean(Byte wgnIsClean) {
		this.wgnIsClean = wgnIsClean;
	}

	@Column(name = "wgnJobId", nullable = true)
	public String getWgnJobId() {
		return wgnJobId;
	}

	public void setWgnJobId(String wgnJobId) {
		this.wgnJobId = wgnJobId;
	}

	@Column(name = "wgnUpdateTime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getWgnUpdateTime() {
		return wgnUpdateTime;
	}

	public void setWgnUpdateTime(Date wgnUpdateTime) {
		this.wgnUpdateTime = wgnUpdateTime;
	}

	@Column(name = "wgnCreateTime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getWgnCreateTime() {
		return wgnCreateTime;
	}

	public void setWgnCreateTime(Date wgnCreateTime) {
		this.wgnCreateTime = wgnCreateTime;
	}

	@Column(name = "wgnDelete", nullable = false)
	public Byte getWgnDelete() {
		return wgnDelete;
	}

	public void setWgnDelete(Byte wgnDelete) {
		this.wgnDelete = wgnDelete;
	}

	@Transient
	public String getWeBSiteName() {
		return weBSiteName;
	}

	public void setWeBSiteName(String weBSiteName) {
		this.weBSiteName = weBSiteName;
	}

	@Transient
	public Long getWebSiteID() {
		return webSiteID;
	}

	public void setWebSiteID(Long webSiteID) {
		this.webSiteID = webSiteID;
	}
	
	

}
