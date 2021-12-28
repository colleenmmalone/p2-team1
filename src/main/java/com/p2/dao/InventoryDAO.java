package com.p2.dao;

import com.p2.model.Inventory;
import org.hibernate.*;

public class InventoryDAO {
	 
	public int updateInventory(Inventory inventory) {
			
		   Session session = HibernateSessFact.getSession();
			Transaction tx = session.beginTransaction();	
			Query query = session.createQuery("update inventory\r\n"
					+ "set quantity= "+ inventory.getQuantity() +"\r\n"
					+ "where itemid= "+ inventory.getItemID()+ ";");
			int rowCount = query.executeUpdate();
			System.out.println("Rows affected:" + rowCount);
			tx.commit();
			session.close();
			return rowCount;
		}
	
	
}
			 
	
	
