package com.p2.dao;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.p2.model.OrderContents;
import com.p2.util.HibernateSessFact;

public class OrderContentsDAO {

	// method to add items into cart
	public void addOrderContent(OrderContents orderContents) {
		// later on get form input as a class and set those values as the parameters
		try {
			Session session = HibernateSessFact.getSession();
		// random UUID?
			session.beginTransaction();
			//session.save(orderContents);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		// for testing purposes check if it returns an id or null
	}

	// save current entity
	public void save(OrderContents ordercontents) {
		Transaction transaction = null;
		Session session = HibernateSessFact.getSession();
		transaction = session.beginTransaction();
		session.save(ordercontents);
		transaction.commit();
		session.close();
		// will need catch statement
	}

	// delete an order based on id // only deletes persistent data
	public boolean deleteOrder(int id) {
		Session session = HibernateSessFact.getSession();
		Object persistentInstance = session.load(OrderContents.class, id);
		if (persistentInstance != null) {
			session.delete(persistentInstance);
			return true;
		}
		return false;
	}


}
