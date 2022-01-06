package com.p2.driver.ordercontents;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.p2.driver.orders.Orders;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "ordercontents")
public class OrderContents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ordercontentsid;
	
	@Column(name="orderid")
	private Integer orderid;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="item")
	private String item;
	
	@Column(name="price")
	private double price;
	
	@ToString.Exclude
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="orderid", nullable=false, insertable=false, updatable=false)
	@JsonIgnore
	private Orders orders;
	
	
//	public Orders getOrders() {
//		return this.orders;
//	}
//	
//	public void setOrders(Orders orders) {
//		this.orders = orders;
//	}

}
