package com.mvc.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Port {

	private Integer portId;
	private String portName;
	private Integer status;
	private Integer iddevice;
	/*@JsonCreator
	public Port(@JsonProperty("portId")Integer portId,@JsonProperty("portName") String portName,
			@JsonProperty("status")Integer status,@JsonProperty("iddevice") Integer iddevice) {
		super();
		this.portId = portId;
		this.portName = portName;
		this.status = status;
		this.iddevice = iddevice;
	}*/
	public Integer getPortId() {
		return portId;
	}
	public void setPortId(Integer portId) {
		this.portId = portId;
	}
	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIddevice() {
		return iddevice;
	}
	public void setIddevice(Integer iddevice) {
		this.iddevice = iddevice;
	}
}
