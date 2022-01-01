package com.p2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
// one order can have many order contents. Use one-to-many mapping for orderid
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table
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
	
	@ToString.Exclude
	private Set<OrderContents> orderContents;
	@ToString.Exclude
	private Logins user;
	
	public Orders(int orderID, int customer, double total, Date orderDate, String orderStatus) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.total = total;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

	
	public Set<OrderContents> getOrderContents() {
		return this.orderContents;
	}
	
	public void setOrderContents(Set<OrderContents> orderContents) {
		this.orderContents = orderContents;
	}


	public Orders(int orderID2, int customer2, String string, int i, String orderStatus2) {
		// TODO Auto-generated constructor stub
	}

}
