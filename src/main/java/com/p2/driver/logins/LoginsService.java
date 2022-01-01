package com.p2.driver.logins;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p2.util.HibernateSessFact;

@Service
public class LoginsService {

	@Autowired
	private LoginsRepository loginRepository;
	static public Logins user;
	
	// retrieve a list of logins
	public List<Logins> getAllLogins() {
		return loginRepository.findAll();	
	}
	
	public Logins login(String email, String pswd) { // login a user
		Session session = HibernateSessFact.getSession();
		Logins temp = getLoginByEmail(email);
		if (temp == null) {
			user = null;
		} else {
			if (pswd.equals(temp.getPswd())) { // if password matches
				user = temp;
				//should log the following line
				System.out.println(user.getStatus() + " " + user.getFirstName() + " logged in");
			} else {
				System.out.println("Invalid password and/or email");
				user = null; // else no one is logged in
			}
		}
		return user;
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
