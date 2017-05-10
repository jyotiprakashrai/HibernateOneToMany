package com.jyoti.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMERANNO")
public class CustomerAnno {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="cust_id")
	private String custId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@ManyToOne
	@JoinColumn(name="branch_id", nullable=false)
	private BranchAnno branchAnno;
	
	
	
	public CustomerAnno(){
		
	}
	
    public CustomerAnno(String custId, String name, String address ,BranchAnno branchAnno ){
    	
    	this.custId=custId;
    	this.name=name;
    	this.address=address;
    	this.branchAnno=branchAnno;
		
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

	public BranchAnno getBranchAnno() {
		return branchAnno;
	}

	public void setBranchAnno(BranchAnno branchAnno) {
		this.branchAnno = branchAnno;
	}
}
