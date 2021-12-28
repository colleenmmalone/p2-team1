package com.p2.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class LoginsDAO {
	List results;
	
	
	
	
	
	
	
	public static List getAllLogins(Session session) {
		String hql = "FROM Logins";
		Query query = session.createQuery(hql);
		List results = query.list();
		return results;		
	}

}
