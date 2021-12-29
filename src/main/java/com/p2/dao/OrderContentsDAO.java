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
	public void save(Orders order) {
		Session session = HibernateSessFact.getSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		session.close();
		// will need catch statement
	}

	// delete an order based on id
	public boolean deleteOrder(int id) {
		Session session = HibernateSessFact.getSession();
		Transaction transaction = session.beginTransaction();
		String queryStr = "delete from OrderContents where ordercontentsid =:id";
		Query query = session.createQuery(queryStr);
		query.setParameter("id", id);
		query.executeUpdate();
		transaction.commit();
		session.clear();
		session.close();
		return false;
	}


}
