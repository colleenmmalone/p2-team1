package com.p2.driver;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MainDriver {
		static Session session;
		static Transaction transaction;
		static SessionFactory sessionFactory;

		public static void main(String[] args) {
				System.out.println("Hello world!");
				
				//This is a quick method to ensure I mapped to Hibernate correctly
				 Configuration config = new Configuration();
				config.configure();
				try {
					sessionFactory = config.buildSessionFactory();
					session = sessionFactory.openSession();
					transaction = session.beginTransaction();
		
					String hql = "FROM logins";
					Query query = session.createQuery(hql);
					List results = query.list();
					System.out.println(results);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("hello");
		}
		

}
