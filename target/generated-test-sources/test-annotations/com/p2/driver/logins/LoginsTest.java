package com.p2.driver.logins;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.p2.model.deletewhendone.Logins;

public class LoginsTest {
		static Logins l, m, n;


		@BeforeAll
		public static void setUpBeforeClass() throws Exception {
			l = new Logins("first", "last", "em", "pswd", "status");
			m = new Logins(2,"first", "last", "em", "pswd", "status");
			n = new Logins();		
		}
		
		@Test
		public void testFirst() {
			l.setFirstName("hi");
			assertEquals(l.getFirstName(), "hi");
		}
		
		@Test
		public void testLast() {
			l.setLastName("bye");
			assertEquals(l.getLastName(), "bye");
		}
		
		@Test
		public void testEmail() {
			l.setEmail("e2");
			assertEquals(l.getEmail(), "e2");
		}
		
		@Test
		public void testPswd() {
			l.setPswd("cat");
			assertEquals(l.getPswd(), "cat");
		}
		
		@Test
		public void testId() {
			l.setId(2);
			assertEquals(l.getId(), 2);
		}
		
		@Test
		public void testStatus() {
			l.setStatus("string");
			assertEquals(l.getStatus(), "string");
		}
		
		@Test
		public void toStringTest() {
			assertNotNull(l.toString());
		}


	}

