package com.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.dao.DeviceDao;
import com.mvc.entity.Device;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService{

	private DeviceDao deviceDao;
	@Override
	public List<Device> getAllDevice() {
		// TODO Auto-generated method stub
		List<Device> devices= deviceDao.getAllDevice();
		return devices;
	}

	@Override
	public Device getDevice(int deviceid) {
		// TODO Auto-generated method stub
		Device device= deviceDao.getDevice(deviceid);
		return device;
	}

	@Override
	public int deleteDevice(int deviceid) {
		// TODO Auto-generated method stub
		return deviceDao.deleteDevice(deviceid);
	}

	@Override
	public int updateDevice(Device device) {
		// TODO Auto-generated method stub
		
		return deviceDao.updateDevice(device);
	}

	@Override
	public int createDevice(Device device) {
		// TODO Auto-generated method stub
		// call setOID of SnmpService
		return deviceDao.createDevice(device);
	}

}
