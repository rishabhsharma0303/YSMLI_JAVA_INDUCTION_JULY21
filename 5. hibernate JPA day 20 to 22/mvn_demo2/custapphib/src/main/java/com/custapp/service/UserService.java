package com.custapp.service;

import com.custapp.dao.user.User;

public interface UserService {
	public void addUser(User user);
	public User getUser(String username, String password);
}
