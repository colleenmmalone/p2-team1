package com.p2.driver.logins;

import static org.junit.jupiter.api.Assertions.*;
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


import org.junit.jupiter.api.Test;

@RunWith(MockitoJUnitRunner.class)
class LoginsServiceTest {
	
	LoginsService real = new LoginsService();
	
	@Mock
	LoginsService ls = org.mockito.Mockito.mock(LoginsService.class);
	
	@Mock
	LoginsRepository lr = org.mockito.Mockito.mock(LoginsRepository.class);

	

	@Test
	public void getLoginsTest() {
		when(ls.getAllLogins()).thenReturn(Stream
				.of(new Logins(), new Logins()).collect(Collectors.toList()));
		assertEquals(2,  ls.getAllLogins().size());		
	}
	
	@Test
	public void getOneLoginsEmailTest() {
		Logins l = new Logins();
		when(ls.getLoginByEmail("hi")).thenReturn((l));
		assertEquals(l, ls.getLoginByEmail("hi"));		
	}
	
	@Test
	public void getOneLoginsIDTest() {
		when(ls.getLoginByID(1)).thenReturn((new Logins()));
		ls.getLoginByID(1);
	}
	
//	@Test
//	public void getOneLoginsIDExTest() {
//		when(ldao.getLoginByID(1)).thenThrow(NullPointerException.class);
//		ldao.getLoginByID(1);
//	}

}