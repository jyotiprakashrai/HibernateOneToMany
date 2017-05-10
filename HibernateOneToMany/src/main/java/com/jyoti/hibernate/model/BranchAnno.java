package com.jyoti.hibernate.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BRANCHANNO")
public class BranchAnno {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="branch_id")
	private long id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="branchAnno")
	private Set<CustomerAnno> customerAnno;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<CustomerAnno> getCustomerAnno() {
		return customerAnno;
	}

	public void setCustomerAnno(Set<CustomerAnno> customerAnno) {
		this.customerAnno = customerAnno;
	}

	

}
