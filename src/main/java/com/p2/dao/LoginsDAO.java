package com.p2.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.p2.model.Logins;
import com.p2.util.HibernateSessFact;

public class LoginsDAO {
	List results;
	
	
	
	
	
	
	
	public static List getAllLogins(Session session) { //argument is current session
		String hql = "FROM Logins"; //prepared statement, but shorter because Hibernate writes the rest
		Query query = session.createQuery(hql); //execute prepared statement
		List results = query.list(); //add results to List object
		return results;		//return that list
	}
	
	public static List retrieveCustomerOrder() {
	Session session = HibernateSessFact.getSession();
	Transaction tx = session.beginTransaction();
	String hql = "	select lo.id, lo.first_name ,lo.last_name, lo.email, o.orderid, o.total, o.orderdate, o.orderstatus ,oc.item, oc.price, oc.quantity \r\n"
			+ "		   from logins lo\r\n"
			+ "			inner join orders o on lo.id = o.customer\r\n"
			+ "			and lo.status = 'CUSTOMER' \r\n"
			+ "			inner join ordercontents oc on o.orderid = oc.orderid ;";
	Query query = session.createSQLQuery(hql );  
	List results ;
	results= query.list();
	//results= query.getResultList();
	//results = session.createCriteria(Logins.class).list();
	System.out.println("Customer Order Infos:" + results);
	tx.commit();
	session.close();
	return results;
	
	
	
	}

}
