package com.qxcwl.jeewl.modules.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qxcwl.jeewl.common.service.CrudService;
import com.qxcwl.jeewl.modules.sys.dao.MenuDao;
import com.qxcwl.jeewl.modules.sys.entity.Menu;

@Service
@Transactional
public class MenuService extends CrudService<MenuDao, Menu>{

	@Autowired
	private MenuDao menuDao;
	
	@Transactional(readOnly = false)
	public void save(Menu menu){
		//menu.setId(IdGen.uuid());
		//menu.setDelFlag(delFlag);
	}
	
}
