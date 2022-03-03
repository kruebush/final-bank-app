package com.training.kamis.bank.app.model;

import java.util.Objects;


public class Customer {

	///VARIABLES THAT A CUSTOMER WILL NEED
	private int accountNumber;
	private  float balance;
	private String first_Name;
	private String last_Name;
	private String custUsername;
	private String cutPassword;
	private String phonenumber;

	
public Customer(){ 
	
}


public Customer(int accountNumber, float balance, String first_Name, String last_Name, String custUsername,
	String cutPassword, String phonenumber) {
super();
this.accountNumber = accountNumber;
this.balance = balance;
this.first_Name = first_Name;
this.last_Name = last_Name;
this.custUsername = custUsername;
this.cutPassword = cutPassword;
this.phonenumber = phonenumber;
}


public Customer(float balance, String first_Name, String last_Name, String custUsername, String cutPassword,
	String phonenumber) {
super();
this.balance = balance;
this.first_Name = first_Name;
this.last_Name = last_Name;
this.custUsername = custUsername;
this.cutPassword = cutPassword;
this.phonenumber = phonenumber;
}


public int getAccountNumber() {
return accountNumber;
}


public void setAccountNumber(int accountNumber) {
this.accountNumber = accountNumber;
}


public float getBalance() {
return balance;
}


public void setBalance(float balance) {
this.balance = balance;
}


public String getFirst_Name() {
return first_Name;
}


public void setFirst_Name(String first_Name) {
this.first_Name = first_Name;
}


public String getLast_Name() {
return last_Name;
}


public void setLast_Name(String last_Name) {
this.last_Name = last_Name;
}


public String getCustUsername() {
return custUsername;
}


public void setCustUsername(String custUsername) {
this.custUsername = custUsername;
}


public String getCutPassword() {
return cutPassword;
}


public void setCutPassword(String cutPassword) {
this.cutPassword = cutPassword;
}


public String getPhonenumber() {
return phonenumber;
}


public void setPhonenumber(String phonenumber) {
this.phonenumber = phonenumber;
}


@Override
public int hashCode() {
return Objects.hash(accountNumber, balance, custUsername, cutPassword, first_Name, last_Name, phonenumber);
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
return accountNumber == other.accountNumber
		&& Float.floatToIntBits(balance) == Float.floatToIntBits(other.balance)
		&& Objects.equals(custUsername, other.custUsername)
		&& Objects.equals(cutPassword, other.cutPassword) && Objects.equals(first_Name, other.first_Name)
		&& Objects.equals(last_Name, other.last_Name) && Objects.equals(phonenumber, other.phonenumber);
}


@Override
public String toString() {
return "Customer [accountNumber=" + accountNumber + ", balance=" + balance + ", first_Name=" + first_Name
		+ ", last_Name=" + last_Name + ", custUsername=" + custUsername + ", cutPassword=" + cutPassword
		+ ", phonenumber=" + phonenumber + "]";
}




}
