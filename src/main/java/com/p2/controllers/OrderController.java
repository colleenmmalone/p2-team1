package com.p2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@GetMapping("/orders")
	public String getAllOrdersApi() {
		return null;
		
	}

}
