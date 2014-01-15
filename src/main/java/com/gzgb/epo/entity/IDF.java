package com.gzgb.epo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.gzgb.epo.publics.Constants;

/**
 * 
 * <pre>
 * IDF实体
 * </pre>
 * 
 * @author XiaoJian
 * @version 1.0, 2013-12-28
 */
@Entity
@Table(name = "idf", schema = Constants.GZGB_SCH)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SequenceGenerator(name = "gzgb_idf", sequenceName = "gzgb_idf_seq", allocationSize = 1)
public class IDF extends BaseEntity {

	private static final long serialVersionUID = 985235545427611655L;

	/**
	 * 自增ID
	 */
	private Long id;
	
	/**
	 * 词名
	 */
	private String wordName;
	
	/**
	 * 词的权重 
	 */
	private Double weights;
	
	/**
	 * 包含该词语的文件个数
	 */
	private Long fileNum;
	
	/**
	 * 词语总数
	 */
	private Long wordNum;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gzgb_idf")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "word", nullable = false)
	public String getWordName() {
		return wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	@Column(name = "weights", nullable = false)
	public Double getWeights() {
		return weights;
	}

	public void setWeights(Double weights) {
		this.weights = weights;
	}

	@Column(name = "n", nullable = false)
	public Long getFileNum() {
		return fileNum;
	}

	public void setFileNum(Long fileNum) {
		this.fileNum = fileNum;
	}

	@Column(name = "total", nullable = false)
	public Long getWordNum() {
		return wordNum;
	}

	public void setWordNum(Long wordNum) {
		this.wordNum = wordNum;
	}
	
}
