package com.qxcwl.jeewl.modules.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qxcwl.jeewl.common.service.CrudService;
import com.qxcwl.jeewl.modules.sys.dao.UserDao;
import com.qxcwl.jeewl.modules.sys.entity.User;

@Service
@Transactional
public class UserService extends CrudService<UserDao, User>{

	@Override
	public int insert(User user) {
		dao.deleteUserRole(user);
		dao.insertUserRole(user);
		return super.insert(user);
	}

	@Override
	public int update(User user) {
		dao.deleteUserRole(user);
		dao.insertUserRole(user);
		return super.update(user);
	}
}
