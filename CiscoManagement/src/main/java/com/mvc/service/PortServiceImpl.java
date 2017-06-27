package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.PortDao;
import com.mvc.entity.Port;

@Service("portService")
public class PortServiceImpl implements PortService{

	@Autowired
	private PortDao portDao;
	@Override
	public List<Port> getAllPort() {
		// TODO Auto-generated method stub
		List<Port> ports= portDao.getAllPort();
		return ports;
	}

	@Override
	public List<Port> getPortByDevice(int iddevice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePort(int iddevice) {
		// TODO Auto-generated method stub
		return portDao.deletePort(iddevice);
		
	}

}
