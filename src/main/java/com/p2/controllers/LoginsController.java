package com.p2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.p2.dao.LoginsDAO;
import com.p2.model.Logins;
import com.p2.repositories.LoginsRepository;

@RestController
public class LoginsController {
	
	private LoginsDAO ldao = new LoginsDAO();
	private LoginsRepository lr ;

	
	@GetMapping("/")
	public String home() {
		return "home page";
	}
	
	@GetMapping("/logins")
    List<Logins> getLogins() {
        return lr.findAll();
    }
	
	@GetMapping("/logins/id/{id}")
    public Logins getLoginsByID(@PathVariable int id) {
        return ldao.getLoginByID(id);
    }
	
	@GetMapping("/logins/email/{email}")
    public Logins getLoginsByID(@PathVariable String email) {
        return ldao.getLoginByEmail(email);
    }
	
	@GetMapping("/hi")
	public String hi() {
		return "hi";
	}

}
