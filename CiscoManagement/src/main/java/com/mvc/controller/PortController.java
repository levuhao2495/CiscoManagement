package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import org.snmp4j.event.ResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.dao.PortDao;
import com.mvc.entity.Device;
import com.mvc.entity.Port;
import com.mvc.service.PortService;
import com.mvc.service.SnmpService;
import com.mvc.service.SnmpServiceImpl;

@RestController(value="apiport")
public class PortController {

	@Autowired
	//private PortService portService;
	private PortDao portDao;
	private SnmpService snmpService;
	// get all port
	@RequestMapping(value="/port", method=RequestMethod.GET, produces= "application/json")
	public ResponseEntity<List<Port>> getAllPort(){
		HttpHeaders httpHeaders= new HttpHeaders();
		//List<Port> ports= portService.getAllPort();
		List<Port> ports= portDao.getAllPort();
		if(ports == null){
			return new ResponseEntity<List<Port>>(HttpStatus.NOT_FOUND);
		}
		httpHeaders.add("Number Of Records Found", String.valueOf(ports.size()));
		return new ResponseEntity<List<Port>>(ports,httpHeaders,HttpStatus.OK);
	}
	
	// get port by id device
	@RequestMapping(value="/port/{deviceid}", method=RequestMethod.GET, produces= "application/json")
	public ResponseEntity<List<Port>> getPortByDevice(@PathVariable("deviceid") Integer deviceid){
		HttpHeaders httpHeaders= new HttpHeaders();
		//List<Port> ports= portService.getPortByDevice(deviceid);
		List<Port> ports= portDao.getPortByDevice(deviceid);
		if(ports == null){
			return new ResponseEntity<List<Port>>(HttpStatus.NOT_FOUND);
		}
		httpHeaders.add("Number Of Records Found", String.valueOf(ports.size()));
		return new ResponseEntity<List<Port>>(ports,httpHeaders,HttpStatus.OK);
	}
	
	//delete port by id device
	 @RequestMapping(value="/port/{deviceid}", method= RequestMethod.DELETE)
	 public ResponseEntity<Port> deletePortByDevice(@PathVariable("deviceid") Integer deviceId){
		 //List<Port> ports= portService.getPortByDevice(deviceId);
		 List<Port> ports= portDao.getPortByDevice(deviceId);
		 if(ports ==null ){
			 return new ResponseEntity<Port>(HttpStatus.NOT_FOUND);
		 }
		 HttpHeaders headers = new HttpHeaders();
		 headers.add("Deleted port - ", String.valueOf(deviceId));
		 for(Port i: ports){
			 portDao.deletePort(i.getIddevice());
		 }
		 return new ResponseEntity<Port>(headers,HttpStatus.NO_CONTENT);	 
	 }
	 
}
