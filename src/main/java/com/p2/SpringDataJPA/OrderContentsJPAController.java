package com.p2.SpringDataJPA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.p2.model.OrderContents;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class OrderContentsJPAController {

	@Autowired
	private OrderContentsServiceLayer service;
	
	@GetMapping ("/Carts")
	public List<OrderContents>findCart () {
		return service.getCarts();
	}
	
	@GetMapping ("/myCart/{id}")
	public OrderContents findCartByOrderId (@PathVariable int orderid) {
		return service.getCartByOrderId(orderid);
	}
	
	@PutMapping ("/updateCart")
	public OrderContents updateCart(@RequestBody OrderContents orderContents) {
		return service.updateCart(orderContents);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteFromCart(@PathVariable int orderID) {
		return service.deleteFromCart(orderID);
	}
}
