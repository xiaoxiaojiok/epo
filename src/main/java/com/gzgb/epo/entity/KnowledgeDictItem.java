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
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gzgb.epo.publics.Constants;

/**
 * 
 * <pre>
 * 词条实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-29
 */
@Entity
@Table(name = "epo_knowledgedictitem", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_knowledgedictitem", sequenceName = "gzgb_knowledgedictitem_seq", allocationSize = 1)
public class KnowledgeDictItem extends BaseEntity {
	
	private static final long serialVersionUID = 982235545427634455L;

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 词条名称
	 */
	private String kdiName;
	
	/**
	 * 词条拼音
	 */
	private String kdiPinyin;
	
	/**
	 * 所属词库
	 */
	private KnowledgeDictLib kdlId;
	
	/**
	 * 词性
	 */
	private KnowledgeDictQuality kdqId;
	
	/**
	 * 词条权重
	 */
	private Float kdiWeight;
	
	/**
	 * 词条状态
	 */
	private Byte kdiStatus;
	
	/**
	 * 是否隐藏
	 */
	private Integer kdiSwitch;
	
	/**
	 * 是否为中文切分词
	 */
	private Integer kdiSegmentation;
	
	/**
	 * 创建用户
	 */
	private User userId;
	
	/**
	 * 创建时间
	 */
	private Integer kdiCreateTime;
	
	/**
	 * 更新时间
	 */
	private Integer kdiUpdateTime;
	
	/**
	 * 所属词库 Long型的临时变量
	 */

	private Long kdlIdLong;
	
	/**
	 * 所属词性库 Long型的临时变量
	 */

	private Long kdqIdLong;
	
	/**
	 * 所属父词库 Long型的临时变量
	 */

	private Long parentIdLong;
	
	/**
	 * 临时变量创建时间 String类型
	 */
	
	@JsonBackReference
	private String kdiCreateDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_knowledgedictitem")
	@Column(name = "kdiId")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "kdiName", nullable = false)
	public String getKdiName() {
		return kdiName;
	}

	public void setKdiName(String kdiName) {
		this.kdiName = kdiName;
	}

	@Column(name = "kdiPinyin", nullable = true)
	public String getKdiPinyin() {
		return kdiPinyin;
	}

	public void setKdiPinyin(String kdiPinyin) {
		this.kdiPinyin = kdiPinyin;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kdlId", nullable = false, columnDefinition = "INTEGER default 0")
	public KnowledgeDictLib getKdlId() {
		return kdlId;
	}

	public void setKdlId(KnowledgeDictLib kdlId) {
		this.kdlId = kdlId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kdqId", nullable = false, columnDefinition = "INTEGER default 0")
	public KnowledgeDictQuality getKdqId() {
		return kdqId;
	}

	public void setKdqId(KnowledgeDictQuality kdqId) {
		this.kdqId = kdqId;
	}

	@Column(name = "kdiWeight", nullable = false, columnDefinition = "INTEGER default 0")
	public Float getKdiWeight() {
		return kdiWeight;
	}

	public void setKdiWeight(Float kdiWeight) {
		this.kdiWeight = kdiWeight;
	}

	@Column(name = "kdiStatus", nullable = false, columnDefinition = "INTEGER default 1")
	public Byte getKdiStatus() {
		return kdiStatus;
	}

	public void setKdiStatus(Byte kdiStatus) {
		this.kdiStatus = kdiStatus;
	}

	@Column(name = "kdiSwitch", nullable = false, columnDefinition = "INTEGER default 1")
	public Integer getKdiSwitch() {
		return kdiSwitch;
	}

	public void setKdiSwitch(Integer kdiSwitch) {
		this.kdiSwitch = kdiSwitch;
	}

	@Column(name = "kdiSegmentation", nullable = false, columnDefinition = "INTEGER default 1")
	public Integer getKdiSegmentation() {
		return kdiSegmentation;
	}

	public void setKdiSegmentation(Integer kdiSegmentation) {
		this.kdiSegmentation = kdiSegmentation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "umiId", nullable = false)
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Column(name = "kdiCreateTime", nullable = false)
	public Integer getKdiCreateTime() {
		return kdiCreateTime;
	}

	public void setKdiCreateTime(Integer kdiCreateTime) {
		this.kdiCreateTime = kdiCreateTime;
	}

	@Column(name = "kdiUpdateTime", nullable = false)
	public Integer getKdiUpdateTime() {
		return kdiUpdateTime;
	}

	public void setKdiUpdateTime(Integer kdiUpdateTime) {
		this.kdiUpdateTime = kdiUpdateTime;
	}

	@Transient
	public Long getKdlIdLong() {
		return kdlIdLong;
	}

	public void setKdlIdLong(Long kdlIdLong) {
		this.kdlIdLong = kdlIdLong;
	}

	@Transient
	public Long getKdqIdLong() {
		return kdqIdLong;
	}

	public void setKdqIdLong(Long kdqIdLong) {
		this.kdqIdLong = kdqIdLong;
	}

	@Transient
	public Long getParentIdLong() {
		return parentIdLong;
	}

	public void setParentIdLong(Long parentIdLong) {
		this.parentIdLong = parentIdLong;
	}

	@Transient
	public String getKdiCreateDate() {
		return kdiCreateDate;
	}

	public void setKdiCreateDate(String kdiCreateDate) {
		this.kdiCreateDate = kdiCreateDate;
	}
	
	
}
