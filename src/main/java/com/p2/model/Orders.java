package com.p2.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Orders {
	@Id
	private int orderID;
	private int customer;
	private double total;
	private Date orderDate;
	private String orderStatus;
	
	public Orders(int orderID, int customer, double total, Date orderDate, String orderStatus) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.total = total;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	
	public Orders() {
		super();
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getCustomer() {
		return customer;
	}

	public void setCustomer(int customer) {
		this.customer = customer;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", customer=" + customer + ", total=" + total + ", orderDate=" + orderDate
				+ ", orderStatus=" + orderStatus + "]";
	}
	
	

}
