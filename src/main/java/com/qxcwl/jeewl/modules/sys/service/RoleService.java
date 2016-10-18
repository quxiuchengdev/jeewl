package com.qxcwl.jeewl.modules.sys.service;

import com.qxcwl.jeewl.common.service.CrudService;
import com.qxcwl.jeewl.modules.sys.dao.RoleDao;
import com.qxcwl.jeewl.modules.sys.entity.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService extends CrudService<RoleDao,Role>{

	@Override
	public int insert(Role role) {
		dao.deleteRoleMenu(role);
		dao.insertRoleMenu(role);
		return super.insert(role);
	}

	@Override
	public int update(Role role) {
		dao.deleteRoleMenu(role);
		dao.insertRoleMenu(role);
		return super.update(role);
	}
}
