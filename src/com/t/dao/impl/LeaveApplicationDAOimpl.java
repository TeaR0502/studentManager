package com.t.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.CacheMode;
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
		System.out.println(leaveApplication);
		session.saveOrUpdate(leaveApplication);
		session.beginTransaction().commit();
	}


	@Override
	public List<LeaveApplication> getStudentLeaveApplication(int stuId) {
		try {
			System.out.println("LADAO!");
			final String hql = "from LeaveApplication where asker_id = :id";
			Query query = session.createQuery(hql);
			query.setCacheMode(CacheMode.IGNORE);
			query.setParameter("id", stuId);
			return query.list();
		} catch (Exception e) {
			System.out.println("出现异常!");
			e.printStackTrace();
			return new LinkedList<LeaveApplication>();
		}
		
	}

	@Override
	public List<LeaveApplication> getTeacherLeaveApplication(String teacher) {
		final String hql = "from LeaveApplication where teacher = :teacher";
		Query query = session.createQuery(hql);
		query.setCacheMode(CacheMode.IGNORE);
		query.setParameter("teacher", teacher);
		return query.list();
	}

	@Override
	public void updateLeaveApplication(String status, int id) {
		LeaveApplication leaveApplication = (LeaveApplication) session.get(LeaveApplication.class, id);
		System.out.println(leaveApplication);
		leaveApplication.setStatus(status);
		session.saveOrUpdate(leaveApplication);
		session.beginTransaction().commit();
	}

}
