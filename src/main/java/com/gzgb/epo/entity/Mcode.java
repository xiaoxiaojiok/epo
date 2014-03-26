package com.gzgb.epo.entity;

import java.util.Date;

import javax.persistence.Cacheable;
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
 * 
 * <pre>
 * 
 *  码表实体
 *	设置规则：各实体中码值统一采用String类型
 * 
 * </pre>
 * @author XiaoJian
 * @version 1.0, 2014-3-25
 */

@Entity
@Table(name="mcode", schema=Constants.GZGB_SCH)
@Cacheable 
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_mcode", sequenceName = "gzgb_mcode_seq", allocationSize = 1)
public class Mcode extends BaseEntity{

	private static final long serialVersionUID = 109952355454276900L;
	
	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 码类型
	 */
	private String mtype;
	
	/**
	 * 码名
	 */
	private String mkey;
	
	/**
	 * 码值
	 */
	private String mvalue;
	
	/**
	 * 码备注
	 */
	private String remark;
	
	/**
	 * 码排序
	 */
	private Integer orderNum;
	
	/**
	 * 码级别:级别越小越重要
	 */
	private Integer datelevel;
	
	/**
	 * 创建日期
	 */
	private Date creatdate;
	
	/**
	 * 临时创建日期
	 */
	private String date;
	
	/**
	 * 创建人
	 */
	@JsonBackReference
	private User createdBy;

	/**
	 * 临时创建人
	 */
	private String createrName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator="gzgb_mcode")
	@Column(name="mcode_id")
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
	
	@Column(name="mc_mtype",nullable = false, length=300)
	public String getMtype()
	{
		return mtype;
	}
	
	public void setMtype(String mtype)
	{
		this.mtype = mtype;
	}
	
	@Column(name="mc_mkey",nullable = false, length=100)
	public String getMkey()
	{
		return mkey;
	}
	
	public void setMkey(String mkey)
	{
		this.mkey = mkey;
	}
	
	@Column(name="mc_mvalue",nullable = false, length=50)
	public String getMvalue()
	{
		return mvalue;
	}
	
	public void setMvalue(String mvalue)
	{
		this.mvalue = mvalue;
	}
	
	@Column(name="mc_remark",nullable = true, length=300)
	public String getRemark()
	{
		return remark;
	}
	
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	
	@Column(name="mc_order_num",nullable = true)
	public Integer getOrderNum()
	{
		return orderNum;
	}
	
	public void setOrderNum(Integer orderNum)
	{
		this.orderNum = orderNum;
	}
	
	@Column(name="mc_date_level",nullable=true,columnDefinition="INTEGER default 0")
	public Integer getDatelevel()
	{
		return datelevel;
	}
	
	public void setDatelevel(Integer datelevel)
	{
		this.datelevel = datelevel;
	}
	
	@Column(name="mc_create_date",nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatdate()
	{
		return creatdate;
	}
	
	public void setCreatdate(Date creatdate)
	{
		this.creatdate = creatdate;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CREATED_BY")
	public User getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(User createdBy)
	{
		this.createdBy = createdBy;
	}

	@Transient
	public String getCreaterName()
	{
		if(this.createdBy!=null){
			return this.createdBy.getUsername();
		}else{
			return "";
		}
	}

	public void setCreaterName(String createrName)
	{
		this.createrName = createrName;
	}

	@Transient
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}

