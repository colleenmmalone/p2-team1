package com.p2.driver.orders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	// retrieves a list of orders
	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}
	
	// adds an order
	public void add(Orders orders) {
		ordersRepository.save(orders);
	}
	
	// deletes order base on id
	public int deleteOrder(int id) {
		ordersRepository.deleteById(id);
		if (id > 0) {
			return id;
		} else {
			return 0;
		}
	}
	
	// retrieves order based on id will return null if it doesn't exist
	public Optional<Orders> getOrdersById(int id) {
		Optional<Orders> order = ordersRepository.findById(id);
		return order;
	}
	
	// updates existing order
	public void updateOrders(Orders updateOrders) {
		Orders orderFromDb = ordersRepository.findById(updateOrders.getOrderID()).get();
		orderFromDb.setOrderDate(updateOrders.getOrderDate());
		orderFromDb.setOrderStatus(updateOrders.getOrderStatus());
		orderFromDb.setTotal(updateOrders.getTotal());
		ordersRepository.save(orderFromDb);
		
	}

}
