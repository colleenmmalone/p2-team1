package com.p2.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
	
	private Orders orders;

	public OrderContents(int quantity, String item, double price, Orders orders ) {
		super();
		this.quantity = quantity;
		this.item = item;
		this.price = price;
		this.orders = orders;
	}

}
