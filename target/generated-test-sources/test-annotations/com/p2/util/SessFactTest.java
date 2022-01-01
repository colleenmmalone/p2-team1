package com.p2.util;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.hibernate.Session;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SessFactTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getSessionTest() throws Exception {
		Session s;
			s = HibernateSessFact.getSession();
			assertNotNull(s);

	}

	@Test
	void constructorTest() {
		HibernateSessFact h = new HibernateSessFact();
		assertNotNull(h);
	}

}
