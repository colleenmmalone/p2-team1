package com.p2.driver.orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.p2.driver.logins.Logins;
import com.p2.driver.ordercontents.OrderContents;

import lombok.Data;
import lombok.NoArgsConstructor;
// one order can have many order contents. Use one-to-many mapping for orderid
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity 
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="orderid")
	private Integer orderid;
	@Column(name="customer")
	private Integer customer;
	@Column(name="total")
	private double total;
	@Column(name="order_date")
	private Date orderDate;
	@Column(name="order_status")
	private String orderStatus;

	@ToString.Exclude
	@OneToMany(mappedBy="orders", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	private List<OrderContents> orderContents;
	
	@ToString.Exclude
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Logins logins;
	
	public Orders(int orderid, Integer customer, double total, Date orderDate, String orderStatus) {
		super();
		this.orderid = orderid;
		this.customer = customer;
		this.total = total;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}


}
