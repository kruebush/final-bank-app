package com.training.kamis.bank.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerDAOImplTest3 {

	
	CustomerDAO customerDAO;
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		customerDAO = new CustomerDAOImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing if an account exists 1")
	void testDoesAccountExist() {
		int accountnumber = 100700;
		boolean actual = customerDAO.doesAccountExist(accountnumber);
		assertTrue(actual);
	}
	@Test
	@DisplayName("Testing if an account exists 2")
	void testDoesAccountExist1() {
		int accountnumber = 10230;
		boolean actual = customerDAO.doesAccountExist(accountnumber);
		assertFalse(actual);
	}

}
