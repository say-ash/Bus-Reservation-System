package com.service;

import com.model.Login;
import com.model.User;

public interface InterfaceUserService {

	
	public int saveUser(User r);
	public boolean validateUser(Login l);
}
