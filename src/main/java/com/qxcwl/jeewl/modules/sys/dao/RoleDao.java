package com.qxcwl.jeewl.modules.sys.dao;

import com.qxcwl.jeewl.common.dao.CrudDao;
import com.qxcwl.jeewl.common.persistence.annotation.MyBatisDao;
import com.qxcwl.jeewl.modules.sys.entity.Role;

/**
 * @Author quxiucheng
 * @ClassName RoleDao
 * @Description
 * @Date 2016/10/18 10:58
 */
@MyBatisDao
public interface RoleDao extends CrudDao<Role> {
}
