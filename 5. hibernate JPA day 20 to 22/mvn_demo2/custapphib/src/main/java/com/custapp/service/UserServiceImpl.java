package com.custapp.service;

import org.hibernate.SessionFactory;

import com.custapp.dao.user.User;
import com.custapp.dao.user.UserDao;
import com.custapp.dao.user.UserDaoImpl;

public class UserServiceImpl implements UserService {
 
	private UserDao userDao;
	
	public UserServiceImpl(SessionFactory factory) {
		userDao=new UserDaoImpl(factory);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public User getUser(String username, String password) {
		return userDao.getUser(username, password);
	}

}
