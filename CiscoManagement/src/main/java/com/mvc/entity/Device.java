package com.mvc.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {

	private int deviceId;
	private String ip;
	private String mac;
	private String name;
	private int type;
	private String version;
	private String snmpVersion;
	private String snmpRead;
	private String snmpWrite;

	public Device(){
		
	}
	@JsonCreator
	public Device(@JsonProperty("deviceId") int deviceid,@JsonProperty("ip") String ip,
			@JsonProperty("mac")String mac,@JsonProperty("name") String name,@JsonProperty("type") int type, 
			@JsonProperty("version")String version,@JsonProperty("snmpVersion") String snmpv,
			@JsonProperty("snmpRead")String snmpr, @JsonProperty("snmpWrite")String snmpw) {
		super();
		this.deviceId = deviceid;
		this.ip = ip;
		this.mac = mac;
		this.name = name;
		this.type = type;
		this.version = version;
		this.snmpVersion = snmpv;
		this.snmpRead = snmpr;
		this.snmpWrite = snmpw;
	}
	public int getDeviceid() {
		return deviceId;
	}
	public void setDeviceid(int deviceid) {
		this.deviceId = deviceid;
	}

	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSnmpv() {
		return snmpVersion;
	}
	public void setSnmpv(String snmpv) {
		this.snmpVersion = snmpv;
	}
	public String getSnmpr() {
		return snmpRead;
	}
	public void setSnmpr(String snmpr) {
		this.snmpRead = snmpr;
	}
	public String getSnmpw() {
		return snmpWrite;
	}
	public void setSnmpw(String snmpw) {
		this.snmpWrite = snmpw;
	}
}
