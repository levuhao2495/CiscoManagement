package com.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mvc.dao.DeviceDao;
import com.mvc.dao.PortDao;
import com.mvc.entity.Device;
import com.mvc.entity.Port;

public class TestPort {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-config-mvc.xml");
		PortDao portDao = context.getBean(PortDao.class);
		List<Port> ports= new ArrayList<Port>();
		ports=(List<Port>) portDao.getPortByDevice(62);
		System.out.println("-----VIEW LIST------");
		if(ports.size()==0){
			System.out.println("No structure!");
		}else{
			for(Port i : ports){
				System.out.println("-----------");
				System.out.println("portname: "+i.getIddevice());
				
			}
		}
	}
}
