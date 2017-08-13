package com.t.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.t.dao.UsersDAO;
import com.t.entity.Users;

@Repository
public class UserDAOimpl implements UsersDAO{

	private Session session;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		session = sessionFactory.openSession();
	}
	@Override
	public void addTeacher(Users user) {
		session.saveOrUpdate(user);
		session.beginTransaction().commit();
		session.close();
	}
	
	@Override
	public void addStudent(Users student) {
		session.saveOrUpdate(student.getTeacher());
		session.saveOrUpdate(student);
		session.beginTransaction().commit();
		session.close();
	}
	@Override
	public Users queryUsersByName(String username) {
		final String hql = "from Users where username = :username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		return (Users) query.uniqueResult();
	}
	
	





	


}
