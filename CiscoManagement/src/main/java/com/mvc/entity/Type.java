package com.mvc.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Type {

	private int id;
	private String nameType;
	/*@JsonCreator
	public Type(@JsonProperty("id") int id, @JsonProperty("nameType")String nameType) {
		super();
		this.id = id;
		this.nameType = nameType;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameType() {
		return nameType;
	}
	public void setNameType(String nameType) {
		this.nameType = nameType;
	}
	
}
