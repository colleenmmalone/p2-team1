package com.p2.driver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.p2.dao.LoginsDAO;
import com.p2.dao.OrderContentsDAO;
import com.p2.model.OrderContents;
import com.p2.model.Orders;

import com.p2.dao.InventoryDAO;
import com.p2.dao.LoginsDAO;
import com.p2.model.Inventory;
import com.p2.util.HibernateSessFact;

@SpringBootApplication
public class MainDriver {
	static Session session;
	static Integer results;

		public static void main(String[] args) {
			SpringApplication.run(MainDriver.class, args);

				//this would be inside a controller.....
//					session = HibernateSessFact.getSession();
//					results = LoginsDAO.getAllLogins(session);
//					System.out.println(results);
//					session.close();
			
			Orders order = new Orders();
			order.setCustomer(1);
			order.setOrderStatus("pending");
			order.setTotal(10);
			
			OrderContentsDAO orderContentDao = new OrderContentsDAO();
			//OrderContents orderContents1 = new OrderContents(5, "Blueberry", 59, order);
			OrderContents orderContents2 = new OrderContents(10, "testingwithLombok", 59, order);

			Set<OrderContents> ordercontents = new HashSet<OrderContents>();
			//ordercontents.add(orderContents1);
			ordercontents.add(orderContents2);
			order.setOrderContents(ordercontents);
			
			orderContentDao.save(order);
					
//					session = HibernateSessFact.getSession(); //retrieve session from session factory util
//					results = LoginsDAO.getAllLogins(session); //get results from Hibernate method, returned as List object
//					System.out.println(results);
//					session.close(); //be sure to close session when done 
		
//			Inventory inventory = new Inventory(1,"cheesecake",25);
//			InventoryDAO inventoryDAO = new InventoryDAO();
//			inventoryDAO.updateInventory(inventory);
//			Inventory inventory = new Inventory();
//			InventoryDAO inventoryDAO = new InventoryDAO();
//			inventoryDAO.trying();
//			InventoryDAO inventoryDao = new InventoryDAO();
//			System.out.println(inventoryDao.updateInventory());
			
		}
}
