package com.p2.driver;

import java.util.List;
import org.hibernate.Session;
import com.p2.dao.LoginsDAO;
import com.p2.util.HibernateSessFact;


public class MainDriver {
	static Session session;
	static List results;

		public static void main(String[] args) {

				//this would be inside a controller.....
					session = HibernateSessFact.getSession(); //retrieve session from session factory util
					results = LoginsDAO.getAllLogins(session); //get results from Hibernate method, returned as List object
					System.out.println(results);
					session.close(); //be sure to close session when done 
		
		}
}
