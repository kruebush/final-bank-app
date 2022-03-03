package com.training.kamis.bank.app.dao;

import com.training.kamis.bank.app.model.Login;

public interface LoginDAO {
	
	public boolean register (Login login);
	public boolean validateC(String username,String password);
	public boolean validateE(String username,String password);
}

