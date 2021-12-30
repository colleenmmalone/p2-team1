package com.p2.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.p2.model.Logins;
import com.p2.model.Orders;
import com.p2.util.HibernateSessFact;

public class LoginsDAO {
	static List <Logins> results;
	static public Logins currentUser, user;
	
	//so i don't clog  up the main driver
	static public void colleenLoginMethodTesting() {
		
		Logins nu = new Logins("Lemon", "Meringue", "emp1", "emp1", "EMPLOYEE");
		newLogin(nu);
//		Logins nu = new Logins("Moon", "Pie", "cs4", "cs4", "CUSTOMER");
//		LoginsDAO.newLogin(nu);
//		System.out.println(nu.getId());
//		 listLogins = LoginsDAO.getLoginByID(session, 2); //get results from Hibernate method, returned as List object
//		System.out.println( listLogins);

		
		results = getAllLogins();
		System.out.println(results);
//		 listLogins = LoginsDAO.getLoginByEmail(session, "cs1"); //get results from Hibernate method, returned as List object
//			System.out.println( listLogins);
//		session.close(); //be sure to close session when done 
//
		Logins hi = login("emp1", "emp1");
		if(hi!=null) {
			System.out.println(hi.getFirstName());
			if (hi.getStatus().equals("CUSTOMER")) {
				// render Customer view
				System.out.println("Customer is logged in");
			} else if (hi.getStatus().equals("EMPLOYEE")) {
				// render Employee view
				System.out.println("Employee is logged in");
			} else {
				// redirect back to login
				System.out.println("This user does not appear to be a valid user");
			}
		}else {
			System.out.println("no one is logged in");
		}
		
	}

	static public Logins login(String email, String pswd) { // login a user
		Session session = HibernateSessFact.getSession();
		Transaction transaction = session.beginTransaction();
		Logins l = getLoginByEmail(email);
		if (pswd.equals(l.getPswd())) { // if password matches
			System.out.println("User is logged in!");
			currentUser = l; // login
			return l;
		} else {
			System.out.println("Invalid password and/or email");
			currentUser = null; // else no one is logged in
			return null;
		}
	}

	static public Logins newLogin(Logins logins) { // register new user
		Session session = HibernateSessFact.getSession();
		session.beginTransaction();
		Logins newUser;
		newUser = getLoginByEmail(logins.getEmail());
		
		if (newUser == null) {
			session.save(logins);
			session.getTransaction().commit();
			newUser = getLoginByEmail(logins.getEmail());
		} else {
			System.out.println("This user already exists");
			newUser = null;
		}
		session.close();
		return newUser;
	}

	static public void deleteLoginByID(int id) { // delete user by id
		Session session = HibernateSessFact.getSession();
		Transaction transaction = session.beginTransaction();
		String queryStr = "delete from Logins where id =:id";
		Query query = session.createQuery(queryStr);
		query.setParameter("id", id);
		query.executeUpdate();
		transaction.commit();
		session.clear();
		session.close();
		return;
	}

	static public void deleteLoginByEmail(String email) { // delete a user by email

		Session session = HibernateSessFact.getSession();
		Transaction transaction = session.beginTransaction();
		String queryStr = "delete from Logins where email =:email";
		Query query = session.createQuery(queryStr);
		query.setParameter("email", email);
		query.executeUpdate();
		transaction.commit();
		session.clear();
		session.close();
		return;
	}

	public static List getAllLogins() { // retrieve all users
		Session session = HibernateSessFact.getSession();
		String hql = "FROM Logins";
		Query query = session.createQuery(hql);
		results = query.list();
		session.close();
		return results;
	}

	public static Logins getLoginByID(int id) { // retrieve one user by id
		Session session = HibernateSessFact.getSession();
		String hql = "FROM Logins WHERE id = :Eid";
		Query query = session.createQuery(hql);
		query.setParameter("Eid", id);
		results = query.list();
		Logins user = results.get(0);
		session.close();
		return user;
	}

	public static Logins getLoginByEmail(String email) { // retrieve one user by email
		Session session = HibernateSessFact.getSession();
		String hql = "FROM Logins WHERE email = :Eid";
		Query query = session.createQuery(hql);
		query.setParameter("Eid", email);
		results = query.list();
		
		if(results.size() == 0) {
			user = null;
		}else {
			user =  results.get(0);
		}
		session.close();
		return user;
	}

}
