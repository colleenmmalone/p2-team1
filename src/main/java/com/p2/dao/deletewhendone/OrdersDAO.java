package com.p2.dao.deletewhendone;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.p2.model.deletewhendone.Orders;
import com.p2.util.HibernateSessFact;

public class OrdersDAO {
	
	// retrieves a list of all the orders
	public List<Orders> getAllOrders() {
		try (Session session = HibernateSessFact.getSession()) {
			return session.createQuery("From Orders", Orders.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	// retrieve order based on orderid		
	public List<Orders> getOneOrder(int orderid) {
		try (Session session = HibernateSessFact.getSession()) {
			return session.createQuery("From Orders where orderid=" + orderid, Orders.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// delete order
	
	public boolean deleteOrder(int orderid) {
		try (Session session = HibernateSessFact.getSession()) {
			Transaction transaction = session.beginTransaction();
			session.createQuery("Delete From Orders where orderid=" + orderid, Orders.class).list();
			transaction.commit();
			session.close();
			
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// updates an order 
//	public boolean updateOrders(Orders order) {
//		try (Session session = HibernateSessFact.getSession()) {
//			Transaction transaction = session.beginTransaction();
//			Orders updateOrder = session.load(Orders.class, order.getOrderID());
//			updateOrder.setCustomer(order.getCustomer());
//			updateOrder.setTotal(order.getTotal());
//			updateOrder.setOrderStatus(order.getOrderStatus());
//			updateOrder.setOrderDate(order.setOrderDate(date));
//			
//			session.update(updateOrder);
//			transaction.commit();
//			session.close();
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//		
	

}
 