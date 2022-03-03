package com.training.kamis.bank.app.dao;

import com.training.kamis.bank.app.model.Customer;

public interface CustomerDAO {
	public Customer viewAccount(int accountNumber);
	public boolean acctwithdrawal( int accountNumber, int amount);
	public boolean acctdeposit( int accountNumber, int amount);
	public boolean Transfer(int sender, int reciever, int amount);
	public boolean doesAccountExist(int accountNumber);
	public boolean doesUsernameExist(String username);
	public boolean SenderAcctExist(int sender, String username);
	public boolean RecieverAcctExist(int reciever);	
	public boolean createAnAccount( Customer customer);
	public boolean ifAccountBelongs(int accountNumber, String username);
}
