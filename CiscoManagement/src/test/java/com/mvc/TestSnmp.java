package com.mvc;

import java.io.IOException;

import com.mvc.service.SnmpService;
import com.mvc.service.SnmpServiceImpl;

public class TestSnmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ipAddress="192.168.137.13";
		String oidValue=".1.3.6.1.2.1.1.5.0";
		String new_value="router2";
		/* oidValue=".1.3.6.1.2.1.1.5.0" -- sysName
		 * 
		 * 
		 */
		SnmpService snmpService= new SnmpServiceImpl();	
		try {
			//System.out.println(snmpService.getOID(ipAddress, oidValue));
			//System.out.println(snmpService.setOID(ipAddress, oidValue, new_value));
			System.out.println(snmpService.getOID(ipAddress, oidValue));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
