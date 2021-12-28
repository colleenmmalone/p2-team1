package com.p2.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.p2.model.OrderContents;

public class OrderContentsDAO {
	
	// method to add items into cart 
	public Integer addOrderContent(int itemid, int orderid, String item, int price, int quantity) {
		// later on get form input as a class and set those values as the parameters
		Session session = factory.openSession();
		Transaction tx = null;
		
		// random UUID?
		Integer orderContentId = null;
		
		
		try {
			tx = session.beginTransaction();
			// create order content object and set values
			OrderContents orderContents = new OrderContents();
			
			orderContents.setItemID(itemid);
			orderContents.setOrderID(orderid);
			orderContents.setItem(item);
			orderContents.setPrice(price);
			orderContents.setQuantity(quantity);
			
			orderContentId = (Integer) session.save(orderContents);
			session.save(orderContents);
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		// for testing purposes check if it returns an id or null
		return orderContentId;
		
	}
	
	// delete from cart ?

}
