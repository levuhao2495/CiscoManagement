package com.mvc.service;

import java.io.IOException;

import org.snmp4j.*;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.SnmpDao;
import com.mvc.dao.SnmpDaoImpl;

//@Service("snmpService")
public class SnmpServiceImpl implements SnmpService{

	@Autowired
	private SnmpDao snmpDao;
	
	//  oidValue=".1.3.6.1.2.1.1.5.0"--- sysName
	/*private static String  community  = "ciscolab";
	private static int    snmpVersion  = SnmpConstants.version2c;*/
	
	@Override
	public String getOID(String ipAddress, String oid) throws IOException {
		// TODO Auto-generated method stub
		// Create TransportMapping and Listen
		snmpDao= new SnmpDaoImpl();
		return snmpDao.getOID(ipAddress, oid);		
	}

	
	@Override
	public String setOID(String ipAddress, String oid, String value_oid) throws IOException {
		// TODO Auto-generated method stub
		// Create TransportMapping and Listen
		snmpDao= new SnmpDaoImpl();
		return snmpDao.setOID(ipAddress, oid, value_oid);
	}

}
