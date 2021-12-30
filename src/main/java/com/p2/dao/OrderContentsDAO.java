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
	public int addOrderContents(Orders order) {
		int result = 0;
		try {
			Session session = HibernateSessFact.getSession();
			session.beginTransaction();
			session.save(order);
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

	public int addToExistingOrder(int id, OrderContents orderContents) {
		try {
			Session session = HibernateSessFact.getSession();
			session.beginTransaction();
			Orders orders = session.load(Orders.class, id);
			orderContents.setOrders(orders);
			session.save(orderContents);
			return 1;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
