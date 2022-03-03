package com.training.kamis.bank.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeDAOImplTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

		EmployeeDAO employeeDAO;
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		employeeDAO = new EmployeeDAOImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	
	}

	@Test
	@DisplayName( "Testing to see if employeeID is valid")
	void testdoesEmployeeExist() {
		int employeeID = 102;
		boolean actual = employeeDAO.doesEmployeeExist(employeeID);
		assertTrue(actual);
	}
	
	@Test
	@DisplayName( "Testing to see if employeeID is valid")
	void testdoesEmploeeExist() {
			int employeeID = 102;
			boolean actual = employeeDAO.doesEmployeeExist(employeeID);
			assertTrue(actual);
		}
	

}
