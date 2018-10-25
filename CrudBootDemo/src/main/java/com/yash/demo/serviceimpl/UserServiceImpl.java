package com.yash.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.demo.dao.UserDao;
import com.yash.demo.model.User;
import com.yash.demo.service.UserService;

@Service("service")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	
	@Override
	public int addUser(User user) {
		
		return dao.addUser(user);
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return dao.deleteUser(id);
	}

	@Override
	public List<User> allUser() {
		// TODO Auto-generated method stub
		return dao.allUser();
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return dao.findUserById(id);
	}

}
