package com.mvc.snmp;

import java.io.IOException;

import org.snmp4j.*;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class SnmpServiceImpl implements SnmpService{

	//  oidValue=".1.3.6.1.2.1.1.5.0"--- sysName
	private static String  community  = "ciscolab";
	private static int    snmpVersion  = SnmpConstants.version2c;
	
	@Override
	public String getOID(String ipAddress, String oid) throws IOException {
		// TODO Auto-generated method stub
		// Create TransportMapping and Listen
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
				PDU pdu= new PDU();
				pdu.add(new VariableBinding(new OID(oid)));
				pdu.setType(PDU.GET);
				pdu.setRequestID(new Integer32(1));
				// Create Snmp object for sending data to Agent
				Snmp snmp = new Snmp(transportMapping);
				ResponseEvent response = snmp.get(pdu, communityTarget);
				return response.getResponse().get(0).getVariable().toString();	
	}

	
	@Override
	public String setOID(String ipAddress, String oid, String value_oid) throws IOException {
		// TODO Auto-generated method stub
		// Create TransportMapping and Listen
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
