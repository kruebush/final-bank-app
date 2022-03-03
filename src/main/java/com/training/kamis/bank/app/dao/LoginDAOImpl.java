package com.training.kamis.bank.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.training.kamis.bank.app.model.Login;
import com.training.kamis.bank.app.utility.DBConnection;



public class LoginDAOImpl implements LoginDAO {
	Connection connection = DBConnection.getConnection();
	

///may go back and change age to email!!!
	public boolean register(Login login) {
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into logininfo values (?,?,default,?)");
			statement.setString(1, login.getUsername());
			statement.setString(2, login.getPassword());
			statement.setString(3, login.getEmail());

			rows = statement.executeUpdate();
			System.out.println( rows + " user registered successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean validateC(String username, String password) {
		boolean userValid = false;
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from customerinfo where username = ? and password = ? ");
			stat.setString(1, username);
			stat.setString(2, password);
			
			stat = connection.prepareStatement("select * from logininfo where username = ? and password = ? ");
			stat.setString(1, username);
			stat.setString(2, password);

			ResultSet res = stat.executeQuery();
			userValid = res.next();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userValid;
	}
	@Override
	public boolean validateE(String username, String password) {
		boolean userValid = false;
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from employee_data where empusername = ? and emppassword = ? ");
			stat.setString(1, username);
			stat.setString(2, password);

			ResultSet res = stat.executeQuery();
			userValid = res.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userValid;
	}


}



