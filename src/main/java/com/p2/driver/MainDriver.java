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
					session = HibernateSessFact.getSession();
					results = LoginsDAO.getAllLogins(session);
					System.out.println(results);
					session.close();
		
		}
}
