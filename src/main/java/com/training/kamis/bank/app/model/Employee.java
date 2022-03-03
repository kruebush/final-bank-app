package com.training.kamis.bank.app.model;


public class Employee {

	private int employeeId;
	private String empUsername;
	private String empPassword;
	private String empName;
	private String empEmail;
	
	public Employee () {
		
	}

	public Employee(int employeeId, String empUsername, String empPassword, String empName, String empEmail) {
		super();
		this.employeeId = employeeId;
		this.empUsername = empUsername;
		this.empPassword = empPassword;
		this.empName = empName;
		this.empEmail = empEmail;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpUsername() {
		return empUsername;
	}

	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empEmail == null) ? 0 : empEmail.hashCode());
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((empPassword == null) ? 0 : empPassword.hashCode());
		result = prime * result + ((empUsername == null) ? 0 : empUsername.hashCode());
		result = prime * result + employeeId;
		return result;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empUsername=" + empUsername + ", empPassword=" + empPassword
				+ ", empName=" + empName + ", empEmail=" + empEmail + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empEmail == null) {
			if (other.empEmail != null)
				return false;
		} else if (!empEmail.equals(other.empEmail))
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empPassword == null) {
			if (other.empPassword != null)
				return false;
		} else if (!empPassword.equals(other.empPassword))
			return false;
		if (empUsername == null) {
			if (other.empUsername != null)
				return false;
		} else if (!empUsername.equals(other.empUsername))
			return false;
		if (employeeId != other.employeeId)
			return false;
		return true;
	}
	
}


