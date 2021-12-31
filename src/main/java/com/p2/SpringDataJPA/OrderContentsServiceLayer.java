package com.p2.SpringDataJPA;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.p2.model.OrderContents;

@Service
public class OrderContentsServiceLayer {

		@Autowired
		private  OrderContentsInterface orderContentsInterface;

	/*
		public OrderContents saveCart (OrderContents orderContents) {
			return orderContentsInterface.save(orderContents);
		}
		
		public List<OrderContents> saveAllCarts( List<OrderContents> orderContents){
			return orderContentsInterface.saveAll(orderContents);
		}
	*/	

		public List<OrderContents> getCarts(){
			return orderContentsInterface.findAll();
		}
		
		//For customers to see their distinct cart
		public OrderContents getCartByOrderId (int orderID) {
			return orderContentsInterface.findByOrderID(orderID);
		}
		
		//For Customers to edit their carts
		public OrderContents updateCart(OrderContents orderContents) {
			OrderContents existingCart = orderContentsInterface.findByOrderID(orderContents.getOrderID());
			existingCart.setItem(orderContents.getItem());
			existingCart.setQuantity(orderContents.getQuantity());
			return orderContentsInterface.save(existingCart);
		}
		
		//For Customer to delete items from cart
		public String deleteFromCart(int orderID) {
			orderContentsInterface.deleteById(orderID);
			return "Item successfully removed !!" + orderID;
		}



}
