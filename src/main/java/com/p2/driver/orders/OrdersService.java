package com.p2.driver.orders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdersService {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}
	
	public void add(Orders orders) {
		ordersRepository.save(orders);
	}
	
	public int deleteOrder(int id) {
		ordersRepository.deleteById(id);
		if (id > 0) {
			return id;
		} else {
			return 0;
		}
	}
	
	public Optional<Orders> getOrdersById(int id) {
		Optional<Orders> order = ordersRepository.findById(id);
		return order;
	}

}
