package com.cg.mypaymentapp.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;


@Entity
@Table(name="Customer_details")
@NamedEntityGraph(name = "joined", includeAllAttributes = true)
public class Customer {
	
	
	@NotEmpty(message="Enter Name")
	private String name;
	
	@Id 
	@NotEmpty(message="Enter Mobile Number")
	@Pattern(regexp = "[1-9][0-9]{9}", message="Mobile Number Should be in 10 digits")
	private String mobileNo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="walletId")
	private Wallet wallet;
	
	
	
	public Customer(String name2, String mobileNo2, Wallet wallet2) {
		name=name2;
		mobileNo=mobileNo2;
		wallet=wallet2;
}
	public Customer() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	
	
	@Override
	public String toString() {
		return "Customer name=" + name + ", mobileNo=" + mobileNo
				 + wallet;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		return true;
	}
	
	
}
