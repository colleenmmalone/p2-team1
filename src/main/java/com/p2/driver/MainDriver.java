package com.p2.driver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.p2.dao.InventoryDAO;
import com.p2.dao.LoginsDAO;
import com.p2.dao.OrdersDAO;
import com.p2.model.Inventory;
import com.p2.model.Orders;
import com.p2.util.HibernateSessFact;

@SpringBootApplication
public class MainDriver {
	static Session session;
	static Integer results;


		public static void main(String[] args) {
			SpringApplication.run(MainDriver.class, args);

				//this would be inside a controller.....
				/*	results = LoginsDAO.getAllLogins(session); //get results from Hibernate method, returned as List object
					System.out.println(results);
					session.close(); //be sure to close session when done 
		*/
			//Updating inventory table
			Inventory inventory = new Inventory(1,"cheesecake",25);
			InventoryDAO inventoryDAO = new InventoryDAO();
			inventoryDAO.updateInventory(inventory);
		
			//Getting list of inventory
			InventoryDAO inventoryDAOO = new InventoryDAO();
			 inventoryDAOO.trying();
			 
			 //Accessing Customers information and order information 
		     LoginsDAO.retrieveCustomerOrder();
		     
		     //For Employee to edit OrderStatus
		     OrdersDAO ordersDAO = new OrdersDAO();
		     ordersDAO.updateOrderStatus(1, "baking");
			
		}
		
}
