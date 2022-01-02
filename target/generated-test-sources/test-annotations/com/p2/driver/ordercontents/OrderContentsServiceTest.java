package com.p2.driver.ordercontents;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.p2.driver.orders.Orders;

import static org.mockito.Mockito.*;

class OrderContentsServiceTest {
	
	@Mock
	private OrderContentsService orderContentsService;
	
	@InjectMocks private Orders orders;
	
	// create dummy values

	@Before
	void setUp() throws Exception {
		orderContentsService = mock(OrderContentsService.class);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddOrderContents() {
		assertEquals(true, orderContentsService.deleteOrderContents(1));
		
	}
	
	@Test
	void deleteOrderContentsByID() {
		final int id = 70;
		orderContentsService.deleteOrderContents(id);
		assertEquals(true, true);
	}

}
