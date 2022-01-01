package com.p2.driver.orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.p2.driver.ordercontents.OrderContents;

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
	@GeneratedValue
	@Column(name="orderid")
	private int orderID;
	@Column(name="customer")
	private int customer;
	@Column(name="total")
	private double total;
	@Column(name="order_date")
	private Date orderDate;
	@Column(name="order_status")
	private String orderStatus;

	@ToString.Exclude
	@OneToMany(mappedBy="orders", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	private List<OrderContents> orderContents;
	
	public Orders(int orderID, int customer, double total, Date orderDate, String orderStatus) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.total = total;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}


}
