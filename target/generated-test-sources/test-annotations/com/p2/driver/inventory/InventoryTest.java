package com.p2.driver.inventory;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class InventoryTest {
		static Inventory l, m, n, o;


		@BeforeAll
		public static void setUpBeforeClass() throws Exception {
			l = new Inventory();	
			m = new Inventory();	
			n = new Inventory();	
		}
		
		@Test void equalsTest() {
			assertEquals(n, m);
			assertEquals(m.hashCode(), n.hashCode());
		}
		
		@Test
		public void testItemID() {
			l.setItemid(1);
			assertEquals(l.getItemid(), 1);
		}
		
		@Test
		public void testItems() {
			l.setItems("bye");
			assertEquals(l.getItems(), "bye");
		}
		
		@Test
		public void testEmail() {
			l.setStoreImg("e2");
			assertEquals(l.getStoreImg(), "e2");
		}
		
		@Test
		public void testPrice() {
			l.setPrice(3.21);
			assertEquals(l.getPrice(), 3.21);
		}
		
		@Test
		public void testQty() {
			l.setQuantity(2);
			assertEquals(l.getQuantity(), 2);
		}
		
		@Test
		public void toStringTest() {
			assertNotNull(l.toString());
		}
		

		@Test
		public void Should_Pass_All_Pojo_Tests() {
		    // given
		    final Class<Inventory> classUnderTest = Inventory.class;

		  assertNotNull(classUnderTest);
		}
	

	}
