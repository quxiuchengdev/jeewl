package com.qxcwl.jeewl.modules.gen.entity;

import java.util.ArrayList;
import java.util.List;

import com.qxcwl.jeewl.common.persistence.DataEntity;

/**
 * 代码生成器-业务表
 * @ClassName GenTable
 * @Description 
 * @author 曲修成
 * @date 2016年8月4日 下午3:12:47
 */
public class GenTable extends DataEntity<GenTable> {

	private static final long serialVersionUID = -1613825492881907784L;
	
	/**
	 * 表名称
	 */
	private String tableName;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 生成代码实体类名称
	 */
	private String className;
	
	/**
	 * 表列
	 */
	private List<GenTableColumn> columnList = new ArrayList<GenTableColumn>();

	/** 
	 * 获取表名称 
	 * @return tableName 表名称 
	 */
	public String getTableName() {
		return tableName;
	}

	/** 
	 * 设置表名称 
	 * @param tableName 表名称 
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
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
	 * 获取生成代码实体类名称 
	 * @return className 生成代码实体类名称 
	 */
	public String getClassName() {
		return className;
	}

	/** 
	 * 设置生成代码实体类名称 
	 * @param className 生成代码实体类名称 
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/** 
	 * 获取表列 
	 * @return columnList 表列 
	 */
	public List<GenTableColumn> getColumnList() {
		return columnList;
	}

	/** 
	 * 设置表列 
	 * @param columnList 表列 
	 */
	public void setColumnList(List<GenTableColumn> columnList) {
		this.columnList = columnList;
	}
	

}
