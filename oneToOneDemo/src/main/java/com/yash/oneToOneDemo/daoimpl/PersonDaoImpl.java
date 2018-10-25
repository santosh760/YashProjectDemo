package com.yash.oneToOneDemo.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.yash.oneToOneDemo.dao.PersonDao;
import com.yash.oneToOneDemo.domain.Person;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public int addPerson(Person person) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();
			session.save(person);
			System.out.println("saved...");
			session.getTransaction().commit();
			hibernateTemplate.flush();
			return 1;
		} catch (Exception e) {
			System.out.println("Exception Occured " + e);
		}
		return 0;

	}

	public int deletePerson(int Id) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		try {
			session.getTransaction().begin();

			Person person = session.get(Person.class, Id);
			session.delete(person);
			System.out.println("deleted...");
			session.getTransaction().commit();
			hibernateTemplate.flush();
			return 1;

		} catch (Exception e) {
			System.out.println("Exception Occured " + e);
		}
		return 0;

	}

	public List<Person> showAllPerson() {
		List<Person> list = new ArrayList<Person>();

		list = hibernateTemplate.loadAll(Person.class);

		return list;

	}

	public Person searchById(int Id) {
		return null;

	}

	public Person updatePerson(Person person) {
		return person;

	}

}
