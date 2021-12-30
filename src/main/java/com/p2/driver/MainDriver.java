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
	
			//I wrote this method in LoginsDAO to avoid clogging up the main driver
			LoginsDAO.colleenLoginMethodTesting();
			
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
