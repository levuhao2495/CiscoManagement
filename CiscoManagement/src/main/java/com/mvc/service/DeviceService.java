package com.mvc.service;

import java.util.List;

import com.mvc.entity.Device;

public interface DeviceService {

	public List<Device> getAllDevice();
	 public Device getDevice(int deviceid);
	 public int deleteDevice(int deviceid); 
	 public int updateDevice(Device device);
	 public int createDevice(Device	device); 
}
