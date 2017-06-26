package com.mvc.dao;

import java.io.IOException;

public interface SnmpDao {

	public String getOID(String ipAddress, String oid) throws IOException;
	public String setOID(String ipAddress, String oid,String value_oid) throws IOException;
}
