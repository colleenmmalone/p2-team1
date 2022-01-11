package com.p2.driver.inventory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p2.driver.ordercontents.OrderContents;

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
			return inventoryRepository.findById(id);
		}

	//update quantity  on inventory
		public String updateQuantity(Inventory inventory, Integer id ) {
			Inventory invent = inventoryRepository.findById(id).get();
			System.out.println(invent);
			invent.setQuantity(inventory.getQuantity());
			invent.setPrice(inventory.getPrice());
			inventoryRepository.save(invent);
			return "For "+invent.getItems()+" qty was set to "+invent.getQuantity()+" and price was set to "+invent.getPrice();
		}
	
	
	//add a new item to inventory
	public void addItem(Inventory inventory) {
			inventoryRepository.save(inventory);
			
	}
}
