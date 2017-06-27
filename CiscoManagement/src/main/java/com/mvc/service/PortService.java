package com.mvc.service;

import java.util.List;

import com.mvc.entity.Port;

public interface PortService {

	public List<Port> getAllPort();
	public List<Port> getPortByDevice(int  iddevice);
	public int deletePort(int  iddevice);
}
