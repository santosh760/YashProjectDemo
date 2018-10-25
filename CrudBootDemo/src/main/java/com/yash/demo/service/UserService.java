package com.yash.demo.service;

import java.util.List;

import com.yash.demo.model.User;

public interface UserService {

	int addUser(User user);

	int deleteUser(int id);

	List<User> allUser();

	User findUserById(int id);
}
