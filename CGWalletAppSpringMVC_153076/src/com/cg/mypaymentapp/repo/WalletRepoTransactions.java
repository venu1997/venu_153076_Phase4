package com.cg.mypaymentapp.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.mypaymentapp.beans.TransactionHistory;

public interface WalletRepoTransactions extends JpaRepository<TransactionHistory, Integer>{
	
	
	List<TransactionHistory> findByMobileno(String mobileno);
	

}
