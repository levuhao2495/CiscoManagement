package com.mvc.dao;

import java.io.IOException;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.Variable;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class SnmpDaoImpl implements SnmpDao{

	@Autowired
	private static String  community  = "ciscolab";
	private static int    snmpVersion  = SnmpConstants.version2c;
	private TransportMapping transportMapping;
	@Override
	public String getOID(String ipAddress, String oid) throws IOException {
		String rString= null;
		transportMapping = new DefaultUdpTransportMapping();
		transportMapping.listen();
		// Create Target Address object
		CommunityTarget communityTarget= new CommunityTarget();
		communityTarget.setCommunity(new OctetString(community));
		communityTarget.setVersion(snmpVersion);
		communityTarget.setAddress(new UdpAddress(ipAddress + "/161"));
		communityTarget.setRetries(2);
		communityTarget.setTimeout(1000);
		// Create the PDU object
		PDU pdu= new PDU();
		pdu.add(new VariableBinding(new OID(oid)));
		pdu.setType(PDU.GET);
		pdu.setRequestID(new Integer32(1));
		// Create Snmp object for sending data to Agent
		Snmp snmp = new Snmp(transportMapping);
		ResponseEvent response = snmp.get(pdu, communityTarget);	
		PDU responsePDU = response.getResponse();

	      if (responsePDU != null)
	      {
	        int errorStatus = responsePDU.getErrorStatus();
	        int errorIndex = responsePDU.getErrorIndex();
	        String errorStatusText = responsePDU.getErrorStatusText();

	        if (errorStatus == PDU.noError)
	        {
	          //System.out.println("Snmp Get Response = " + responsePDU.getVariableBindings());
	        	rString= response.getResponse().get(0).getVariable().toString();
	        	
	        }
	        else
	        {
	          System.out.println("Error: Request Failed");
	          System.out.println("Error Status = " + errorStatus);
	          System.out.println("Error Index = " + errorIndex);
	          System.out.println("Error Status Text = " + errorStatusText);
	        }
	      }
	      else
	      {
	    	  rString="null";
	      }
		return rString ;			
		
		
	}

	@Override
	public String setOID(String ipAddress, String oid, String value_oid) throws IOException {
		// TODO Auto-generated method stub
		TransportMapping transportMapping = new DefaultUdpTransportMapping();
		transportMapping.listen();
		// Create Target Address object
		CommunityTarget communityTarget= new CommunityTarget();
		communityTarget.setCommunity(new OctetString(community));
		communityTarget.setVersion(snmpVersion);
		communityTarget.setAddress(new UdpAddress(ipAddress + "/161"));
		communityTarget.setRetries(2);
		communityTarget.setTimeout(1000);
		// Create the PDU object
		PDU pdu = new PDU(); 
	    // Setting the Oid and Value for sysContact variable
		OID m_oid = new OID(oid);
		Variable var = new OctetString(value_oid.replace(" ", ""));
		VariableBinding varBind = new VariableBinding(m_oid,var);
		pdu.add(varBind);
		pdu.setType(PDU.SET);
		pdu.setRequestID(new Integer32(1));			
		// Create Snmp object for sending data to Agent
		Snmp snmp = new Snmp(transportMapping);
		ResponseEvent response = snmp.set(pdu, communityTarget);
		return response.getResponse().getVariable(m_oid).toString();
	}

}
