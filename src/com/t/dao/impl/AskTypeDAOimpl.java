package com.t.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.t.dao.AskTypeDAO;
import com.t.entity.AskType;

@Repository
public class AskTypeDAOimpl implements AskTypeDAO {
	private Session session;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		session = sessionFactory.openSession();
	}

	@Override
	public void addType(AskType askType) {
		session.saveOrUpdate(askType);
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public List<AskType> queryAllType() {
		final String hql = "from AskType";
		Query query  = session.createQuery(hql);
		return query.list();
	}

	@Override
	public AskType getType(String type) {
		final String hql = "from AskType where ASKTYEP = :type";
		Query query  = session.createQuery(hql);
		query.setParameter("type", type);
		return (AskType) query.uniqueResult();
	}

}
