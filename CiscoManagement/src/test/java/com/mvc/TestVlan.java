package com.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mvc.entity.Vlan;
import com.mvc.dao.*;


public class TestVlan {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("spring-config-mvc.xml");
		VlanDao vlanDao = context.getBean(VlanDao.class);	
		vlanDao.chooseDeviceOnVlan(3, 41);
		/*List<Vlan> lists= new ArrayList<Vlan>();
		lists=(List<Vlan>) vlanDao.getAllVlan();
		System.out.println("-----VIEW LIST------");
		if(lists.size()==0){
			System.out.println("No structure!");
		}else{
			for(Vlan i : lists){
				System.out.println("-----------");
				System.out.println("vlan id: "+i.getVlanId());
				System.out.println("vlan number: "+i.getVlanNum());
				System.out.println("vlan description: "+i.getVlanDct());
				System.out.println("vlan type: "+i.getVlanType());
			}
		}*/
	}
}
