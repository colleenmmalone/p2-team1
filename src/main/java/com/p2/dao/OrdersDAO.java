package com.p2.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.p2.util.HibernateSessFact;

public class OrdersDAO {

	
	public int updateOrderStatus (int orderID, String orderStatus) {
		Session session = HibernateSessFact.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "   update Orders \r\n"
				+ "       set orderstatus = :orderstatus\r\n"
				+ "       where orderid= :orderid";
		Query query = session.createQuery(hql);
		query.setParameter("orderstatus", orderStatus);
		query.setParameter("orderid", orderID);
		int rowCount= query.executeUpdate();
		transaction.commit();
		session.clear();
		session.close();
		return rowCount;
	}
	
	
	
	
	
}
