package com.p2.driver.logins;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/id/{id}")
    public Logins getLoginByID(@PathVariable int id) {
        return ls.getLoginByID(id);
    }
	
	@GetMapping("/email/{email}")
    public Logins getLoginByEmail(@PathVariable String email) {
        return ls.getLoginByEmail(email);
    }
	
	@GetMapping("/login/{email}/{pswd}")
	public Logins login(@PathVariable String email, @PathVariable String pswd){
		return ls.login(email, pswd);
	}
	
	//NEED HELP MAPPING POST METHOD
	public Logins register(/*responsebody*/) {
//		ls.register(/*responsebody*/);
		return null;
	}
	
	@GetMapping("/delete/{email}")
	public boolean deleteByEmail(@PathVariable String email){
		return ls.deleteLoginByEmail(email);
	}
	
	@GetMapping("/delete/{id}")
	public boolean deleteByID(@PathVariable int id){
		return ls.deleteLoginByID(id);
	}
	
	//so i don't clog  up the main driver
	static public void colleenLoginMethodTesting() {

	//	Logins nu = new Logins("Strawberry", "Shortcake", "cs2", "cs2", "CUSTOMER");
//		Logins nu = new Logins("Fondant", "Funnelly", "cs3", "cs3", "CUSTOMER");
//		Logins nu = new Logins("Anna", "Banana", "cs4", "cs4", "CUSTOMER");
//		Logins nu = new Logins("Moon", "Pie", "cs5", "cs5", "CUSTOMER");
//		System.out.println(nu.getMyOrders());
//	register(nu);
//	
//	user = getLoginByEmail("cs3");
//	System.out.println(user);
	//System.out.println(user.getMyOrders());
		
	}
	
}
