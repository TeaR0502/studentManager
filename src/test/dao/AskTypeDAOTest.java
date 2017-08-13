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
		AskType askType1 = new AskType();
		askType1.setAskTyep("事假");
		askTypeDAO.addType(askType1);
		/*AskType askType2 = new AskType();
		askType2.setAskTyep("病假");
		AskType askType3 = new AskType();
		askType3.setAskTyep("事假");
		
		askTypeDAO.addType(askType2);
		askTypeDAO.addType(askType3);*/
	}
}
