package com.p2.driver.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p2.driver.ordercontents.OrderContents;


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
		System.out.println(orders.getOrderContents());
		Orders newOrder = new Orders();
		List<OrderContents> OrderContents = orders.getOrderContents();

		newOrder.setOrderDate(orders.getOrderDate());
		newOrder.setOrderStatus(orders.getOrderStatus());
		newOrder.setTotal(orders.getTotal());
		newOrder.setCustomer(orders.getCustomer());
		newOrder.setOrderContents(OrderContents);
		
		ordersRepository.save(newOrder);
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
	public void updateOrders(Orders orders, int id) {
		Orders orderFromDb = ordersRepository.findById(id).get();
		orderFromDb.setOrderDate(orders.getOrderDate());
		orderFromDb.setOrderStatus(orders.getOrderStatus());
		orderFromDb.setTotal(orders.getTotal());
		ordersRepository.save(orderFromDb);
		
	}
	
	// update order status || id refers to order id
	public void updateOrderStatus(String status, int id) {
		Orders ordersFromDb = ordersRepository.findById(id).get();
		// can probably handle status value on front end ex. pending, done, not valid
		ordersFromDb.setOrderStatus(status);
		ordersRepository.save(ordersFromDb);
		
	}

}
