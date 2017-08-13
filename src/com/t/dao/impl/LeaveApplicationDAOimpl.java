package com.t.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.t.dao.LeaveApplicationDAO;
import com.t.entity.LeaveApplication;
@Repository
public class LeaveApplicationDAOimpl implements LeaveApplicationDAO{

	private Session session;

	/**
	 * get Session by spring IOC
	 * @param sessionFactory
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		session = sessionFactory.openSession();
	}
	
	@Override
	public void addLeaveApplication(LeaveApplication leaveApplication) {
		
		session.saveOrUpdate(leaveApplication);
		session.beginTransaction().commit();
		session.close();
	}


	@Override
	public List<LeaveApplication> getStudentLeaveApplication(int stuId) {
		final String hql = "from LeaveApplication where asker_id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", stuId);
		return query.list();
	}

}
