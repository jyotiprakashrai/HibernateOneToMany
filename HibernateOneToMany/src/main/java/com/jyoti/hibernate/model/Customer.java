package com.jyoti.hibernate.model;

public class Customer {
	
	private long id;
	private String custId;
	private String name;
	private String address;
	
	private Branch branch;
	
	//Hibernate requires no-args constructor
	public Customer(){
		
	}
	
	public Customer(String custId, String name, String address, Branch branch){
		
		this.custId=custId;
		this.name=name;
		this.address=address;	
		this.branch=branch;
	}
	
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
