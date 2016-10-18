package com.qxcwl.jeewl.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.qxcwl.jeewl.common.dao.CrudDao;
import com.qxcwl.jeewl.common.page.Page;
import com.qxcwl.jeewl.common.persistence.DataEntity;

@Transactional(readOnly = true)
public abstract class CrudService<Dao extends CrudDao<T>, T extends DataEntity<T>> extends BaseService {
	
	@Autowired
	protected Dao dao;
	
	/**
	 * 单个用户
	 * @Title get
	 * @Description 
	 * @author 曲修成
	 * @date 2016年7月1日 下午8:24:51
	 * @param id
	 * @return
	 */
	public T get(String id){
		return dao.get(id);
	}
	
	/**
	 * 分页查询
	 * @Title findPage
	 * @Description 
	 * @author 曲修成
	 * @date 2016年7月1日 下午8:24:58
	 * @param page
	 * @param entity
	 * @return
	 */
	public Page<T> findPage(Page<T> page, T entity) {
		entity.setPage(page);
		page.setList(dao.findList(entity));
		return page;
	}
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}
	
	/**
	 * 插入数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public int insert(T entity) {
		return dao.insert(entity);
	}
	
	/**
	 * 更新数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public int update(T entity) {
		return dao.update(entity);
	}
	
	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void delete(T entity) {
		dao.delete(entity);
	}
	
	
}
