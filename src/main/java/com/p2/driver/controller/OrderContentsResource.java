package com.p2.driver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrderContentsResource {
	
	@Autowired
	private OrderContentRepository orderContentRepository;
	
	@GetMapping("/orders")
	public List<OrderContents> retrieveOrderContents() {
		return orderContentRepository.findAll();
	}

}
