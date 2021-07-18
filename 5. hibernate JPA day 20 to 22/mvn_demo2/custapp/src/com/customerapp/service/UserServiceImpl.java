package com.customerapp.service;

import com.customerapp.dao.user.User;
import com.customerapp.dao.user.UserDao;
import com.customerapp.dao.user.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	
	public UserServiceImpl() {
		userDao=new UserDaoImpl();
	}

	@Override
	public void addUser(User user) {
		//spring vs EJB
		//more code related to ccc (cross cutting conern)
		//logging log4j, declerative tx, dec security, caching...
		userDao.addUser(user);
	}

	@Override
	public User getUser(String username, String password) {
		return userDao.getUser(username, password);
	}

}
