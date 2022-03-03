package com.training.kamis.bank.app.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.training.kamis.bank.app.model.Customer;
import com.training.kamis.bank.app.utility.DBConnection;




public class CustomerDAOImpl implements CustomerDAO {
		Scanner scanner= new Scanner (System.in);
			Customer customer = new Customer();
			Connection connection = DBConnection.getConnection();

			public Customer viewAccount(int accountNumber) {
				PreparedStatement stat;
				try {
					  
			       stat = connection.prepareStatement(" select * from customerinfo where accountnumber = ?");
			       stat.setInt(1,accountNumber);
			       ResultSet res = stat.executeQuery();
			       
			       while (res.next()) {
			        	System.out.print("$"+res.getFloat(2)+"  ");
			        	
			        }
			  
			       
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
		        
			}
			
		@Override
		public boolean acctwithdrawal( int accountNumber, int amount) {
			PreparedStatement statement = null;
			int row = 0;
			try {
				statement = connection.prepareStatement(
						"update customerinfo set balance = (balance - ?) where accountnumber = ?");
				
				statement.setInt(1, amount);
				statement.setInt(2, accountNumber);

				 row = statement.executeUpdate();
				 if (row >0 ) {
					 System.out.println("Your account was withdrawal of " + "$"+amount);
					 }
					 else {
						 System.out.println("Sorry something went wrong the withdrawal was unsuccessful ");
					 }
				 
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			if (row == 0)
				return false;
			else
				return true;
		
		}
		
		@Override
		
		public boolean acctdeposit(int accountNumber, int amount) {
		
			PreparedStatement statement = null;
			int row = 0;
			try {
				statement = connection.prepareStatement(
						"update customerinfo set balance = (balance+?) where accountnumber = ?");
				
				statement.setInt(1, amount);
				statement.setInt(2, accountNumber);

				 row = statement.executeUpdate();
				 if (row >0 ) {
				 System.out.println("Your account was depostied " +"$"+ amount);
				 }
				 else {
					 System.out.println("Sorry something went wrong the deposit was unsuccessful. ");
				 }

					
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (row == 0)
				return false;
			else
				return true;
			
			}

		@Override
		public boolean Transfer(int sender, int reciever, int amount) {
		
			try {
			CallableStatement stat = connection.prepareCall("call transfer (?, ?, ?)");
			stat.setInt(1,  sender);
			stat.setInt(2,  reciever);
			stat.setInt(3,  amount);
			
			stat.execute();
			
			System.out.println("The transfer was completed");
			
		
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
				
			}
			
		///Special if account exist method used for transfer case only
		
		@Override
		public boolean SenderAcctExist(int sender, String username) {
			boolean senderExist = false;
				PreparedStatement stat;
				try {
					stat = connection.prepareStatement("select * from customerinfo where accountnumber = ? and username = ? ");
					stat.setInt(1, sender);
					stat.setString(2,  username);

					ResultSet res = stat.executeQuery();
					senderExist = res.next();

					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return senderExist;	
			}	
		@Override
		public boolean RecieverAcctExist(int reciever) {
			boolean recieverExist = false;
				PreparedStatement stat;
				try {
					stat = connection.prepareStatement("select * from customerinfo where accountnumber = ?");
					stat.setInt(1, reciever);

					ResultSet res = stat.executeQuery();
					recieverExist = res.next();
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return recieverExist;	
			}	

		@Override
		public boolean doesAccountExist(int accountNumber) {
			boolean accountExist = false;
			PreparedStatement stat;
			try {
				stat = connection.prepareStatement("select * from customerinfo where accountnumber = ? ");
				stat.setInt(1, accountNumber);

				ResultSet res = stat.executeQuery();
				accountExist = res.next();
				
			

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return accountExist;
		}


		@Override
///////	NOT WORKING SAYING I HAVE NULL VALUES
		public boolean createAnAccount(Customer customer) {
			PreparedStatement statement = null;
			int rows=0;
			
			try {
				statement = connection.prepareStatement("insert into appedningAproval values (default,?,?,?,?,?,?)");
				
				statement.setFloat(1, customer.getBalance());
				statement.setString(2, customer.getFirst_Name());
				statement.setString(3, customer.getLast_Name());
				statement.setString(4, customer.getCustUsername());
				statement.setString(5, customer.getCutPassword());
				statement.setString(6, customer.getPhonenumber());
				
				rows = statement.executeUpdate();
				System.out.println( rows + " account has been created and is awaiting aproval.");
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (rows==0)
				return false;
			else
				return true;
		}
////// used to make sure customer only has access to there account 
		@Override
		public boolean ifAccountBelongs(int accountNumber, String username) {
				
			boolean AccountBelong = false;
				PreparedStatement stat;
				try {
					stat = connection.prepareStatement("select * from customerinfo where username = ? and accountnumber = ? ");
					stat.setString(1, username);
					stat.setInt(2, accountNumber);

					ResultSet res = stat.executeQuery();
					AccountBelong = res.next();
			

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return AccountBelong;
		}

		@Override
		public boolean doesUsernameExist(String username) {
			boolean userExist = false;
			PreparedStatement stat;
			try {
				stat = connection.prepareStatement("select * from appedningAproval where username = ? ");
				stat.setString(1, username);

				ResultSet res = stat.executeQuery();
				userExist = res.next();
			
			

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return userExist;
		}
		}
		
		



