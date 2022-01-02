package com.p2.util;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.hibernate.Session;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HibernateSessFactTest {

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
