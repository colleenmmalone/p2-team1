package com.p2.driver.ordercontents;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/********To access data from axios localhost******http://localhost:8081/ordercontents*******/
@RequestMapping("/ordercontents")
@CrossOrigin("*")
@RestController
public class OrderContentsController {
	
	@Autowired
	OrderContentsService orderContentsService;
	
	@GetMapping
	public List<OrderContents> getAllOrderContents() {
		return orderContentsService.getAllOrderContents();
		
	}
	
	// Optional denotes a container value if it is empty it will return null
	@GetMapping("/{id}")
	public Optional<OrderContents> getOrderContentsById(@PathVariable(required = true) int id) {
		return orderContentsService.getOrderContentsById(id);
	}
	
	@DeleteMapping("/deleteordercontents/{id}")
	public ResponseEntity<String> deleteOrderContents(@PathVariable(required = true) int id) {
		int result = orderContentsService.deleteOrderContents(id);
				
				if (result == 0) {
					// error if id is not found
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				} else {
					// will send back a message in form of res body
					return ResponseEntity.ok("Order contents with id:" + id + " Deleted");
				}
	}
	
	//@requestbody returns object as a httpresponse object
	@PostMapping 
	public void saveOrderContents(@RequestBody OrderContents orderContents) {
		orderContentsService.add(orderContents);
	}
	
	//This method updates all parameters
	@PutMapping("/updateordercontents/{id}")
	public void updateOrderContents(@PathVariable(value = "id") int id, @RequestBody OrderContents orderContents) {
		orderContentsService.updateExistingOrderContents(orderContents, id);
		
	}
	
	//This method updates only the quantity || Ex. updating quantity of order contents based on id
	@PutMapping("/updateordercontents/quantity={quantity}/{id}")
	public void updateQuantity(@PathVariable(value = "quantity") int quantity, @PathVariable(value="id") int id) {
		orderContentsService.updateQuantity(quantity, id);
	}
	
	
	//This method updates price based on id
	@PutMapping("/updateordercontents/price={price}/{id}")
	public void updatePrice(@PathVariable(value = "price") int price, @PathVariable(value="id") int id) {
		orderContentsService.updatePrice(price, id);
	}
	
	

}
