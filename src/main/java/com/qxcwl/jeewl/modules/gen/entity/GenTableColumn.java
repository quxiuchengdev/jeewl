package com.qxcwl.jeewl.modules.gen.entity;

import com.qxcwl.jeewl.common.persistence.DataEntity;

/**
 * 代码生成器-业务表-表列名
 * @ClassName GenTableColumn
 * @Description 
 * @author 曲修成
 * @date 2016年8月4日 下午3:13:02
 */
public class GenTableColumn extends DataEntity<GenTableColumn> {

	private static final long serialVersionUID = 2648460510060211938L;
	
	public static String IS_YES = "1";
	
	public static String IS_NO = "0";
	
	/**
	 * 归属表
	 */
	private GenTable genTable;
	
	/**
	 * 列名
	 */
	private String columnName;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * JDBC类型
	 */
	private String jdbcType;
	
	/**
	 * JAVA类型
	 */
	private String javaType;
	
	/**
	 * JAVA字段名
	 */
	private String javaField;
	
	/**
	 * 是否主键（1：主键）
	 */
	private String isPk;
	
	/**
	 * 是否可为空（1：可为空；0：不为空）
	 */
	private String isNull;
	
	/**
	 * 是否为插入字段（1：插入字段）
	 */
	private String isInsert;
	
	/**
	 *  是否编辑字段（1：编辑字段）
	 */
	private String isEdit;
	
	/**
	 * 是否列表字段（1：列表字段）
	 */
	private String isList;
	
	/**
	 * 是否查询字段（1：查询字段）
	 */
	private String isQuery;	
	
	/**
	 * 查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）
	 */
	private String queryType;
	/**
	 * 查询方式-等于
	 */
	public static String QUERY_TYPE_EQ = "=";
	/**
	 * 查询方式-不等于
	 */
	public static String QUERY_TYPE_NE = "<>";
	/**
	 * 查询方式-大于
	 */
	public static String QUERY_TYPE_GT = ">";
	/**
	 * 查询方式-小于
	 */
	public static String QUERY_TYPE_LT = "<";
	/**
	 * 查询方式-范围
	 */
	public static String QUERY_TYPE_BETWEEN= "between";
	/**
	 * 查询方式-左like
	 */
	public static String QUERY_TYPE_LEFT_LIKE = "%like";
	/**
	 * 查询方式-右like
	 */
	public static String QUERY_TYPE_RIGHT_LIKE = "like%";
	/**
	 * 查询方式-左右like
	 */
	public static String QUERY_TYPE__LIKE = "%like%";
	
	/**
	 *  字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）
	 */
	private String showType;
	/**
	 * 字段生成方案-文本框
	 */
	public static String SHOW_TYPE_TEXT = "text";
	/**
	 * 字段生成方案-文本域
	 */
	public static String SHOW_TYPE_TEXTARE = "textare";
	/**
	 * 字段生成方案-下拉列表
	 */
	public static String SHOW_TYPE_SELECT = "select";
	/**
	 * 字段生成方案-复选框
	 */
	public static String SHOW_TYPE_CHECKBOX = "checkbox";
	/**
	 * 字段生成方案-单选框
	 */
	public static String SHWO_TYPE_RADIO = "radio";
	/**
	 * 字段生成方案-字典类型
	 */
	public static String SHOW_TYPE_DICT = "dict";
	
	
	/**
	 * 字典类型
	 */
	private String dictType;
	
	/**
	 *  排序（升序）
	 */
	private Integer sort;

	/** 
	 * 获取归属表 
	 * @return genTable 归属表 
	 */
	public GenTable getGenTable() {
		return genTable;
	}

	/** 
	 * 设置归属表 
	 * @param genTable 归属表 
	 */
	public void setGenTable(GenTable genTable) {
		this.genTable = genTable;
	}

	/** 
	 * 获取列名 
	 * @return columnName 列名 
	 */
	public String getColumnName() {
		return columnName;
	}

	/** 
	 * 设置列名 
	 * @param columnName 列名 
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
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
	 * 获取JDBC类型 
	 * @return jdbcType JDBC类型 
	 */
	public String getJdbcType() {
		return jdbcType;
	}

	/** 
	 * 设置JDBC类型 
	 * @param jdbcType JDBC类型 
	 */
	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	/** 
	 * 获取JAVA类型 
	 * @return javaType JAVA类型 
	 */
	public String getJavaType() {
		return javaType;
	}

	/** 
	 * 设置JAVA类型 
	 * @param javaType JAVA类型 
	 */
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	/** 
	 * 获取JAVA字段名 
	 * @return javaField JAVA字段名 
	 */
	public String getJavaField() {
		return javaField;
	}

	/** 
	 * 设置JAVA字段名 
	 * @param javaField JAVA字段名 
	 */
	public void setJavaField(String javaField) {
		this.javaField = javaField;
	}

	/** 
	 * 获取是否主键（1：主键） 
	 * @return isPk 是否主键（1：主键） 
	 */
	public String getIsPk() {
		return isPk;
	}

	/** 
	 * 设置是否主键（1：主键） 
	 * @param isPk 是否主键（1：主键） 
	 */
	public void setIsPk(String isPk) {
		this.isPk = isPk;
	}

	/** 
	 * 获取是否可为空（1：可为空；0：不为空） 
	 * @return isNull 是否可为空（1：可为空；0：不为空） 
	 */
	public String getIsNull() {
		return isNull;
	}

	/** 
	 * 设置是否可为空（1：可为空；0：不为空） 
	 * @param isNull 是否可为空（1：可为空；0：不为空） 
	 */
	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	/** 
	 * 获取是否为插入字段（1：插入字段） 
	 * @return isInsert 是否为插入字段（1：插入字段） 
	 */
	public String getIsInsert() {
		return isInsert;
	}

	/** 
	 * 设置是否为插入字段（1：插入字段） 
	 * @param isInsert 是否为插入字段（1：插入字段） 
	 */
	public void setIsInsert(String isInsert) {
		this.isInsert = isInsert;
	}

	/** 
	 * 获取是否编辑字段（1：编辑字段） 
	 * @return isEdit 是否编辑字段（1：编辑字段） 
	 */
	public String getIsEdit() {
		return isEdit;
	}

	/** 
	 * 设置是否编辑字段（1：编辑字段） 
	 * @param isEdit 是否编辑字段（1：编辑字段） 
	 */
	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	/** 
	 * 获取是否列表字段（1：列表字段） 
	 * @return isList 是否列表字段（1：列表字段） 
	 */
	public String getIsList() {
		return isList;
	}

	/** 
	 * 设置是否列表字段（1：列表字段） 
	 * @param isList 是否列表字段（1：列表字段） 
	 */
	public void setIsList(String isList) {
		this.isList = isList;
	}

	/** 
	 * 获取是否查询字段（1：查询字段） 
	 * @return isQuery 是否查询字段（1：查询字段） 
	 */
	public String getIsQuery() {
		return isQuery;
	}

	/** 
	 * 设置是否查询字段（1：查询字段） 
	 * @param isQuery 是否查询字段（1：查询字段） 
	 */
	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}

	/** 
	 * 获取查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE） 
	 * @return queryType 查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE） 
	 */
	public String getQueryType() {
		return queryType;
	}

	/** 
	 * 设置查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE） 
	 * @param queryType 查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE） 
	 */
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	/** 
	 * 获取字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择） 
	 * @return showType 字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择） 
	 */
	public String getShowType() {
		return showType;
	}

	/** 
	 * 设置字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择） 
	 * @param showType 字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择） 
	 */
	public void setShowType(String showType) {
		this.showType = showType;
	}

	/** 
	 * 获取字典类型 
	 * @return dictType 字典类型 
	 */
	public String getDictType() {
		return dictType;
	}

	/** 
	 * 设置字典类型 
	 * @param dictType 字典类型 
	 */
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	/** 
	 * 获取排序（升序） 
	 * @return sort 排序（升序） 
	 */
	public Integer getSort() {
		return sort;
	}

	/** 
	 * 设置排序（升序） 
	 * @param sort 排序（升序） 
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	
}
