package com.qxcwl.jeewl.modules.sys.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qxcwl.jeewl.common.page.Page;
import com.qxcwl.jeewl.common.service.CrudService;
import com.qxcwl.jeewl.modules.sys.dao.DictDao;
import com.qxcwl.jeewl.modules.sys.entity.Dict;

@Service
@Transactional
public class DictService extends CrudService<DictDao, Dict>{
	
}
