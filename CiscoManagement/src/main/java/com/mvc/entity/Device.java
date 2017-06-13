package com.mvc.entity;

public class Device {

	private int m_deviceid;
	private String m_ip;
	private String m_mac;
	private String m_name;
	private int m_type;
	private String m_version;
	private String m_snmpv;
	private String m_snmpr;
	private String m_snmpw;

	public Device(){
		
	}
	public Device(int deviceid, String ip, String mac, String name, int type, String version, String snmpv,
			String snmpr, String snmpw) {
		super();
		this.m_deviceid = deviceid;
		this.m_ip = ip;
		this.m_mac = mac;
		this.m_name = name;
		this.m_type = type;
		this.m_version = version;
		this.m_snmpv = snmpv;
		this.m_snmpr = snmpr;
		this.m_snmpw = snmpw;
	}
	public int getDeviceid() {
		return m_deviceid;
	}
	public void setDeviceid(int deviceid) {
		this.m_deviceid = deviceid;
	}

	public String getIp() {
		return m_ip;
	}
	public void setIp(String ip) {
		this.m_ip = ip;
	}
	public String getMac() {
		return m_mac;
	}
	public void setMac(String mac) {
		this.m_mac = mac;
	}
	public String getName() {
		return m_name;
	}
	public void setName(String name) {
		this.m_name = name;
	}
	public int getType() {
		return m_type;
	}
	public void setType(int type) {
		this.m_type = type;
	}
	public String getVersion() {
		return m_version;
	}
	public void setVersion(String version) {
		this.m_version = version;
	}
	public String getSnmpv() {
		return m_snmpv;
	}
	public void setSnmpv(String snmpv) {
		this.m_snmpv = snmpv;
	}
	public String getSnmpr() {
		return m_snmpr;
	}
	public void setSnmpr(String snmpr) {
		this.m_snmpr = snmpr;
	}
	public String getSnmpw() {
		return m_snmpw;
	}
	public void setSnmpw(String snmpw) {
		this.m_snmpw = snmpw;
	}
}
