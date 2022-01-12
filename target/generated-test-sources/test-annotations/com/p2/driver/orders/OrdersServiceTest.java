package com.p2.driver.orders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import org.junit.jupiter.api.Test;

@RunWith(MockitoJUnitRunner.class)
class LoginsServiceTest {
	
	OrdersService real = new OrdersService();
	
	@Mock
	OrdersService os = org.mockito.Mockito.mock(OrdersService.class);
	
	@Mock
	OrdersRepository or = org.mockito.Mockito.mock(OrdersRepository.class);

	

	@Test
	public void getLoginsTest() {
		when(os.getAllOrders()).thenReturn(Stream
				.of(new Orders(), new Orders()).collect(Collectors.toList()));
		assertEquals(2,  os.getAllOrders().size());		
	}
	
	@Test
	public void getOneLoginsEmailTest() {
		Orders o = new Orders();
		doNothing().when(os).add(isA(Orders.class));
		os.add(new Orders());
		verify(os, times(1)).add(new Orders());
	}
	
	@Test
	public void deleteOrderTest() {
	
		when(os.deleteOrder(1)).thenReturn((1));
		assertEquals(1, os.deleteOrder(1));		
	}

}