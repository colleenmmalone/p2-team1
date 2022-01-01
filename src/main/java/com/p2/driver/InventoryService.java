package com.p2.driver;

public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	//Retrieve a list of the inventory
	public List<Inventory> getAllInventory(){
		return inventoryRepository.findAll();
		
	//Retrieve item based on id
		public Optional<Inventory> getItemById(int id){
			Optional<Inventory> inventory = inventoryRepository.findById(id);
			return inventory;
		}
	}
	//update quantity  on inventory
		public void updateInventory(Inventory inventory,int id ) {
			Inventory inventory = inventoryRepository.findById(id).get();
			inventoryRepository.setItem(inventory.getItem());
			inventoryRepository.setQuantity(inventory.getQuantity());
		}
	
	
	//add a new item to inventory
	public void addItem(Inventory inventory) {
			inventoryRepository.save(inventory);
			
	}
}
