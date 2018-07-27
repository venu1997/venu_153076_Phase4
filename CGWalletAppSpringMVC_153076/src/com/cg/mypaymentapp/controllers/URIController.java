package com.cg.mypaymentapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.mypaymentapp.beans.Customer;

@Controller
public class URIController 
{
	@RequestMapping(value="/")
	public String getIndexPage()
	{
		return "IndexPage";
	}
	
	@RequestMapping(value="/login")
	public String getILoginPage()
	{
		return "LoginPage";
	}
	
	@RequestMapping(value="/register")
	public String getRegisterPage()
	{
		return "RegistrationPage";
	}
	
	@RequestMapping(value="/Showbalance")
	public String getBalancePage()
	{
		return "ShowBalance";
	}
	
	@RequestMapping(value="/withdraw")
	public String getWithdrawPage()
	{
		return "Withdraw";
	}
	
	@RequestMapping(value="/deposit")
	public String getDepositPage()
	{
		return "Deposit";
	}
	
	@RequestMapping(value="/transferFunds")
	public String getTransferPage()
	{
		return "TransferFunds";
	}
	
	@RequestMapping(value="/transactionHistory")
	public String getTransactionHistoryPage()
	{
		return "TransactionHistory";
	}
	
	@ModelAttribute("customer")
	public Customer getCustomer()
	{
		return new Customer();
	}
}
