package com.gzgb.epo.entity;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.gzgb.epo.publics.Constants;


/**
 * 
 * <pre>
 *公众情感Entity
 * </pre>
 * @author LiuYongbin
 * @version 1.0, 2014-2-26
 */
@Entity
@Table(name="epo_publicemotion", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_publicEmotion", sequenceName = "gzgb_publicEmotion_seq", allocationSize = 1)
public class PublicEmotion extends BaseEntity{

	private static final long serialVersionUID = 995555666627631654L;

	/**
	 * 自增id
	 */
	private Long id;
	
	/**
	 * 公众阶层
	 */
	private String hierarchy;
	
	/**
	 * 公众学历
	 */
	private String education; 
	
	/**
	 * 公众情感
	 */
	private String emotion;
	
	/**
	 * 关注的部门
	 */
	private String department;
	
	/**
	 * 数量
	 */
	private Long count;
	
	/**
	 * 时间
	 */
	private String time;

	/**
	 * @return id 
	 * @see com.gzgb.epo.entity.PublicEmotion#id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_publicEmotion")
	public Long getId() {
		return id;
	}

	/**
	 * @param id id
	 * @see com.gzgb.epo.entity.PublicEmotion#id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return hierarchy 
	 * @see com.gzgb.epo.entity.PublicEmotion#hierarchy
	 */
	@Column(name="hierarchy")
	public String getHierarchy() {
		return hierarchy;
	}

	/**
	 * @param hierarchy hierarchy
	 * @see com.gzgb.epo.entity.PublicEmotion#hierarchy
	 */
	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}

	/**
	 * @return education 
	 * @see com.gzgb.epo.entity.PublicEmotion#education
	 */
	@Column(name="education")
	public String getEducation() {
		return education;
	}

	/**
	 * @param education education
	 * @see com.gzgb.epo.entity.PublicEmotion#education
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	
	/**
	 * @return emotion 
	 * @see com.gzgb.epo.entity.PublicEmotion#emotion
	 */
	@Column(name="emotion")
	public String getEmotion() {
		return emotion;
	}

	/**
	 * @param emotion emotion
	 * @see com.gzgb.epo.entity.PublicEmotion#emotion
	 */
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	/**
	 * @return department 
	 * @see com.gzgb.epo.entity.PublicEmotion#department
	 */
	@Column(name="department")
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department department
	 * @see com.gzgb.epo.entity.PublicEmotion#department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return count 
	 * @see com.gzgb.epo.entity.PublicEmotion#count
	 */
	@Column(name="count")
	public Long getCount() {
		return count;
	}

	/**
	 * @param count count
	 * @see com.gzgb.epo.entity.PublicEmotion#count
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * @return time 
	 * @see com.gzgb.epo.entity.PublicEmotion#time
	 */
	@Column(name="time")
	public String getTime() {
		return time;
	}

	/**
	 * @param time time
	 * @see com.gzgb.epo.entity.PublicEmotion#time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
