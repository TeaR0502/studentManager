package test.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.t.dao.UsersDAO;
import com.t.entity.Users;

public class UsersDAOTest {
	BeanFactory bf = null;
	@Before
	public void beanSession() {
		bf = new ClassPathXmlApplicationContext("spring.xml");
	}
	@Test
	public void testQueryUsersByName() {
		UsersDAO usersDAO = bf.getBean(UsersDAO.class);
		Users users = usersDAO.queryUsersByName("0502");
		System.out.println(users);
	}
	
	@Test
	public void testAddStudent() {
		UsersDAO usersDAO = bf.getBean(UsersDAO.class);
		Users teacher = new  Users();
		teacher.setId(3);
		teacher.setUsername("teacher2");
		teacher.setRealname("teacher");
		teacher.setJob("老师");
		
		Users student = new  Users();
		student.setUsername("0502");
		student.setRealname("周乾睿");
		student.setJob("学生");
		student.setTeacher(teacher);
		usersDAO.addStudent(student);
		
	}
	
	@Test
	public void testAddTeacher() {
		UsersDAO usersDAO = bf.getBean(UsersDAO.class);
		Users teacher = new  Users();
		teacher.setUsername("teacher2");
		teacher.setRealname("teacher");
		teacher.setJob("老师");
		
		Users student = new  Users();
		student.setUsername("XiaoMing");
		student.setRealname("小明");
		student.setJob("小明");
		student.setTeacher(teacher);
		usersDAO.addTeacher(teacher);
		
	}

}
