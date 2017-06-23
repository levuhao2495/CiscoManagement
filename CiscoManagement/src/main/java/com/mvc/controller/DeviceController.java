package com.mvc.controller;

import java.util.List;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
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
import com.mvc.entity.Device;
import com.mvc.service.DeviceService;


@RestController()
public class DeviceController {

	@Autowired
	// private DeviceService deviceService;
	private  DeviceService m_deviceService;

	// select all device
	 @RequestMapping(value = "/device", method = RequestMethod.GET, produces = "application/json")
	 public ResponseEntity<List<Device>> getAllDevice() {

	  HttpHeaders headers = new HttpHeaders();
	 // List<Device> devices = deviceService.getAllDevice();
	  List<Device> devices = m_deviceService.getAllDevice();
	  if (devices == null) {
	   return new ResponseEntity<List<Device>>(HttpStatus.NOT_FOUND);
	  }
	  headers.add("Number Of Records Found", String.valueOf(devices.size()));
	  return new ResponseEntity<List<Device>>(devices, headers, HttpStatus.OK);
	  
	 }
	 
	 
	 //get device by id
	 @RequestMapping(value="/device/{id}", method=RequestMethod.GET, produces ="application/json")
	 public ResponseEntity<Device> getDevice(@PathVariable("id") int deviceId){
		Device device= m_deviceService.getDevice(deviceId);
		if(device == null){
			return new ResponseEntity<Device>( HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<Device>(device, HttpStatus.OK); 
	 }
	 
	 // delete device by id
	 @RequestMapping(value="/device/{id}", method= RequestMethod.DELETE)
	 public ResponseEntity<Device> deleteDevice(@PathVariable("id") int deviceId){
		 Device device= m_deviceService.getDevice(deviceId);	
		 if(device ==null ){
			 return new ResponseEntity<Device>(HttpStatus.NOT_FOUND);
		 }
		 HttpHeaders headers = new HttpHeaders();
		 headers.add("Deleted device - ", String.valueOf(deviceId));
		 m_deviceService.deleteDevice(deviceId);
		 return new ResponseEntity<Device>(device,headers,HttpStatus.NO_CONTENT);	 
	 }
	 
	 // update name and snmp community
	 
	 @RequestMapping(value= "/device/{id}", method= RequestMethod.PUT)
	 public ResponseEntity<Device> updateDevice(@PathVariable ("id") int deviceId, @RequestBody Device device){
		HttpHeaders headers = new HttpHeaders();		
		if(m_deviceService.getDevice(deviceId) == null){
			return new ResponseEntity<Device>(HttpStatus.NOT_FOUND);
		}else if(device == null){
			return new ResponseEntity<Device>(HttpStatus.BAD_REQUEST);		
		}
		m_deviceService.updateDevice(device);
		headers.add("Updated device - ", String.valueOf(deviceId));
		 return new ResponseEntity<Device>(device, headers, HttpStatus.OK);		 	  
	 }	
	 // create device
	 @RequestMapping(value = "/device", method = RequestMethod.POST, produces = "application/json")
	 public ResponseEntity<Device> createDevice(@RequestBody Device device){	 
		 HttpHeaders headers= new HttpHeaders();
		 if(device == null){
			 return new ResponseEntity<Device>(HttpStatus.BAD_REQUEST);
		 }
		 m_deviceService.createDevice(device);
		 headers.add("Device added - ", String.valueOf(device.getDeviceid()));
		 return new ResponseEntity<Device>(device, headers,HttpStatus.CREATED);		 
	 }
}


