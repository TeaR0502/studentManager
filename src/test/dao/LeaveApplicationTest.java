package test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.t.dao.LeaveApplicationDAO;
import com.t.entity.LeaveApplication;

public class LeaveApplicationTest {
	BeanFactory bf = null;
	@Before
	public void beanSession() {
		bf = new ClassPathXmlApplicationContext("spring.xml");
	}
	@Test
	public void testQueryStudentList() {
		LeaveApplicationDAO leaveApplicationDAO = bf.getBean(LeaveApplicationDAO.class);
		List<LeaveApplication> leaveApplications = leaveApplicationDAO.getStudentLeaveApplication(12);
		for (LeaveApplication leaveApplication : leaveApplications) {
			System.out.println(leaveApplication);
		}
	
	}
}
