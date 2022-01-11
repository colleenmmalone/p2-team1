package com.p2.driver.ordercontents;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.p2.driver.orders.Orders;


public class OrderContentsTest {
		static OrderContents l, m, n;
		static Orders o;


		@BeforeAll
		public static void setUpBeforeClass() throws Exception {
			l = new OrderContents();	
			m = new OrderContents();	
			n = new OrderContents();	
			o = new Orders();

		}
		
		@Test void equalsTest() {
			assertEquals(n, m);
			assertEquals(m.hashCode(), n.hashCode());
		}
		
		@Test
		public void testFirst() {
			l.setItem("hi");
			assertEquals(l.getItem(), "hi");
		}
		
		@Test
		public void testLast() {
			l.setOrderid(3);
			assertEquals(l.getOrderid(), 3);
		}
		
		@Test
		public void testEmail() {
			l.setQuantity(4);
			assertEquals(l.getQuantity(), 4);
		}
		
		@Test
		public void testPswd() {
			l.setOrdercontentsid(8);
			assertEquals(l.getOrdercontentsid(), 8);
		}
		
		@Test
		public void testId() {
			l.setOrders(o);
			assertEquals(l.getOrders(), o);
		}
		
		@Test
		public void testStatus() {
			l.setPrice(7.89);
			assertEquals(l.getPrice(), 7.89);
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
