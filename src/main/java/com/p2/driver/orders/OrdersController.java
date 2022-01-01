package com.p2.driver.orders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/********To access data from axios localhost******http://localhost:8081/orders/{param}*******/
@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	 OrdersService ordersService;
	
	@GetMapping
	public List<Orders> getAllOrders() {
		return ordersService.getAllOrders();
	}
	
	@GetMapping("/{id}")
	public Optional<Orders> getOrdersById(@PathVariable(required = true) int id) {
		return ordersService.getOrdersById(id);
	}
	

}
