package com.qxcwl.jeewl.common.persistence;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qxcwl.jeewl.common.config.Global;
import com.qxcwl.jeewl.modules.sys.entity.User;

public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 全局搜索字段
	 */
	protected String globalSearch;
	/**
	 * 历史记录,json字符串
	 */
	protected String history;
	
	/**
	 * 备注
	 */
	protected String remarks;
	
	/**
	 * 创建者
	 */
	protected User createBy;
	
	/**
	 * 创建日期
	 */
	protected Date createDate;
	
	/**
	 * 更新者
	 */
	protected User updateBy;
	
	/**
	 * 更新日期
	 */
	protected Date updateDate;
	
	/**
	 * 删除标记（0：正常；1：删除；2：审核）
	 */
	protected String delFlag;
	
	/**
	 * 删除标记（0：正常）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	/**
	 * 删除标记（1：删除）
	 */
	public static final String DEL_FLAG_DELETE = "1";
	/**
	 * 删除标记（2：审核）
	 */
	public static final String DEL_FLAG_AUDIT = "2";
	
	
	public DataEntity() {
		super();
	}

	public DataEntity(String id) {
		super(id);
	}

	/** 
	 * 获取备注 
	 * @return remarks 备注 
	 */
	public String getRemarks() {
		return remarks;
	}
	
	/** 
	 * 设置备注 
	 * @param remarks 备注 
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/** 
	 * 获取创建者 
	 * @return createDate 创建者 
	 */
	public Date getCreateDate() {
		return createDate;
	}
	
	/** 
	 * 设置创建者 
	 * @param createDate 创建者 
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	/** 
	 * 获取更新者 
	 * @return updateDate 更新者 
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	
	
	/** 
	 * 设置更新者 
	 * @param updateDate 更新者 
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	/** 
	 * 获取删除标记（0：正常；1：删除；2：审核） 
	 * @return delFlag 删除标记（0：正常；1：删除；2：审核） 
	 */
	public String getDelFlag() {
		return delFlag;
	}
	
	/** 
	 * 设置删除标记（0：正常；1：删除；2：审核） 
	 * @param delFlag 删除标记（0：正常；1：删除；2：审核） 
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	/** 
	 * 获取历史记录json字符串 
	 * @return history 历史记录json字符串 
	 */
	public String getHistory() {
		return history;
	}

	/** 
	 * 设置历史记录json字符串 
	 * @param history 历史记录json字符串 
	 */
	public void setHistory(String history) {
		this.history = history;
	}

	/**
	 * 获取 创建者
	 * @return createBy 创建者
	 */
	public User getCreateBy() {
		return createBy;
	}

	/**
	 * 设置 创建者
	 * @param createBy 创建者
	 */
	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	/**
	 * 获取 更新用户
	 * @return updateBy 更新用户
	 */
	public User getUpdateBy() {
		return updateBy;
	}

	/**
	 * 设置 更新用户
	 * @param updateBy 更新用户
	 */
	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 获取全局搜索字段 
	 * @return globalSearch 全局搜索字段 
	 */
	public String getGlobalSearch() {
		return globalSearch;
	}

	/** 
	 * 设置全局搜索字段 
	 * @param globalSearch 全局搜索字段 
	 */
	public void setGlobalSearch(String globalSearch) {
		this.globalSearch = globalSearch;
	}
	
	/**
	 * 获取数据库名称
	 */
	@JsonIgnore
	public String getDbName(){
		return Global.getConfig("jdbc.type");
	}
	

}
