package com.p2.driver.logins;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/logins")
@CrossOrigin("*")
public class LoginsController {
	
	@Autowired
	private LoginsService ls;

	@GetMapping
	public List<Logins> getAllLogins() {
		return ls.getAllLogins();
	}
	
	@GetMapping("/whoisloggedin")
	public Logins whoIsLoggedIn() {
		return LoginsService.user;
	}
	
	@GetMapping("/logout")
	public Logins logout() {
		LoginsService.user = null;
		return LoginsService.user;
	}
	
	@GetMapping("/id/{id}")
    public Logins getLoginByID(@PathVariable Integer id) {
         return ls.getLoginByID(id);
    }
	
	@GetMapping("/email/{email}")
    public Logins getLoginByEmail(@PathVariable String email) {
        return ls.getLoginByEmail(email);
    }
	
	@PostMapping("/login")
	public Logins login(@RequestBody Logins login){
		return ls.login(login.getEmail(), login.getPswd());
	}
	
	@PostMapping("/register")
	public Logins register(@RequestBody Logins newUser) {
		return ls.register(newUser);
	}
	
	@DeleteMapping("/del/id/{id}")
	public String deleteByID(@PathVariable int id){
		ls.deleteLoginByID(id);
		return "done";
	}

	
}
