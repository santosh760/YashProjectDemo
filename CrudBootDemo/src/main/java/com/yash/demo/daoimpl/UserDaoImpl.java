package com.yash.demo.daoimpl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yash.demo.dao.UserDao;
import com.yash.demo.model.User;

@Repository("dao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addUser(User user) {
		System.out.println(user);
		
		if(user.getName()==null && (user.getPhone() <0 || user.getPhone() >=10000 )) {
			return 0;
		}
		else {
			sessionFactory.getCurrentSession().save(user);
			System.out.println("saved...");
			return 1;
		}
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> allUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
