package com.jameshu.entity;

public class Sys_Annotation {
	private int id;
	private int clienttype; //这里以后定义一个枚举
	private String author;
	private String method;
	private String module;
	private String service;
	private String input;
	private String output;
	private String descre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClienttype() {
		return clienttype;
	}
	public void setClienttype(int clienttype) {
		this.clienttype = clienttype;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getDescre() {
		return descre;
	}
	public void setDescre(String descre) {
		this.descre = descre;
	}
	public Sys_Annotation() {
		super();
	}
	public Sys_Annotation(int id, int clienttype, String author, String method, String module, String service,
			String input, String output, String descre) {
		super();
		this.id = id;
		this.clienttype = clienttype;
		this.author = author;
		this.method = method;
		this.module = module;
		this.service = service;
		this.input = input;
		this.output = output;
		this.descre = descre;
	}
}
