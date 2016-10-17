package com.qxcwl.jeewl.common.dao;

import java.util.List;

public interface CrudDao<T> extends BaseDao {
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id);
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity);
	
	/**
	 * 查询数据
	 * @Title findList
	 * @Description 
	 * @author 曲修成
	 * @date 2016年7月1日 下午8:10:09
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);
	
	/**
	 * 插入数据
	 * @Title insert
	 * @Description 
	 * @author 曲修成
	 * @date 2016年7月1日 下午8:10:54
	 * @param entity
	 * @return
	 */
	public int insert(T entity);
	
	/**
	 * 更新数据
	 * @Title update
	 * @Description 
	 * @author 曲修成
	 * @date 2016年7月1日 下午8:11:04
	 * @param entity
	 * @return
	 */
	public int update(T entity);
	
	/**
	 * 删除数据,为逻辑删除
	 * @Title delete
	 * @Description 
	 * @author 曲修成
	 * @date 2016年7月1日 下午8:11:15
	 * @param entity
	 * @return
	 */
	public int delete(T entity);
	
}
