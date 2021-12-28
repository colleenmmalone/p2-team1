package com.p2.model;

import javax.persistence.*;

@Entity
@Table(name = "ordercontents")
public class OrderContents {
	@Id
	private int itemID;
	@Column
	@ManyToOne
	@JoinColumn(name = "orderID")
	private int orderID;
	@Column
	private int quantity;
	@Column
	private String item;
	@Column
	private double price;

	public OrderContents(int itemID, int orderID, int quantity, String item, double price) {
		super();
		this.itemID = itemID;
		this.orderID = orderID;
		this.quantity = quantity;
		this.item = item;
		this.price = price;
	}

	public OrderContents() {
		super();
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
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

	@Override
	public String toString() {
		return "OrderContents [itemID=" + itemID + ", orderID=" + orderID + ", quantity=" + quantity + ", item=" + item
				+ ", price=" + price + "]";
	}

}
