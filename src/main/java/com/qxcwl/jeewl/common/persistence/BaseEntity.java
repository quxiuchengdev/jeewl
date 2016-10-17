package com.qxcwl.jeewl.common.persistence;

import java.io.Serializable;

import com.qxcwl.jeewl.common.page.Page;

public abstract class BaseEntity<T> implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID,主键
	 */
	protected String id;

	public BaseEntity() {
		
	}
	
	public BaseEntity(String id) {
		this();
		this.id = id;
	}

	/** 
	 * 获取ID主键 
	 * @return id ID主键 
	 */
	public String getId() {
		return id;
	}

	/** 
	 * 设置ID主键 
	 * @param id ID主键 
	 */
	
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 分页对象
	 */
	protected Page<T> page;

	/** 
	 * 获取分页对象 
	 * @return page 分页对象 
	 */
	public Page<T> getPage() {
		return page;
	}

	/** 
	 * 设置分页对象 
	 * @param page 分页对象 
	 */
	public void setPage(Page<T> page) {
		this.page = page;
	}
	
}
