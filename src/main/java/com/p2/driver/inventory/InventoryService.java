package com.p2.driver.inventory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	//Retrieve a list of the inventory
	public List<Inventory> getAllInventory(){
		return inventoryRepository.findAll();
	}
	//Retrieve item based on id
		public Optional<Inventory> getItemById(int id){
			Optional<Inventory> inventory = inventoryRepository.findById(id);
			return inventory;
		}

	//update quantity  on inventory
		public void updateInventory(Inventory inventory,int id ) {
			Inventory invent = inventoryRepository.findById(id).get();
			invent.setItems(inventory.getItems());
			invent.setQuantity(inventory.getQuantity());
		}
	
	
	//add a new item to inventory
	public void addItem(Inventory inventory) {
			inventoryRepository.save(inventory);
			
	}
}
