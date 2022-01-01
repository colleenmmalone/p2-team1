package com.p2.dao;

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

import com.p2.model.Logins;
import com.p2.repositories.LoginsRepository;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@RunWith(MockitoJUnitRunner.class)
class LoginsDAOTest {
	
	LoginsDAO real = new LoginsDAO();
	
	@Mock
	LoginsDAO ldao = org.mockito.Mockito.mock(LoginsDAO.class);
	
	@Mock
	LoginsRepository lr = org.mockito.Mockito.mock(LoginsRepository.class);

	

	@Test
	public void getLoginsTest() {
		when(ldao.getAllLogins()).thenReturn(Stream
				.of(new Logins(), new Logins()).collect(Collectors.toList()));
		assertEquals(2,  ldao.getAllLogins().size());		
	}
	
	@Test
	public void getOneLoginsEmailTest() {
		Logins l = new Logins("hi","hi","hi","hi","hi");
		when(ldao.getLoginByEmail("hi")).thenReturn((l));
		assertEquals(l, ldao.getLoginByEmail("hi"));		
	}
	
	@Test
	public void getOneLoginsIDTest() {
		when(ldao.getLoginByID(1)).thenReturn((new Logins(1,"a","a","a","a","a")));
		ldao.getLoginByID(1);
	}
	
//	@Test
//	public void getOneLoginsIDExTest() {
//		when(ldao.getLoginByID(1)).thenThrow(NullPointerException.class);
//		ldao.getLoginByID(1);
//	}
	
	@Test
	public void getLogins2Test() {
	
		assertNotEquals(1,  real.getAllLogins().size());		
	}


}
