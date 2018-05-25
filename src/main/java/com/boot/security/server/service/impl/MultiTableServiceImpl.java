package com.boot.security.server.service.impl;

import com.boot.security.server.dao.MultiTableDao;
import com.boot.security.server.dao.UserDao;
import com.boot.security.server.dto.UserDto;
import com.boot.security.server.model.SysUser;
import com.boot.security.server.model.SysUser.Status;
import com.boot.security.server.service.MultiTableService;
import com.boot.security.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MultiTableServiceImpl implements MultiTableService {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");

	@Autowired
	private MultiTableDao multiTableDao;


	@Override
	public void changebcrubcount() {

		multiTableDao.updatecount();

		log.info("测试下日志 from changebcrubcount()");
	}

	@Override
	public void changebcrudcountById(Long id) {
		multiTableDao.updatecountbyid(id);

		log.info("测试下日志 from changebcrubcountbyid()");
	}


}
