package com.p2.dao;

<<<<<<< HEAD
import com.p2.model.Logins;

public class LoginsDAO {
	
	private static LoginsDAO loginsDAO;
	private LoginsDAO() {
		super();
=======
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.p2.model.Logins;
import com.p2.model.Orders;
import com.p2.util.HibernateSessFact;

public class LoginsDAO {
	List results;
	
	
	
	static public Logins login( String email, String pswd) {
		Session session = HibernateSessFact.getSession();
		Transaction transaction = session.beginTransaction();
		List<Logins> l= getLoginByEmail(session, email);
		if(pswd.equals(l.get(0).getPswd())) {
			System.out.println("User is logged in!");
			return l.get(0);
		}else {
			System.out.println("Invalid password and/or email");
			return null;
		}
//		System.out.println(l);
//		System.out.println(l.get(0).getEmail());
//	//	Logins currentUser = new Logins(l.get(0).getFirstName(),l.get(0).getLastName(),l.get(0).getEmail(),l.get(0).getPswd(),l.get(0).getStatus());
//		Logins currentUser = l.get(0);
//		return currentUser;
		
	}
	
	
	
	
	
	
	static public void newLogin(Logins logins) {
		Session session = HibernateSessFact.getSession();
		session.beginTransaction();
		session.save(logins);
		session.getTransaction().commit();
		session.close();
		// will need catch statement
	}
	
	// delete an order based on id
		static public boolean deleteLoginByID(int id) {
			Session session = HibernateSessFact.getSession();
			Transaction transaction = session.beginTransaction();
			String queryStr = "delete from Logins where id =:id";
			Query query = session.createQuery(queryStr);
			query.setParameter("id", id);
			query.executeUpdate();
			transaction.commit();
			session.clear();
			session.close();
			return false;
		}
		
		static public boolean deleteLoginByEmail(String email) {
			Session session = HibernateSessFact.getSession();
			Transaction transaction = session.beginTransaction();
			String queryStr = "delete from Logins where email =:email";
			Query query = session.createQuery(queryStr);
			query.setParameter("email", email);
			query.executeUpdate();
			transaction.commit();
			session.clear();
			session.close();
			return false;
		}
	
	
	
	public static List getAllLogins(Session session) { //argument is current session
		String hql = "FROM Logins"; //prepared statement, but shorter because Hibernate writes the rest
		Query query = session.createQuery(hql); //execute prepared statement
		List results = query.list(); //add results to List object
		return results;		//return that list
	}
	
	public static List getLoginByID(Session session, int id) { //argument is current session
		String hql = "FROM Logins E WHERE E.id = :Eid"; //prepared statement, but shorter because Hibernate writes the rest		
		Query query = session.createQuery(hql); //execute prepared statement
		query.setParameter("Eid",id);
		List results = query.list(); //add results to List object
		return results;		//return that list
	}
	
	public static List getLoginByEmail(Session session, String email) { //argument is current session
		String hql = "FROM Logins E WHERE E.email = :Eid"; //prepared statement, but shorter because Hibernate writes the rest		
		Query query = session.createQuery(hql); //execute prepared statement
		query.setParameter("Eid",email);
		List results = query.list(); //add results to List object
		return results;		//return that list
>>>>>>> origin/colleen
	}

	
	public static LoginsDAO getLoginsDAO() {
		if (loginsDAO == null) {
			loginsDAO = new LoginsDAO();
		}
		return loginsDAO;
	}
	
	public Logins findByUserId(int id) {
		
		}
	
	
}
