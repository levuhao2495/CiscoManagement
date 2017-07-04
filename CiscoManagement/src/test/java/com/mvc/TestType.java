package com.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mvc.dao.TypeDao;
import com.mvc.dao.TypeDaoImpl;
import com.mvc.dao.VlanDao;
import com.mvc.entity.Type;



public class TestType {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-config-mvc.xml");
		TypeDao typeDao = context.getBean(TypeDao.class);	
		Type type= new Type();
		type=typeDao.getType(1);
		System.out.println("----------" + type.getNameType());
	}
}
