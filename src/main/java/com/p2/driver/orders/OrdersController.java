package com.p2.driver.orders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/********To access data from axios localhost******http://localhost:8081/orders/*******/
@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
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
	
	@DeleteMapping("/deleteorder/{id}")
	public ResponseEntity<Long> deleteOrder(@PathVariable(required = true) int id) {
		
		int result = ordersService.deleteOrder(id);
		
		if (result == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else 
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// @request body bounds orders to the response body 
	@PostMapping
	public void saveOrder(@RequestBody Orders orders) {
		ordersService.add(orders);
	}
	
	@PutMapping("/updateorder/{id}")
	public void updateOrder(@PathVariable(value = "id") int id, @RequestBody Orders orders) {
		ordersService.updateOrders(orders, id);
	}
	
	@PutMapping("/updateorder/status={status}/{id}")
	public void updateOrderStatus(@PathVariable String status, @PathVariable(value="id") int id) {
		ordersService.updateOrderStatus(status, id);
	}
	
	

}
