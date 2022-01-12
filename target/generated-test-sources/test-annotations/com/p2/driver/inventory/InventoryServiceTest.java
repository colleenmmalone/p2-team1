package com.p2.driver.inventory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

import com.p2.driver.orders.Orders;

import org.junit.jupiter.api.Test;

@RunWith(MockitoJUnitRunner.class)
class LoginsServiceTest {
	
	InventoryService real = new InventoryService();
	
	@Mock
	InventoryService is = org.mockito.Mockito.mock(InventoryService.class);
	
	@Mock
	InventoryRepository ir = org.mockito.Mockito.mock(InventoryRepository.class);

	

	@Test
	public void getLoginsTest() {
		when(is.getAllInventory()).thenReturn(Stream
				.of(new Inventory(), new Inventory()).collect(Collectors.toList()));
		assertEquals(2,  is.getAllInventory().size());		
	}
	
	@Test
	public void getOneLoginsEmailTest() {
		Inventory i = new Inventory();
		when(is.updateQuantity(i, 2)).thenReturn(("hello"));
		assertEquals("hello", is.updateQuantity(i, 2));		
	}
	
	@Test
	public void addInventoryTest() {
		Orders o = new Orders();
		doNothing().when(is).addItem(isA(Inventory.class));
		is.addItem(new Inventory());
		verify(is, times(1)).addItem(new Inventory());
	}
	
//	@Test
//	public void getOneLoginsIDExTest() {
//		when(ldao.getLoginByID(1)).thenThrow(NullPointerException.class);
//		ldao.getLoginByID(1);
//	}

}