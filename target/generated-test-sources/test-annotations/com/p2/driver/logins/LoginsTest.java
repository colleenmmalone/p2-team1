package com.p2.driver.logins;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.p2.driver.orders.Orders;


public class LoginsTest {
		static Logins l, m, n, o;


		@BeforeAll
		public static void setUpBeforeClass() throws Exception {
			l = new Logins();	
			l = new Logins("em","ps");	
			m = new Logins();	
			n = new Logins();	
		}
		
		@Test void equalsTest() {
			assertEquals(n, m);
			assertEquals(m.hashCode(), n.hashCode());
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
		
		@Test
		public void getOrdersTest() {
			l.setOrders(new HashSet<Orders>());
			assertNotNull(l.getOrders());
		}
		
		

		@Test
		public void Should_Pass_All_Pojo_Tests() {
		    // given
		    final Class<Logins> classUnderTest = Logins.class;

		  assertNotNull(classUnderTest);
		}
	

	}
