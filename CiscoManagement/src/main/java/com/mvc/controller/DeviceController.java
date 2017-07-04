package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.dao.DeviceDao;
import com.mvc.dao.PortDao;
import com.mvc.dao.PortDaoImpl;
import com.mvc.entity.Device;
import com.mvc.entity.Port;
import com.mvc.service.DeviceService;
import com.mvc.service.PortService;
import com.mvc.service.PortServiceImpl;
import com.mvc.service.SnmpService;
import com.mvc.service.SnmpServiceImpl;


@RestController(value="apidevice")
//@RequestMapping("apidevice")
public class DeviceController {
	
	@Autowired
	//private DeviceService deviceService;
	private DeviceDao deviceDao;
	private PortService portService;
	private SnmpService snmpService;
	private String OID_Sysname= ".1.3.6.1.2.1.1.5.0";
	//private DeviceDao deviceDao;
	
	// select all device
	 @RequestMapping(value = "/device", method = RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<Device>> getAllDevice() {

	  HttpHeaders headers = new HttpHeaders();
	  List<Device> devices = deviceDao.getAllDevice();
	 // List<Device> devices = deviceService.getAllDevice();
	// xu ly get trang thai cua device: off /on
	  if (devices == null) {
	   return new ResponseEntity<List<Device>>(HttpStatus.NOT_FOUND);
	  }
	  headers.add("Number Of Records Found", String.valueOf(devices.size()));
	  return new ResponseEntity<List<Device>>(devices, headers, HttpStatus.OK);
	 }	 
	 
	 //get device by id
	 @RequestMapping(value="/device/{id}", method=RequestMethod.GET, produces ="application/json")
	 public ResponseEntity<Device> getDevice(@PathVariable("id") int deviceId){
		//Device device= deviceService.getDevice(deviceId);
		 Device device= deviceDao.getDevice(deviceId);
		// xu ly get trang thai cua device: off /on
		if(device == null){
			return new ResponseEntity<Device>( HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<Device>(device, HttpStatus.OK); 
	 }
	 
	 // delete device by id
	@RequestMapping(value="/device/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Device> deleteDevice(@PathVariable("id") int deviceId) {
		//Device device = deviceService.getDevice(deviceId);
		Device device = deviceDao.getDevice(deviceId);
		if (device == null) {
			return new ResponseEntity<Device>(HttpStatus.NOT_FOUND);
		}
		//System.out.println("---------" + device.getDeviceid());
		// viet ham port service delete port	
		//portService = new PortServiceImpl();
		/*List<Port> ports = new ArrayList<Port>();
		ports = portService.getPortByDevice(device.getDeviceid());
		System.out.println("aaaaa---------" + ports);
		for (Port i : ports) {
			// portDao.deletePort(i.getIddevice());
			System.out.println("-------- " + i.getIddevice());
		}*/
		HttpHeaders headers = new HttpHeaders();
		headers.add("Deleted device - ", String.valueOf(deviceId));
		deviceDao.deleteDevice(deviceId);
		//deviceService.deleteDevice(deviceId);
		return new ResponseEntity<Device>(device, headers, HttpStatus.NO_CONTENT);
	}
	 
	 // update name and snmp community 
	 @RequestMapping(value= "/device/{id}", method= RequestMethod.PUT)
	 public ResponseEntity<Device> updateDevice(@PathVariable ("id") int deviceId, @RequestBody Device device) throws IOException{
		HttpHeaders headers = new HttpHeaders();		
		//if(deviceService.getDevice(deviceId) == null){
		if(deviceDao.getDevice(deviceId) == null){
			return new ResponseEntity<Device>(HttpStatus.NOT_FOUND);
		}else if(device == null){
			return new ResponseEntity<Device>(HttpStatus.BAD_REQUEST);		
		}
		//deviceService.updateDevice(device);
		deviceDao.updateDevice(device);
		snmpService= new SnmpServiceImpl();
		snmpService.setOID(device.getIp(),OID_Sysname,device.getName());
		// xu ly them truong hop neu' device dang off
		headers.add("Updated device - ", String.valueOf(deviceId ));
		return new ResponseEntity<Device>(device, headers, HttpStatus.OK);		 	  
	 }	
	 // create device
	 @RequestMapping(value = "/device", method = RequestMethod.POST, produces = "application/json")
	 public ResponseEntity<Device> createDevice(@RequestBody Device device) throws IOException{	 
		 HttpHeaders headers= new HttpHeaders();
		 if(device == null){
			 return new ResponseEntity<Device>(HttpStatus.BAD_REQUEST);
		 }
		// deviceService.createDevice(device);
		 deviceDao.createDevice(device);
		 snmpService= new SnmpServiceImpl();
		 snmpService.setOID(device.getIp(),OID_Sysname,device.getName());
		 // xu ly them truong hop neu' device off hoac dia chi chua duoc tao tren
		 headers.add("Device added - ", String.valueOf(device.getDeviceid()));
		 return new ResponseEntity<Device>(device, headers,HttpStatus.CREATED);		 
	 }
}


