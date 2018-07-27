package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.NamedEntityGraph;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.mypaymentapp.beans.Customer;


public interface WalletRepo extends JpaRepository<Customer, String>{

	@Query("select c from Customer c")
	public List<Customer> findAll();
	
	@EntityGraph(value = "joined")
	@Query("select c from Customer c where c.wallet.balance <= ?1")
	public List<Customer> findbyBalance(BigDecimal bigDecimal);
}
