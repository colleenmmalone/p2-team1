package com.p2.driver.logins;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginsService {

	@Autowired
	private LoginsRepository loginRepository;
	
	// retrieve a list of logins
	public List<Logins> getAllLogins() {
		return loginRepository.findAll();
	}
	
	// add new login
	
	// delete login from db
	
	// retrieve login {id}
	
	// update user login
}
