package com.p2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
// one order can have many order contents. Use one-to-many mapping for orderid

@Entity
@Table
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@OneToMany(mappedBy="orders")
	private int orderID;
	@Column
	private int customer;
	@Column
	private double total;
	@Column
	private Date orderDate;
	@Column
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
