package com.p2.dao;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.p2.model.OrderContents;
import com.p2.model.Orders;
import com.p2.util.HibernateSessFact;

public class OrderContentsDAO {

	// method to add items into cart
	// save current entity
	public int addOrderContents(Orders orders) {
		int result = 0;
		try {
			Session session = HibernateSessFact.getSession();
			session.beginTransaction();
			session.save(orders);
			session.getTransaction().commit();
			session.close();
			result = 1;
			return result;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	// delete an order based on id
	public boolean deleteOrderContents(int id) {
		try {
			Session session = HibernateSessFact.getSession();
			Transaction transaction = session.beginTransaction();
			String queryStr = "delete from OrderContents where ordercontentsid =:id";
			Query query = session.createQuery(queryStr);
			query.setParameter("id", id);
			query.executeUpdate();
			transaction.commit();
			session.clear();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateOrderContents(OrderContents orderContents) {
		try {
			Session session = HibernateSessFact.getSession();
			Transaction transaction = session.beginTransaction();
			OrderContents orders = session.load(OrderContents.class, orderContents.getOrderContentsId());
			orders.setItem(orderContents.getItem());
			orders.setPrice(orderContents.getPrice());
			orders.setQuantity(orderContents.getQuantity());
			session.update(orders);
			transaction.commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// insert to existing order
	public boolean addToExistingOrderContents(int orderid, OrderContents orderContents) {
		try {
			Session session = HibernateSessFact.getSession();
			Transaction transaction = session.beginTransaction();
			
			Orders orders = session.load(Orders.class, orderid);
			OrderContents newOrderContents = new OrderContents();
			newOrderContents.setItem(orderContents.getItem());
			//newOrderContents.setOrderID(orderid);
			newOrderContents.setPrice(orderContents.getPrice());
			newOrderContents.setQuantity(orderContents.getQuantity());
			newOrderContents.setOrders(orders);
	
			session.save(newOrderContents);
			transaction.commit();
			session.close();
			return true;	
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
