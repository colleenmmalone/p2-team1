package com.p2.dao;

import com.p2.model.Inventory;
import com.p2.util.HibernateSessFact;

import java.util.List;

import javax.persistence.Query;


import org.hibernate.*;

public class InventoryDAO {
	
	public int updateInventory(Inventory inventory) {
			
		   Session session = HibernateSessFact.getSession();
			Transaction tx = session.beginTransaction();	
			Query query = session.createSQLQuery("update inventory\r\n"
					+ "set quantity= "+ inventory.getQuantity() +"\r\n"
					+ "where itemid= "+ inventory.getItemID() );  
			int rowCount = query.executeUpdate();
			System.out.println("Rows affected:" + rowCount);
			tx.commit();
			session.close();
			return rowCount;
			

		}
	

	public List<Inventory> trying() {
	   Session session = HibernateSessFact.getSession();
	   String hql = " from Inventory"; //prepared statement
	   Query query = session.createQuery(hql);
	   List<Inventory> results ;           //creating a list of inventory
	   results = session.createCriteria(Inventory.class).list();
		
	   System.out.println(results);
		return results;
	
	}
	

	
}

			 
	
	
