package com.yash.demo.dao;

import java.util.List;

import com.yash.demo.model.User;

public interface UserDao {

	int addUser(User user);
	
	int deleteUser(int id);
	
	List<User> allUser();
	
	User findUserById(int id);
}
