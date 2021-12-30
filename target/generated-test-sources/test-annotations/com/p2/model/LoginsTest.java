package com.p2.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginsTest {
		static Logins l, m, n;


		@BeforeClass
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
			assertEquals(l.getStatus(), 2);
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

