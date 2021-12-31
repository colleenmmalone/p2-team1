package com.p2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
// one order can have many order contents. Use one-to-many mapping for orderid
//many to many between orders and ordercontents

@Entity
@Table (name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int orderID;
	@Column
	private int customer;
	@Column
	private double total;
	@Column
	private Date orderDate;
	@Column
	private String orderStatus;
	
	@OneToOne(mappedBy = "orders")
	private Logins logins;
//	@ManyToMany(targetEntity = OrderContents.class, cascade = {CascadeType.ALL})
	@ManyToMany(targetEntity = OrderContents.class, cascade = {CascadeType.ALL})
	@JoinTable (name = "Orders_OrderContents")
 @JoinColumn(name = "orderid")
	
	private Set<OrderContents> orderContents;
	
	public Orders(int orderID, int customer, double total, Date orderDate, String orderStatus, Logins logins, Set<OrderContents> orderContents) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.total = total;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.logins = logins;
		this.orderContents = orderContents;
	}

	public Logins getLogins() {
		return logins;
	}

	public void setLogins(Logins logins) {
		this.logins = logins;
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

	public Set<OrderContents> getOrderContents() {
		return orderContents;
	}

	public void setOrderContents(Set<OrderContents> orderContents) {
		this.orderContents = orderContents;
	}
	
	

}
