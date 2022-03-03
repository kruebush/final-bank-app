package com.training.kamis.bank.app.dao;

import java.util.List;

import com.training.kamis.bank.app.model.Customer;


public interface EmployeeDAO {
	public Customer searchForCustomerAccount( int accountNumber);
	public boolean approvingAccounts (String username);
	public  List<Customer> appendingAccounts();
	public List<Customer> viewTransactions();
	public boolean doesEmployeeExist(int employeeID);
	public boolean deleteAfterAproval (String username);
}
