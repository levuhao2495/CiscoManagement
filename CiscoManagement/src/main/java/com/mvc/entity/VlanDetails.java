package com.mvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VlanDetails {

	private int id;
	private int idVlan;
	private int idDevice;
	/*@JsonIgnoreProperties
	public VlanDetails(@JsonProperty("id")int id,@JsonProperty("idVlan") int idVlan,
			@JsonProperty("idDevice")int idDevice) {
		super();
		this.id = id;
		this.idVlan = idVlan;
		this.idDevice = idDevice;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdVlan() {
		return idVlan;
	}
	public void setIdVlan(int idVlan) {
		this.idVlan = idVlan;
	}
	public int getIdDevice() {
		return idDevice;
	}
	public void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
	}
}
