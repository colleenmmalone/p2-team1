package com.p2.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
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

	//	Logins nu = new Logins("Strawberry", "Shortcake", "cs2", "cs2", "CUSTOMER");
//		Logins nu = new Logins("Fondant", "Funnelly", "cs3", "cs3", "CUSTOMER");
//		Logins nu = new Logins("Anna", "Banana", "cs4", "cs4", "CUSTOMER");
//		Logins nu = new Logins("Moon", "Pie", "cs5", "cs5", "CUSTOMER");
//		System.out.println(nu.getMyOrders());
//	register(nu);
//	
//	user = getLoginByEmail("cs3");
//	System.out.println(user);
	//System.out.println(user.getMyOrders());
		
		
//	
		//========================== testing login method
//		Logins hi = login("cs1", "cs1");
//		if(hi!=null) {
//			System.out.println(hi.getFirstName());
//			if (hi.getStatus().equals("CUSTOMER")) {
//				// render Customer view
//				System.out.println("Customer is logged in");
//			} else if (hi.getStatus().equals("EMPLOYEE")) {
//				// render Employee view
//				System.out.println("Employee is logged in");
//			} else {
//				// redirect back to login
//				System.out.println("This user does not appear to be a valid user");
//			}
//		}else {
//			System.out.println("no one is logged in");
//		}
		
	}

	public Logins login(String email, String pswd)  { // login a user
		Session session = HibernateSessFact.getSession();
	//	Transaction transaction = session.beginTransaction();
		Logins l = getLoginByEmail(email);
		if(l==null) {
			return null;
		}else{
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
	}

	public Logins register(Logins logins) { // register new user
		Session session = HibernateSessFact.getSession();
		Logins newUser;
		newUser = getLoginByEmail(logins.getEmail());
		
		if (newUser == null) {
			session.beginTransaction();
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

	public boolean deleteLoginByID(int id){ // delete user by id
		try (Session session = HibernateSessFact.getSession()) {
			Transaction transaction = session.beginTransaction();
			session.createQuery("Delete From Logins where id=" + id, Logins.class).list();
			transaction.commit();
			session.close();		
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteLoginByEmail(String email) { // delete a user by email
		try (Session session = HibernateSessFact.getSession()) {
			Transaction transaction = session.beginTransaction();
			session.createQuery("Delete From Logins where email='" + email+"'", Logins.class).list();
			transaction.commit();
			session.close();		
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Logins> getAllLogins() { 	// retrieves a list of all the orders
		try (Session session = HibernateSessFact.getSession()) {
			return session.createQuery("From Logins", Logins.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Logins getLoginByID(int id) { // retrieve one user by id
		try (Session session = HibernateSessFact.getSession()) {
			List<Logins> l = session.createQuery("From Logins where id=" + id, Logins.class).list();
			if (l.size() != 0) {
				return l.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Logins getLoginByEmail(String email) { // retrieve one user by email
		try (Session session = HibernateSessFact.getSession()) {
			List<Logins> l = session.createQuery("From Logins where email='" + email + "'", Logins.class).list();
			if (l.size() != 0) {
				return l.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
