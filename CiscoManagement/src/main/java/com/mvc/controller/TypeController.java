package com.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.dao.TypeDao;
import com.mvc.entity.Type;


@RestController(value="apitype")
public class TypeController {

	@Autowired
	//private PortService portService;
	private TypeDao typeDao;
	// get type by id
	@RequestMapping(value="/type/{id}", method=RequestMethod.GET, produces= "application/json")
	public ResponseEntity<Type> getTypeById(@PathVariable("id") int idType){
		Type type= typeDao.getType(idType);
		if(typeDao == null){
			return new ResponseEntity<Type>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Type>(type,HttpStatus.OK);
	}
	
}
