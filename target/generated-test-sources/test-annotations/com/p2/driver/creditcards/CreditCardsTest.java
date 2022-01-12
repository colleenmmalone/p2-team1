package com.p2.driver.creditcards;

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

public class CreditCardsTest {
		static CreditCards l, m, n;


		@BeforeAll
		public static void setUpBeforeClass() throws Exception {
			l = new CreditCards();
			m = new CreditCards();
			n = new CreditCards();
		}
		
		@Test void equalsTest() {
			assertEquals(n, m);
			assertEquals(m.hashCode(), n.hashCode());
		}
		
		@Test
		public void testFirst() {
			l.setCardID(99);
			assertEquals(l.getCardID(), 99);
		}
		
		@Test
		public void testLast() {
			l.setCardNum(122345689);
			assertEquals(l.getCardNum(), 122345689);
		}
		
		@Test
		public void testEmail() {
			l.setCvc(123);
			assertEquals(l.getCvc(), 123);
		}
		
		@Test
		public void testPswd() {
			l.setExpDate("be");
			assertEquals(l.getExpDate(), "be");
		}
		
		@Test
		public void testId() {
			l.setHolderID(7);
			assertEquals(l.getHolderID(), 7);
		}
		
		@Test
		public void testStatus() {
			l.setHolderName("fishie");
			assertEquals(l.getHolderName(), "fishie");
		}	
		
		@Test
		public void toStringTest() {
			assertNotNull(l.toString());
		}	

		@Test
		public void Should_Pass_All_Pojo_Tests() {
		    // given
		    final Class<CreditCards> classUnderTest = CreditCards.class;

		  assertNotNull(classUnderTest);
		}
	

	}
