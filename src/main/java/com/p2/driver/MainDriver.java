package com.p2.driver;

import java.util.List;
import org.hibernate.Session;
import com.p2.dao.LoginsDAO;
import com.p2.dao.OrderContentsDAO;
import com.p2.model.OrderContents;
import com.p2.model.Orders;
import com.p2.util.HibernateSessFact;


public class MainDriver {
	static Session session;
	static Integer results;

		public static void main(String[] args) {

				//this would be inside a controller.....
//					session = HibernateSessFact.getSession();
//					results = LoginsDAO.getAllLogins(session);
//					System.out.println(results);
//					session.close();
					Orders order = new Orders();
					order.setCustomer(1);
					order.setOrderID(1);
					order.setOrderStatus("pending");
					order.setTotal(10);
					
					OrderContentsDAO orderContentDao = new OrderContentsDAO();
					OrderContents orderContents = new OrderContents();
					
					orderContents.setItem("Blueberries");
					orderContents.setPrice(50);
					orderContents.setQuantity(2);
					orderContents.setItemID(1);
		
					//orderContentDao.addOrderContent(orderContents);
					orderContentDao.save(orderContents);
					
//					session = HibernateSessFact.getSession(); //retrieve session from session factory util
//					results = LoginsDAO.getAllLogins(session); //get results from Hibernate method, returned as List object
//					System.out.println(results);
//					session.close(); //be sure to close session when done 
		
		}
}
