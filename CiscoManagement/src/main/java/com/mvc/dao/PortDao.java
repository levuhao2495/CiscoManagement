package com.mvc.dao;

import java.util.List;

import com.mvc.entity.Port;

public interface PortDao {

	public List<Port> getAllPort();
	public List<Port> getPortByDevice(int  iddevice);
	
	public int deletePort(int  iddevice);
}