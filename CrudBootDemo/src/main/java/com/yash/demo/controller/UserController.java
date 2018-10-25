package com.yash.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.demo.model.User;
import com.yash.demo.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public int addUser(@RequestBody User user) {
		
		return service.addUser(user);
	}
}
