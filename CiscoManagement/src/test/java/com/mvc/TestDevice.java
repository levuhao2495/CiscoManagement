package com.mvc;

import java.util.ArrayList;
import org.springframework.context.*;
import org.springframework.context.support.*;
import java.util.List;

import com.mvc.dao.DeviceDao;
import com.mvc.entity.Device;


public class TestDevice {


	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-config-mvc.xml");
		DeviceDao deviceDao = context.getBean(DeviceDao.class);
		List<Device> listDevice= new ArrayList<Device>();
		listDevice=(List<Device>) deviceDao.getAllDevice();
		System.out.println("-----VIEW LIST------");
		if(listDevice.size()==0){
			System.out.println("No structure!");
		}else{
			for(Device i : listDevice){
				System.out.println("-----"+i+"------");
				System.out.println("Id: "+i.getDeviceid());
				System.out.println("Name: "+i.getIp());
				System.out.println("Author: "+i.getMac());
			}
		}
	}

}

