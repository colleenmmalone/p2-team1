package com.p2.model;
import javax.persistence.*;


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
	
	public Inventory(int itemID, String items, int quantity) {
		this.itemID = itemID;
		this.items = items;
		this.quantity= quantity;
	}
	
	public Inventory() {
		super();
	}
	public int getItemID() {
		return itemID;
	}
	
	public void setItemID(int itemID) {
		this.itemID= itemID;
	}
	
	public String getItems() {
		return items;
	}
	
	public void setItems(String items) {
		this.items = items;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity= quantity;
	}
	
	public String toString() {
		return "Inventory [itemID=" + itemID +", items=" + items +",quantity=" + quantity +"]";
	}
	
}
