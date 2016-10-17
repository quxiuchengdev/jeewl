package com.qxcwl.jeewl.modules.sys.entity;

import com.qxcwl.jeewl.common.page.Page;
import com.qxcwl.jeewl.common.persistence.DataEntity;

/**
 * 字典
 * @ClassName Dict
 * @Description 
 * @author 曲修成
 * @date 2016年8月4日 下午4:07:14
 */
public class Dict extends DataEntity<Dict> {

	private static final long serialVersionUID = -2349962657494325290L;
	/**
	 * 数据值
	 */
	private String value;
	/**
	 * 标签名
	 */
	private String label; 
	/**
	 *  类型
	 */
	private String type;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 排序
	 */
	private Integer sort;
	/** 
	 * 获取数据值 
	 * @return value 数据值 
	 */
	public String getValue() {
		return value;
	}
	/** 
	 * 设置数据值 
	 * @param value 数据值 
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/** 
	 * 获取标签名 
	 * @return label 标签名 
	 */
	public String getLabel() {
		return label;
	}
	/** 
	 * 设置标签名 
	 * @param label 标签名 
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/** 
	 * 获取类型 
	 * @return type 类型 
	 */
	public String getType() {
		return type;
	}
	/** 
	 * 设置类型 
	 * @param type 类型 
	 */
	public void setType(String type) {
		this.type = type;
	}
	/** 
	 * 获取描述 
	 * @return description 描述 
	 */
	public String getDescription() {
		return description;
	}
	/** 
	 * 设置描述 
	 * @param description 描述 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/** 
	 * 获取排序 
	 * @return sort 排序 
	 */
	public Integer getSort() {
		return sort;
	}
	/** 
	 * 设置排序 
	 * @param sort 排序 
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
