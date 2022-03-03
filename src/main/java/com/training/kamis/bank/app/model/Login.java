package com.training.kamis.bank.app.model;

import java.util.Objects;

public class Login {

	private int loginId;
	private String username;
	private String password;
	private String email;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(int loginId, String username, String password) {
		super();
		this.loginId = loginId;
		this.username = username;
		this.password = password;
	}

	public Login(int loginId, String username, String password, String email) {
		super();
		this.loginId = loginId;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, loginId, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return Objects.equals(email, other.email) && loginId == other.loginId
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", username=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}
	
}
