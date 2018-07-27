package com.cg.mypaymentapp.beans;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transaction_History")
public class TransactionHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	
	
	private String mobileno;
	private String details;
	
	public TransactionHistory() 
	{
		
	}
	public TransactionHistory(String mobileno,String details) {
		super();
		this.mobileno=mobileno;
		this.details=details;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return  details;
	}
	
	
}
