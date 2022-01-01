package com.p2.driver;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

public class Inventory {

	
	@Data
	@NoArgsConstructor
	@Entity
	@Table(name="inventory")
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer itemid;
		@Column(name="items")
		private String items;
		@Column(name="quantity")
		private int quantity;
		
		@ToString.Exclude
	
}
