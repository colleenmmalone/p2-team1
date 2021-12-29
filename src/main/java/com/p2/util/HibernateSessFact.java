package com.p2.util;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateSessFact {
	static Session session;
	static SessionFactory sessionFactory;

	public static Session getSession() {

		Configuration config = new Configuration(); // load hibernate.cfg.xml
		config.configure();
		try {
			sessionFactory = config.buildSessionFactory(); // create new session factory
			session = sessionFactory.openSession(); // create new session
		} catch (Exception e) {
			e.printStackTrace();
		}

		return session; // return current session to DAO or controller
	}

}
