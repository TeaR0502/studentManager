package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.t.entity.AskType;
import com.t.service.AskTypeService;

import sun.awt.image.PixelConverter.Bgrx;

public class AskTypeTest {
	BeanFactory bf = null;
	@Before
	public void beanSession() {
		bf = new ClassPathXmlApplicationContext("spring.xml");
	}
	@Test
	public void getAllType() {
		 AskTypeService askTypeService = bf.getBean(AskTypeService.class);
		 List<AskType> list = askTypeService.queryAll();
		 for (AskType askType : list) {
			System.out.println(askType);
		}
	}
	
}
