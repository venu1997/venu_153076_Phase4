
package com.cg.mypaymentapp.service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListenerFactory;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.TransactionHistory;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;
import com.cg.mypaymentapp.repo.WalletRepoTransactions;

@Component(value="walletService")
public class WalletServiceImpl implements WalletService
{

	@Autowired
    private WalletRepo repo;

	@Autowired
	private WalletRepoTransactions transactionRepo;
	
	
	

	public Customer createAccount(Customer customer) 
	{
		if(repo.findOne(customer.getMobileNo()) != null)
			throw new InvalidInputException("Account is Already Created");
		return repo.save(customer);		
	}

	public Customer showBalance(String mobileNo) throws InvalidInputException
	{
		Customer customer=repo.findOne(mobileNo);
		if(customer == null)
			throw new InvalidInputException("Mobile number does not exist");
		return customer;
	}

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InsufficientBalanceException,InvalidInputException
	{
		
		Customer source=null;
		Customer target=null;
		
		source=repo.findOne(sourceMobileNo);
        target=repo.findOne(targetMobileNo);
        if(source==null)
        	throw new InvalidInputException("Source mobile number does not exist");
        if(target == null)
        	throw new InvalidInputException("Target mobile number does not exist");
			     		     
			    if(amount.compareTo(new BigDecimal(0)) == 0 )
			    	 throw new InvalidInputException("Enter valid Amount to transfer");
			    if(amount.compareTo(source.getWallet().getBalance()) > 0 )
					throw new InsufficientBalanceException("Insufficient Balance in the account "+sourceMobileNo);
		         
			    source=withdrawAmount(sourceMobileNo, amount);
				target=depositAmount(targetMobileNo, amount);
				return source;
	}           
	             
	public Customer depositAmount(String mobileNo, BigDecimal amount) throws InvalidInputException
	{
		
		Customer customer=null;
			
		customer=repo.findOne(mobileNo);
		if(customer == null)
			throw new InvalidInputException("Mobile number does not exist");
		if(amount.compareTo(new BigDecimal(0)) == 0 )
			throw new InsufficientBalanceException("Enter Valid Amount to Deposit");
		
		
		BigDecimal balance=customer.getWallet().getBalance().add(amount);
		customer.setWallet(new Wallet(balance));
		
		repo.save(customer);
		transactionRepo.save(new TransactionHistory(mobileNo,"Rupees "+amount+" is deposited on "+new Date()));
		
		return customer;
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws InsufficientBalanceException,InvalidInputException
	{
		Customer customer=null;
		customer=repo.findOne(mobileNo);		
		if(customer == null)
			throw new InvalidInputException("Mobile number does not exist");
		
		if(amount.compareTo(new BigDecimal(0)) == 0 )
			throw new InsufficientBalanceException("Enter Valid Amount to Withdraw");
		
		if(amount.compareTo(customer.getWallet().getBalance()) > 0 )
			throw new InsufficientBalanceException("Insufficient Balance");
		
		BigDecimal balance=customer.getWallet().getBalance().subtract(amount);
		customer.setWallet(new Wallet(balance));
		repo.save(customer);
		transactionRepo.save(new TransactionHistory(mobileNo,"Rupees "+amount+" is withdrawn on "+new Date()));
		
		return customer;
	
}

	@Override
	public List<TransactionHistory> printTransactions(String mobileNo)
	{
		List<TransactionHistory> transHistory=null;
		
			transHistory=transactionRepo.findByMobileno(mobileNo);
			
			if(transHistory.isEmpty())
				throw new InvalidInputException("No Transactions made ");
		
		return transHistory;
	}

	@Override
	public boolean checkAccount(Customer customer) 
	{
		Customer customer1=repo.findOne(customer.getMobileNo());
		if(customer1==null)
			throw new InvalidInputException("There is No Account created with this Mobile Number");
		return true;
	}
	
		@Override
	public List<Customer> printAllCustomer() {
	
		return repo.findAll();
	}

	@Override
	public List<Customer> minimumBalance() {
		
		return repo.findbyBalance(new BigDecimal(1000));
		
	}



}