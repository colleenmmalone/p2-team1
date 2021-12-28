package com.p2.dao;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.p2.model.OrderContents;
import com.p2.util.HibernateSessFact;

public class OrderContentsDAO {

	// method to add items into cart
	public void addOrderContent() {
		// later on get form input as a class and set those values as the parameters
		Session session = HibernateSessFact.getSession();

		// random UUID?
		Integer orderContentId = null;

		try {

			session.beginTransaction();
			// create order content object and set values
			String hql = "INSERT INTO OrderContents ( orderID, item, price, quantity) "
					+ "SELECT orderid, item, price, quantity";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			session.getTransaction().commit();

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

		// will need catch statement
	}

	// delete an order based on id?
	public int deleteOrder(int id) {
		Transaction transaction = null;
		int result = 0;
		try {
			// delete persistent object
			Session session = HibernateSessFact.getSession();
			transaction = session.beginTransaction();
			OrderContents orderContents = session.get(OrderContents.class, id);
			String hql = "DELETE FROM OrderContents " + "Where id = :itemId";
			Query query = session.createQuery(hql);
			query.setParameter("itemId", id);
			result = query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return result;
	}

	// delete from cart ?

}
