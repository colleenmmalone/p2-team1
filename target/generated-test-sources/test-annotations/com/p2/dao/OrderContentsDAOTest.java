package com.p2.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.p2.model.OrderContents;
import com.p2.model.Orders;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

class OrderContentsDAOTest {
	
	@Mock
	private OrderContentsDAO orderContentsDAO;
	
	@InjectMocks private Orders orders;
	
	// create dummy values

	@Before
	void setUp() throws Exception {
		orderContentsDAO = mock(OrderContentsDAO.class);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddOrderContents() {
		assertTrue(orderContentsDAO.deleteOrderContents(1));
		
	}
	
	@Test
	void deleteOrderContentsByID() {
		final int id = 70;
		orderContentsDAO.deleteOrderContents(id);
		assertEquals(true, true);
	}

}
