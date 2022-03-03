package com.training.kamis.bank.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.training.kamis.bank.app.model.Customer;
import com.training.kamis.bank.app.utility.DBConnection;


public class EmployeeDAOImpl implements EmployeeDAO {
	Connection connection = DBConnection.getConnection();
	Customer customer = new Customer();

	@Override
	public Customer searchForCustomerAccount(int accountNumber) {
		/// Retrieves all details for a customer minus the password because in real
		/// banks employees cant have access
		System.out.println("##Searching customer account number : " + accountNumber);

		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from customerInfo where accountNumber = ? ");
			stat.setInt(1, accountNumber);

			ResultSet res = stat.executeQuery();
			res.next();
			customer.setAccountNumber(res.getInt(1));
			customer.setBalance(res.getFloat(2));
			customer.setFirst_Name(res.getString(3));
			customer.setLast_Name(res.getString(4));
			customer.setCustUsername(res.getString(5));
			customer.setPhonenumber(res.getString(7));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> appendingAccounts() {

		List<Customer> customers = new ArrayList<Customer>();

		Statement stat;
		try {
			stat = connection.createStatement();

			ResultSet res = stat.executeQuery("select * from appedningAproval  ");
			while (res.next()) {
				Customer customer = new Customer();

				customer.setAccountNumber(res.getInt(1));
				customer.setBalance(res.getFloat(2));
				customer.setFirst_Name(res.getString(3));
				customer.setLast_Name(res.getString(4));
				customer.setCustUsername(res.getString(5));
				customer.setCutPassword(res.getString(6));
				customer.setPhonenumber(res.getString(7));
				customers.add(customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;

	}

	@Override
	public boolean approvingAccounts(String username) {

		System.out.println(username + " has been aproved");
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection
					.prepareStatement("insert into customerinfo select *from appedningaproval where username = ? ");
			statement.setString(1, username);
				

			rows = statement.executeUpdate();
			System.out.println("The account/accounts for " + username+ " were added to the system.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)

			return false;
		else
			return true;
	}

	@Override
	public boolean doesEmployeeExist(int employeeID) {
		boolean employeeExist = false;
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from employee_data where employeeID = ? ");
			stat.setInt(1, employeeID);

			ResultSet res = stat.executeQuery();
			employeeExist = res.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeExist;

	}

	public List<Customer> viewTransactions() {
		System.out.println("==== Printing all Accounts===");
		List<Customer> customers = new ArrayList<Customer>();

		Statement stat;
		try {
			stat = connection.createStatement();

			ResultSet res = stat.executeQuery("select * from customerinfo ");
			while (res.next()) {
				Customer customer = new Customer();
				customer.setAccountNumber(res.getInt(1));
				customer.setBalance(res.getFloat(2));
				customer.setFirst_Name(res.getString(3));
				customer.setLast_Name(res.getString(4));
				customer.setCustUsername(res.getString(5));
				customer.setCutPassword(res.getString(6));
				customer.setPhonenumber(res.getString(7));
				customers.add(customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public boolean deleteAfterAproval(String username) {
		
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("delete from appedningAproval where username = ? ");
			statement.setString(1, username);
			
			
			
			rows = statement.executeUpdate();
			System.out.println(" and has been removed from the appending accounts.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
