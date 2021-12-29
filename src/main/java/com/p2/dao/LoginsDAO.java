package com.p2.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class LoginsDAO {
	List results;
	
	
	
	
	
	
	
	public static List getAllLogins(Session session) { //argument is current session
		String hql = "FROM Logins"; //prepared statement, but shorter because Hibernate writes the rest
		Query query = session.createQuery(hql); //execute prepared statement
		List results = query.list(); //add results to List object
		return results;		//return that list
	}

}
