package com.mvc.controller;

import java.util.List;

import org.snmp4j.event.ResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.dao.PortDao;
import com.mvc.entity.Device;
import com.mvc.entity.Port;
import com.mvc.service.PortService;

@RestController(value="/apiport")
public class PortController {

	@Autowired
	private PortService portService;
	
	@RequestMapping(value="/port", method=RequestMethod.GET, produces= "application/json")
	public ResponseEntity<List<Port>> getAllPort(){
		HttpHeaders httpHeaders= new HttpHeaders();
		List<Port> ports= portService.getAllPort();
		if(ports == null){
			return new ResponseEntity<List<Port>>(HttpStatus.NOT_FOUND);
		}
		httpHeaders.add("Number Of Records Found", String.valueOf(ports.size()));
		return new ResponseEntity<List<Port>>(ports,httpHeaders,HttpStatus.OK);
	}
	
	 @RequestMapping(value="/port/{deviceid}", method= RequestMethod.DELETE)
	 public ResponseEntity<Port> deleteDevice(@PathVariable("deviceid") int deviceId){
		 List<Port> ports= portService.getPortByDevice(deviceId);	
		 if(ports ==null ){
			 return new ResponseEntity<Port>(HttpStatus.NOT_FOUND);
		 }
		 HttpHeaders headers = new HttpHeaders();
		 headers.add("Deleted device - ", String.valueOf(deviceId));
		 // viet ham port service delete port
		 portService.deletePort(deviceId);
		 return new ResponseEntity<Port>(headers,HttpStatus.NO_CONTENT);	 
	 }
	
}
