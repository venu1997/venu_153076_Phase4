package com.cg.mypaymentapp.beans;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
@Entity
@Table(name="Wallet_details")
public class Wallet {

public Wallet() {
		
	}

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int walletId;


private BigDecimal balance;

public Wallet(BigDecimal amount) {
	this.balance=amount;
}

public BigDecimal getBalance() {
	return balance;
}

public void setBalance(BigDecimal balance) {
	this.balance = balance;
}

@Override
	public String toString() {
	return ", balance="+balance;
}

}

