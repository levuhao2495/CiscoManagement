package com.mvc.entity;

public class Port {

	private Integer portId;
	private String portName;
	private Integer status;
	private Integer iddevice;
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
