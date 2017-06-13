package com.mvc.dao;

import java.util.List;

import com.mvc.entity.Device;

public interface DeviceDao {

	public List<Device> getAllDevice();
	 public Device getDevice(int deviceid);
	 public int deleteDevice(int deviceid); 
	 public int updateDevice(Device device);
	 public int createDevice(Device device); 
}
