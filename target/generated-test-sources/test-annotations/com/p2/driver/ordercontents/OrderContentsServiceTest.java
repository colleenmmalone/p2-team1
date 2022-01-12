package com.p2.driver.ordercontents;

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

import com.p2.driver.inventory.Inventory;
import com.p2.driver.orders.Orders;

import org.junit.jupiter.api.Test;

@RunWith(MockitoJUnitRunner.class)
class LoginsServiceTest {
	
	OrderContentsService real = new OrderContentsService();
	
	@Mock
	OrderContentsService ls = org.mockito.Mockito.mock(OrderContentsService.class);
	
	@Mock
	OrderContentsRepository lr = org.mockito.Mockito.mock(OrderContentsRepository.class);

	

	@Test
	public void getLoginsTest() {
		when(ls.getAllOrderContents()).thenReturn(Stream
				.of(new OrderContents(), new OrderContents()).collect(Collectors.toList()));
		assertEquals(2,  ls.getAllOrderContents().size());		
	}
	
	@Test
	public void getOneLoginsEmailTest() {
	
		when(ls.deleteOrderContents(1)).thenReturn((1));
		assertEquals(1, ls.deleteOrderContents(1));		
	}
	
	@Test
	public void addInventoryTest() {
		OrderContents c  = new OrderContents();
		doNothing().when(ls).add(isA(OrderContents.class));
		ls.add(new OrderContents());
		verify(ls, times(1)).add(new OrderContents());
	}
	
//	@Test
//	public void getOneLoginsIDExTest() {
//		when(ldao.getLoginByID(1)).thenThrow(NullPointerException.class);
//		ldao.getLoginByID(1);
//	}

}