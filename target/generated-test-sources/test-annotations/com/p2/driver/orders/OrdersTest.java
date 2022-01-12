package com.p2.driver.orders;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.p2.driver.logins.Logins;
import com.p2.driver.ordercontents.OrderContents;

public class OrdersTest {
		static Orders l, m, n;


		@BeforeAll
		public static void setUpBeforeClass() throws Exception {
			l = new Orders(2, 3, 6.31, new Date(), "PENDING");
			m = new Orders();
			n = new Orders();
		}
		
		@Test void equalsTest() {
			assertEquals(n, m);
			assertEquals(m.hashCode(), n.hashCode());
		}
		
		@Test
		public void testFirst() {
			l.setCustomer(99);
			assertEquals(l.getCustomer(), 99);
		}
		
		@Test
		public void testLast() {
			l.setLogins(new Logins());
			assertEquals(l.getLogins(), new Logins());
		}
		
		@Test
		public void testEmail() {
			l.setOrderContents(new ArrayList<OrderContents>());
			assertEquals(l.getOrderContents(), new ArrayList<OrderContents>());
		}
		
		@Test
		public void testPswd() {
			l.setOrderDate(new Date());
			assertEquals(l.getOrderDate(), new Date());
		}
		
		@Test
		public void testId() {
			l.setOrderid(2);
			assertEquals(l.getOrderid(), 2);
		}
		
		@Test
		public void testStatus() {
			l.setOrderStatus("fishie");
			assertEquals(l.getOrderStatus(), "fishie");
		}
		
		@Test
		public void testTotal() {
			l.setTotal(5.67);
			assertEquals(l.getTotal(), 5.67);
		}
		
		@Test
		public void toStringTest() {
			assertNotNull(l.toString());
		}	

		@Test
		public void Should_Pass_All_Pojo_Tests() {
		    // given
		    final Class<OrderContents> classUnderTest = OrderContents.class;

		  assertNotNull(classUnderTest);
		}
	

	}
