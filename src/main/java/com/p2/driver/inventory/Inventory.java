package com.p2.driver.inventory;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="inventory")
public class Inventory {

	

	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer itemid;
		@Column(name="items")
		private String items;
		@Column(name="quantity")
		private int quantity;	
		@Column
		private double price;
		@Column(name="store_img")
		private String storeImg;
	
}
