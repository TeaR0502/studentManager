package test.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.t.dao.UsersDAO;
import com.t.entity.Users;
import com.t.service.UserService;

public class UsersServiceTest {
	BeanFactory bf = null;
	@Before
	public void beanSession() {
		bf = new ClassPathXmlApplicationContext("spring.xml");
	}
	@Test
	public void testUserLogin() {
		UserService usersService = bf.getBean(UserService.class);
		boolean result = usersService.UsersLogin("XiaoMing","1235456");
		System.out.println(result);
	}
	

}
