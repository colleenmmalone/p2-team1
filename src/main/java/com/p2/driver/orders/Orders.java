package com.p2.driver.orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

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
public class Orders {
	@Id
	@GeneratedValue
	@Column(name="orderid")
	private int orderid;
	@Column(name="customer", insertable=false, updatable=false)
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
	@JoinColumn(name="customer", nullable=false)
	@JsonIgnore
	private Logins logins;
	
	public Orders(int orderid, int customer, double total, Date orderDate, String orderStatus) {
		super();
		this.orderid = orderid;
		this.customer = customer;
		this.total = total;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}


}
