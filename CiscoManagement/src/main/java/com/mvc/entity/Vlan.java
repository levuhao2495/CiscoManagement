package com.mvc.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vlan {

	private int vlanId;
	private int vlanNum;
	private String vlanDct;
	private String vlanType;
	/*
	public Vlan(int vlanId, int vlanNum,
			 String vlanDct, String vlanType) {
		super();
		this.vlanId = vlanId;
		this.vlanNum = vlanNum;
		this.vlanDct = vlanDct;
		this.vlanType = vlanType;
	}*/
	public int getVlanId() {
		return vlanId;
	}
	public void setVlanId(Integer vlanId) {
		this.vlanId = vlanId;
	}
	public int getVlanNum() {
		return vlanNum;
	}
	public void setVlanNum(Integer vlanNum) {
		this.vlanNum = vlanNum;
	}
	public String getVlanDct() {
		return vlanDct;
	}
	public void setVlanDct(String vlanDct) {
		this.vlanDct = vlanDct;
	}
	public String getVlanType() {
		return vlanType;
	}
	public void setVlanType(String vlanType) {
		this.vlanType = vlanType;
	}
	
}
