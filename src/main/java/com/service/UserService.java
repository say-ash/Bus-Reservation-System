package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.InterfaceUserDao;
import com.model.Login;
import com.model.User;

@Service
public class UserService implements InterfaceUserService {

	@Autowired
	private InterfaceUserDao userDao;
	
	public int saveUser(User r) {
		return userDao.saveUser(r);
	}
	
	public int validateUser(Login l) {
		return userDao.validateUser(l);
	}

	


}
