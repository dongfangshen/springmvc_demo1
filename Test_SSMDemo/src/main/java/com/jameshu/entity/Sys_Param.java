package com.jameshu.entity;

public class Sys_Param {
	private int id;
	private int attribute; 
	private String attributevalue;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAttribute() {
		return attribute;
	}
	public void setAttribute(int attribute) {
		this.attribute = attribute;
	}
	public String getAttributevalue() {
		return attributevalue;
	}
	public void setAttributevalue(String attributevalue) {
		this.attributevalue = attributevalue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Sys_Param() {
		super();
	}
}
