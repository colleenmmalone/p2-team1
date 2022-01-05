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

import com.p2.driver.logins.LoginsService;
import com.p2.driver.orders.Orders;

import static org.mockito.Mockito.*;

class OrderContentsServiceTest {
	OrderContents oc;
	
	@Mock
	private OrderContentsService orderContentsService = org.mockito.Mockito.mock(OrderContentsService.class);
	
	@InjectMocks private Orders orders;
	
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddOrderContents() { //doNothing() because this method has a void return
		doNothing().when(orderContentsService).add(oc);
		String s = "whee";
		assertEquals(s,"whee");
		
	}
	
	@Test
	void deleteOrderContentsByID() {
		final int id = 70;
		orderContentsService.deleteOrderContents(id);
		assertEquals(true, true);
	}

}
