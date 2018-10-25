package com.yash.demo.test.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.demo.dao.UserDao;
import com.yash.demo.model.User;

public class TestServiceImpl {

	@Mock
	UserDao dao;
	
	@Before
    public void setUp() throws Exception {
         MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testAddUserServiceMethodForPositiveSecenario() throws Exception{
		
		User user=new User(1, "santosh", 5465, "abc@abc.com");
		System.out.println(user);
		when(dao.addUser(user)).thenReturn(user.getId());
		
		int i=dao.addUser(user);
		assertEquals(i,1);
	}
	
	@Test
	public void testAddUserServiceMethodWhenUserIsNull() {
		
		User user=null;
		when(dao.addUser(user)).thenReturn(0);
		
		int i=dao.addUser(user);
		
		
		assertEquals(i,0);
	}
	@Test
	public void testAddUserServiceMethodWhenUserNameIsNull() {
		
		User user=new User(1, null, 5465, "abc@abc.com");
		when(dao.addUser(user)).thenReturn(0);
		
		int i=dao.addUser(user);
		assertEquals(i,0);
	}
	@Test
	public void testAddUserServiceMethodWhenUserPhoneIsNotValid() {
		
		User user=new User(1, "santosh", 0, "abc@abc.com");
		when(dao.addUser(user)).thenReturn(0);
		
		int i=dao.addUser(user);
		assertEquals(i,0);
	}
	
	@Test
	public void testAddUserServiceMethodWhenUserPhoneIsValid() {
		
		User user=new User(1, "santosh", 56, "abc@abc.com");
		when(dao.addUser(user)).thenReturn(1);
		
		int i=dao.addUser(user);
		assertEquals(i,1);
	}
}
