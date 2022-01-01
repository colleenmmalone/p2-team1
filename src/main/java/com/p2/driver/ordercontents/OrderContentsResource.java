package com.p2.driver.ordercontents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrderContentsResource {
	
	@Autowired
	private OrderContentsRepository orderContentRepository;
	
	@GetMapping("/orderContents")
	public List<OrderContents> retrieveOrderContents() {
		return orderContentRepository.findAll();
	}

}
