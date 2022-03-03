package com.training.kamis.bank.app.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.training.kamis.bank.app.dao.CustomerDAO;
import com.training.kamis.bank.app.dao.CustomerDAOImpl;
import com.training.kamis.bank.app.dao.EmployeeDAO;
import com.training.kamis.bank.app.dao.EmployeeDAOImpl;
import com.training.kamis.bank.app.dao.LoginDAO;
import com.training.kamis.bank.app.dao.LoginDAOImpl;
import com.training.kamis.bank.app.exceptions.ArithmeticExpression;
import com.training.kamis.bank.app.exceptions.InsufficientFundsException;
import com.training.kamis.bank.app.model.Customer;
import com.training.kamis.bank.app.model.Employee;
import com.training.kamis.bank.app.model.Login;

public class BankApp {
	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	// Animal a = new Cat();
	LoginDAO loginDAO = new LoginDAOImpl();
	CustomerDAO customerDAO = new CustomerDAOImpl();
	boolean result;
	Customer customer = new Customer();
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	Employee employee = new Employee();
	List<Customer> customers = new ArrayList<Customer>();

	public void startBankApp() throws IOException {
		// declaring local variables for input
		int employeeID = 0;
		int age = 0;
		String username = null;
		Login login = null;
		int accountNumber = 0;
		String password = null;

		while (true) {
			System.out.println("=======================================================================");
			
			System.out.println("BANK   --  APP  --  MainMenu ");
			System.out.println("1. Login Customer: ");
			System.out.println("2. Login Employee: ");
			System.out.println("3. Register for an Account: ");
			System.out.println("\nPlease enter your menu choice press (1-3): ");
			
			try {
			int pick = scanner.nextInt();
			
			switch (pick) {
///////////////// CASE 1 ON LOGIN PAGE SIGN IN AS A CUSTOMER
		
			case 1:
				
					System.out.println("Please enter your username and password!");
					System.out.println("Username: ");
					username = scanner.next();
					System.out.println("Password: ");
					password = scanner.next();
				if (!loginDAO.validateC(username, password)) {
					System.out.println("The username/password you have entered is incorrect. Please try agian: ");
				} else {
					System.out.print("\nHello! Welcome " + username + " to your bank Customer Menu. \n");
					//////////////////////// OPENS CUSTOMERPAGE
					while (true) {
						System.out.println(
								"\n======================================================================================");
						System.out.println("Customer -- Page -- Menu:");
						System.out.println("1. View Account Balance: ");
						System.out.println("2. Make a Withdrawal: ");
						System.out.println("3. Make a Deposit: ");
						System.out.println("4. Transfers: ");
						System.out.println("5. Add New Account ");
						System.out.println("9. Exit: \n");

						System.out.println("Please enter your command choice(1-6;9) : ");
						try {
						int choice = 0;
						choice = scanner.nextInt();

						float balance = 0;
						int amount = 0;
						int sender = 0;
						int reciever = 0;
						switch (choice) {
						////////////// CASE 1 on CUSTOMER PAGE VIEWING ACCOUNT
						case 1:

							// Search product by accountnumber
							System.out.println("Here you can search for your Account balance!");
							System.out.println("==========================================");
							System.out.println("Please eneter the account you wish to search for: ");
							accountNumber = scanner.nextInt();
							
							if (customerDAO.ifAccountBelongs(accountNumber, username)) {
									System.out.println("Your balance for " + accountNumber + " is: ");
									customerDAO.viewAccount(accountNumber);
							}
							else {
								System.out.println("Sorry that account number does not exist. ");
							}
								
								
							break;

						case 2:
							// Take input to Make a Withdrawal
							System.out.println(
									"To make a withdrawal:\nPlease enter the account you wish to withdrawal from: ");
							accountNumber = scanner.nextInt();
							if (customerDAO.ifAccountBelongs(accountNumber, username)) {
								System.out.println("Please enter the amount you wish to withdrawal: ");
								try {
									amount = scanner.nextInt();
									if (amount < 0) {
										throw new ArithmeticExpression();
									}
									if (amount < balance) {
										throw new InsufficientFundsException();
									}
									else {
										customerDAO.acctwithdrawal(accountNumber, amount);
										System.out.println("The new balance is "); customerDAO.viewAccount(accountNumber);
										}
									} catch (ArithmeticExpression e) {
									System.out.println("Amount can not be less than zero");
									
									}catch (InsufficientFundsException a) {
									System.out.println("Insuficient funds.");
								}
								
							} else {
								System.out.println("Invalid account! Please try agian.");
							}
							break;
				
				////////////add exception hand
						case 3:
							// Take input to deposit
							System.out
									.println("To make a deposit:\nPlease enter the account you wish to deposit into: ");
							accountNumber = scanner.nextInt();
							if (customerDAO.ifAccountBelongs(accountNumber,username)) { 
								System.out.println("Please enter the amount you wish to deposit: ");
								try {
									amount = scanner.nextInt();
									if (amount < 0) {
										throw new ArithmeticExpression();
									}
									
									else {
										customerDAO.acctdeposit(accountNumber, amount);
										System.out.println("The new balance is "); customerDAO.viewAccount(accountNumber);
										}
									} catch (ArithmeticExpression e) {
									System.out.println("Amount can not be less than zero");
								}
							
							}else {
								System.out.println("Invalid account! Please try again.");
							 }
							break;


						case 4:
							/// Can make a transfer here

							System.out.println(
									"To make a trasnfer:\nPlease enter the account you wish to transfer from: ");
							sender = scanner.nextInt();
							if (customerDAO.SenderAcctExist(sender, username)) {
								System.out.println("Please enter the account you wish to transfer too: ");
								reciever = scanner.nextInt();
							try {
								if (customerDAO.RecieverAcctExist(reciever)) {
									System.out.println("Now please enter the account you wish to transfer: ");
									amount = scanner.nextInt();
									if (amount < 0) {
										throw new ArithmeticExpression();
									}
									else {
										customerDAO.Transfer(sender, reciever, amount);
										System.out.println("Your new balance is ");customerDAO.viewAccount(sender);
									}
								}else {
									System.out.println("The account entered does not exist");
								}
								}catch (ArithmeticExpression e) {
									System.out.println("Amount can not be less than zero");
								}
									
								}
							else {
									System.out.println("Sorry incorrect account number please try agian");
							}
							break;

						////// ????????? case 5:
						case 5:
							//// ADD AN ACCOUNT
							System.out.println("\n=====Register for a new account==== ");

							System.out.println("Please enter the balance you will open your account with.");
							balance = scanner.nextFloat();
							System.out.println("Please enter your first name.");
							String first_Name = scanner.next();
							System.out.println("Please enter your last name.");
							String last_Name = scanner.next();
							System.out.println("Please  create a username.");
							String custUsername = scanner.next();
							System.out.println("Please create a password.");
							String cutPassword = scanner.next();
							System.out.println("Please enter a phonenumber");
							String phonenumber = scanner.next();
							if (!loginDAO.validateC(username, password) || !loginDAO.validateE(username, password)) {
								customer = new Customer(accountNumber, balance, first_Name, last_Name, custUsername, cutPassword,
										phonenumber);
								result = customerDAO.createAnAccount(customer);

							} else {
								System.out.println("Sorry we werent able to submit a new account for you at this time");
							}
							break;

						case 9:
							System.out.println("Thanks for using the bank app");
							System.exit(0);
							break;

						default:
							System.out.println("Invalid command choise please enter value 1-6");
							continue;
						}
						}catch(InputMismatchException a ) {
							System.out.println("Sorry invalid input please try agian!");
							scanner.next();
						}
					}

				}
				break;
				
	/////////////// CASE 2 ON EMPLOYEE PAGE SIGN IN AS EMPLOYEE
			case 2:

				System.out.println("Please enter your Employee username and password!");
				System.out.println("Username: ");
				username = scanner.next();
				System.out.println("Password: ");
				password = scanner.next();

				if (!loginDAO.validateE(username, password)) {
					System.out.println("The username/password you have entered is incorrect. Please try agian: ");
				} else {
					System.out.print("\nWelcome " + username + " to Employee Menu");
					////////////// EMPLOYEE PAGE STARTS
					while (true) {

						System.out.println(
								"============================================================================================");
						System.out.println("Employee -- Page -- Menu:");
						System.out.println("1. Search for customer account: ");
						System.out.println("2. Accounts appending arppoval: ");
						System.out.println("3. Transaction Log: ");
						System.out.println("9. Exit: \n");

						System.out.println("Please enter your command choice(1-3;9) : ");
						
						try {
						int select = 0;
						select = scanner.nextInt();

						EmployeeDAO employeeDAO = new EmployeeDAOImpl();

						switch (select) {
						case 1:
							// search for customer account
							//// made a method so that user can only look at there accounts and not all
							// accounts
							System.out.println("To view  an account please enter the account number: ");
							accountNumber = scanner.nextInt();

							if (customerDAO.doesAccountExist(accountNumber)) {
								Customer temp2 = employeeDAO.searchForCustomerAccount(accountNumber);
								System.out.println(temp2);

							} else {
								System.out.println("Sorry invalid account ");
							}
							break;

					
						case 2:
							//// approve or deny an account
							
							System.out.println("To see all accounts awaiting approval enter 1: ");
							int see = scanner.nextInt();
							if (see == 1) {
								customers = employeeDAO.appendingAccounts();
								if (customers.size() == 0) {
									System.out.println("no acccounts");
									continue;
								}
								printCustomerInfo(customers);
							}
							else System.out.println("Thank you");
							System.out.println(
									"===================================================================================");
							System.out.println(
									"If you wish to accept an account/accounts press 'Y' for yes:\nIf you don't want to accept (deny) the account/accounts press 'N' for no :");
							String button = scanner.next();
							if (button.equals("n") ) {
								System.out.println("The account was denied.");
							}
							else if (button.equals("y")) {
								System.out.println("Please enter the username of the account you wish to approve: ");
								username = scanner.next();
								if(customerDAO.doesUsernameExist(username)) {
									employeeDAO.approvingAccounts(username);
									employeeDAO.deleteAfterAproval(username);
								}
								else 
									System.out.println("Username does not exist");
							}
							else 
								System.out.println("Invalid input please try agian");
							break;


						case 3:
							//// Look at all transactions
							System.out.println("To access all transactions please enter yoru employee ID:");
							employeeID = scanner.nextInt();
							if (employeeDAO.doesEmployeeExist(employeeID)) {
								customers = employeeDAO.viewTransactions();

								if (customers.size() == 0) {
									System.out.println("no acccounts");
									continue;
								}
								printCustomerInfo(customers);
							}
							break;

						case 9:
							System.out.println("Thanks for using the bank app");
							System.exit(0);
							break;

						default:
							System.out.println("Invalid command choise please enter value 1-6");
							break;

						}
						}catch (InputMismatchException a ) {
							System.out.println("Invalid input please try agian! ");
							scanner.next();
						}
						
					}

				}
				break;

	//////////////// LOGIN MENU REGISTERING FOR AN ACCOUNT
			case 3:
				System.out.println("=====REGISTER FOR BANK APP ACCOUNT======== ");

				System.out.println("Please create a username and password.");
				System.out.println("Username: ");
				username = scanner.next();
				System.out.println("Password: ");
				password = scanner.next();

				if (!loginDAO.validateC(username, password) || !loginDAO.validateE(username, password)) {
				System.out.println("Please enter an email: ");
				String email = scanner.next();
					login = new Login(-1, username, password);

					loginDAO.register(login);
				}
			else System.out.println("Sorry username is already in use please try agian.");
				break;
				
			
			default:
				System.out.println("Invalid selection please try agian");

				break;
			}
			}catch (InputMismatchException a ) {
				System.out.println("Invalid input please try agian! ");
				scanner.next();
			}
		}
	}

	public void printCustomerInfo(List<Customer> customers) {
		Iterator<Customer> iterator = customers.iterator();
		while (iterator.hasNext()) {
			Customer temp = iterator.next();
			System.out.println(temp);
		}
	}
}
