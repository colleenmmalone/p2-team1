package com.p2.driver.ordercontents;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderContentsService {
	
	@Autowired
	private OrderContentsRepository orderContentsRepository;
	
	// Retrieves a list of ordercontents
	public List<OrderContents> getAllOrderContents() {
		return orderContentsRepository.findAll();
	}
	
	// adds an order content
	public void add(OrderContents orderContents) {
		orderContentsRepository.save(orderContents);
	}
	
	// deletes order content based on id
	public int deleteOrderContents(int id) {
		orderContentsRepository.deleteById(id);
		if (id > 0) {
			return id;
		} else {
			return 0;
		}
	}
	
	// retrieve order content based on id
	public Optional<OrderContents> getOrderContentsById(int id) {
		Optional<OrderContents> orderContents = orderContentsRepository.findById(id);
		return orderContents;
	}
	
	// updates existing order ===Updates all values ===
	public void updateExistingOrderContents(OrderContents orderContents, int id) {
		OrderContents orderContentsFromDb = orderContentsRepository.findById(id).get();
		orderContentsFromDb.setItem(orderContents.getItem());
		orderContentsFromDb.setPrice(orderContents.getPrice());
		orderContentsFromDb.setQuantity(orderContents.getQuantity());
		
		orderContentsRepository.save(orderContentsFromDb);
	}
	
	// updates quantity only
	public void updateQuantity(int quantity, int id) {
		OrderContents orderContentsFromDb = orderContentsRepository.findById(id).get();
		orderContentsFromDb.setQuantity(quantity);
		orderContentsRepository.save(orderContentsFromDb);
	}
	
	// updates price
	
	public void updatePrice(int price, int id) {
		OrderContents orderContentsFromDb = orderContentsRepository.findById(id).get();
		orderContentsFromDb.setPrice(price);
		orderContentsRepository.save(orderContentsFromDb);
	}

}
