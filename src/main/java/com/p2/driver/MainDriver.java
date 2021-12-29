package com.p2.driver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.p2.dao.LoginsDAO;
import com.p2.dao.OrderContentsDAO;
import com.p2.model.OrderContents;
import com.p2.model.Orders;


import com.p2.dao.InventoryDAO;
import com.p2.dao.LoginsDAO;
import com.p2.model.Inventory;
import com.p2.model.Logins;
import com.p2.util.HibernateSessFact;

@SpringBootApplication
public class MainDriver {
	static Session session;
	static Integer results;

		public static void main(String[] args) {
			SpringApplication.run(MainDriver.class, args);

				//this would be inside a controller.....
			
//					session = HibernateSessFact.getSession();
//					List<Logins> results = LoginsDAO.getAllLogins(session);
//					System.out.println(results);
//					session.close();
			
				// insert function fully working and mapped
//					Orders order = new Orders();
//					order.setCustomer(1);
//					order.setOrderStatus("pending");
//					order.setTotal(10);
//					
//					OrderContentsDAO orderContentDao = new OrderContentsDAO();
//					OrderContents orderContents1 = new OrderContents(5, "Strawberry", 59, order);
//					OrderContents orderContents2 = new OrderContents(10, "Apple Pie", 59, order);
//		
//					Set<OrderContents> ordercontents = new HashSet<OrderContents>();
//					ordercontents.add(orderContents1);
//					ordercontents.add(orderContents2);
//					order.setOrderContents(ordercontents);
//					
//					orderContentDao.save(order);
//					
//					session = HibernateSessFact.getSession(); //retrieve session from session factory util
//					List listLogins = LoginsDAO.getAllLogins(session); //get results from Hibernate method, returned as List object
//			//		System.out.println(listLogins);
//					session.close(); //be sure to close session when done 
//		
//
				session = HibernateSessFact.getSession(); //retrieve session from session factory util
//					 listLogins = LoginsDAO.getLoginByID(session, 2); //get results from Hibernate method, returned as List object
//					System.out.println( listLogins);
//					
//					 listLogins = LoginsDAO.getLoginByEmail(session, "cs1"); //get results from Hibernate method, returned as List object
//						System.out.println( listLogins);
//					session.close(); //be sure to close session when done 
//		
//			Logins nu = new Logins("Fondant", "Funnelly", "cs3", "cs3", "CUSTOMER");
//			LoginsDAO.newLogin(nu);
			
			Logins hi = LoginsDAO.login("cs2", "cs2");
			System.out.println(hi.getFirstName());
			if(hi.getStatus().equals("CUSTOMER")) {
				//render Customer view
				System.out.println("Customer is logged in");
			}else if(hi.getStatus().equals("EMPLOYEE")) {
				//render Employee view
				System.out.println("Employee is logged in");
			} else {
				//redirect back to login
				System.out.println("This user does not appear to be a valid user");
			}
			
			
			
			
			/*
			Inventory inventory = new Inventory(1,"cheesecake",25);
			InventoryDAO inventoryDAO = new InventoryDAO();
			inventoryDAO.updateInventory(inventory);
//			*/
//			Inventory inventory = new Inventory();
//			InventoryDAO inventoryDAO = new InventoryDAO();
//			inventoryDAO.trying();
//			
			

		}
}
