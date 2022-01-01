package com.p2.model;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="inventory")
public class Inventory {
	@Id
	@GeneratedValue
	@Column
	private int itemID;
	@Column
	private String items;
	@Column
	private int quantity;
	
}
