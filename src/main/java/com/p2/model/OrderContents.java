package com.p2.model;

import java.util.Set;

import javax.persistence.*;
//many to many between orders and ordercontents

@Entity
@Table(name = "ordercontents")
public class OrderContents {
	@Id
	private int orderContentsId;
	@Column
	private int orderID;
	@Column
	private int quantity;
	@Column
	private String item;
	@Column
	private double price;
	
	@ManyToMany (mappedBy = "ordercontents")
	Set<Orders> orders;

	public OrderContents(int quantity, String item, double price, Set<Orders> orders) {
		super();
		this.quantity = quantity;
		this.item = item;
		this.price = price;
		this.orders = orders;
	}


	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public OrderContents() {
	}

	public int getOrderContentsId() {
		return orderContentsId;
	}

	public void setOrderContentsId(int orderContentsId) {
		this.orderContentsId = orderContentsId;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
/*	public Orders getOrders() {
		return orders;
	}
	
	public void setOrders(Orders orders) {
		this.orders = orders;
	} */

	@Override
	public String toString() {
		return "OrderContents [itemID=" + orderContentsId + ", orderID=" + orderID + ", quantity=" + quantity + ", item=" + item
				+ ", price=" + price + "]";
	}

}
