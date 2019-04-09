package com.showtime.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.showtime.dao.UserDao;
import com.showtime.pojo.User;
import com.showtime.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User selectOneUser(String username, String password) {
		return userDao.selectOneUser(username, password);
	}

	public void insertOneUser(String username, String password) {
		userDao.insertOneUser(username, password);		
	}

	public String selectUsername(String username) {
		return userDao.selectUsername(username);
	}

}
