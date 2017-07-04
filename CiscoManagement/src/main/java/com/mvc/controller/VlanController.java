package com.mvc.controller;

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

import com.mvc.entity.*;
import com.mvc.dao.VlanDao;


@RestController(value="apivlan")
public class VlanController {

	@Autowired
	private VlanDao vlanDao;
	//get all vlans
	@RequestMapping(value = "/vlan", method = RequestMethod.GET, produces="application/json")
	 public ResponseEntity<List<Vlan>> getAllVlan() {

	  HttpHeaders headers = new HttpHeaders();
	  List<Vlan> vlans = vlanDao.getAllVlan();
	  if (vlans == null) {
	   return new ResponseEntity<List<Vlan>>(HttpStatus.NOT_FOUND);
	  }
	  headers.add("Number Of Records Found", String.valueOf(vlans.size()));
	  return new ResponseEntity<List<Vlan>>(vlans, headers, HttpStatus.OK);
	 }
	
	//get one vlan
	@RequestMapping(value = "/vlan/{vlanid}", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Vlan> getVlan(@PathVariable("vlanid") int vlanid){
		Vlan vlan= vlanDao.getVlan(vlanid);
		if(vlan == null){
			return new ResponseEntity<Vlan>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Vlan>(vlan, HttpStatus.OK);		
	}
	//create vlan
	@RequestMapping(value = "/vlan", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Vlan> createVlan(@RequestBody Vlan vlan) {
		HttpHeaders headers = new HttpHeaders();
		if (vlan == null) {
			return new ResponseEntity<Vlan>(HttpStatus.BAD_REQUEST);
		}
		vlanDao.createVlan(vlan);
		// function choose device work on vlan
		headers.add("Vlan Created  - ", String.valueOf(vlan.getVlanId()));
		return new ResponseEntity<Vlan>(vlan, headers, HttpStatus.CREATED);
	}
	
	//create vlan and choose device
	/*@RequestMapping(value = "/vlandevice", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Vlan> createVlanChooseDevice(@RequestBody Vlan vlan,@RequestBody List<VlanDetails> list) {
		HttpHeaders headers = new HttpHeaders();
		if (vlan == null) {
			return new ResponseEntity<Vlan>(HttpStatus.BAD_REQUEST);
		}
		vlanDao.createVlan(vlan);
		//function choose device work on vlan
		try{
			for(VlanDetails iDetails : list){
				vlanDao.chooseDeviceOnVlan(iDetails.getIdVlan(), iDetails.getIdDevice());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		headers.add("Vlan Created  - ", String.valueOf(vlan.getVlanId()));
		return new ResponseEntity<Vlan>(vlan, headers, HttpStatus.CREATED);
	}*/
	
	// delete vlan
	 @RequestMapping(value = "/vlan/{vlanid}", method = RequestMethod.DELETE , produces = "application/json")
	 public ResponseEntity<Vlan> deleteVlan(@PathVariable("vlanid") int vlanid) {
	  HttpHeaders headers = new HttpHeaders();
	  Vlan vlan = vlanDao.getVlan(vlanid);
	  if (vlan == null) {   
	   return new ResponseEntity<Vlan>(HttpStatus.NOT_FOUND);
	  }
	  try{
		  vlanDao.deleteDeviceVlan(vlanid);
		  vlanDao.deleteVlan(vlanid);
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  
	  headers.add("Vlan Deleted - ", String.valueOf(vlanid));
	  return new ResponseEntity<Vlan>(vlan, headers, HttpStatus.NO_CONTENT);
	 }
	 
	 // update vlan
	 @RequestMapping(value = "/vlan/{vlanid}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	 public ResponseEntity<Vlan> updateVlan(@PathVariable("vlanid") int vlanid, @RequestBody Vlan vlan) {
	  HttpHeaders headers = new HttpHeaders();
	  Vlan isExist = vlanDao.getVlan(vlanid);
	  if (isExist == null) {   
	   return new ResponseEntity<Vlan>(HttpStatus.NOT_FOUND);
	  } else if (vlan == null) {
	   return new ResponseEntity<Vlan>(HttpStatus.BAD_REQUEST);
	  }
	  vlanDao.updateVlan(vlan);
	  headers.add("Vlan Updated  - ", String.valueOf(vlanid));
	  return new ResponseEntity<Vlan>(vlan, headers, HttpStatus.OK);
	 }
	
	
}
