package com.qxcwl.jeewl.modules.sys.dao;

import com.qxcwl.jeewl.common.dao.CrudDao;
import com.qxcwl.jeewl.common.persistence.annotation.MyBatisDao;
import com.qxcwl.jeewl.modules.sys.entity.Menu;

/**
 * 菜单
 * @ClassName MenuDao
 * @Description 
 * @author 曲修成
 * @date 2016年8月4日 下午4:07:32
 */
@MyBatisDao
public interface MenuDao extends CrudDao<Menu> {
	
}
