package com.showtime.dao;

import org.apache.ibatis.annotations.Param;

import com.showtime.pojo.User;

public interface UserDao {
	// 登录
	User selectOneUser(@Param("username") String username, @Param("password") String password);

	// 注册
	void insertOneUser(@Param("username") String username, @Param("password") String password);

	// 查找是否有重名
	String selectUsername(@Param("username") String username);
}