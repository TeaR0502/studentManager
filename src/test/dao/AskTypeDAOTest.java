package test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.t.dao.AskTypeDAO;
import com.t.dao.UsersDAO;
import com.t.entity.AskType;
import com.t.entity.Users;

import oracle.net.aso.a;

public class AskTypeDAOTest {
	BeanFactory bf = null;
	@Before
	public void beanSession() {
		bf = new ClassPathXmlApplicationContext("spring.xml");
	}
	@Test
	public void testGetType() {
		AskTypeDAO askTypeDAO = bf.getBean(AskTypeDAO.class);
		AskType askType = askTypeDAO.getType("事假");
		System.out.println(askType);
	}
	
	@Test
	public void testAddType() {
		AskTypeDAO askTypeDAO = bf.getBean(AskTypeDAO.class);
		AskType askType = new AskType();
		askType.setAskTyep("婚假");
		askTypeDAO.addType(askType);
		
	}
}
