package com.p2.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessFact {
	static Session session;
	static SessionFactory sessionFactory;

	public static Session getSession() {

		Configuration config = new Configuration(); // load hibernate.cfg.xml
		config.configure();
		sessionFactory = config.buildSessionFactory(); // create new session factory
		session = sessionFactory.openSession(); // create new session
		return session; // return current session to DAO or controller
	}

	public HibernateSessFact() {
		super();
	}

}