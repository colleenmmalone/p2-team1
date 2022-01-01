package com.p2.driver;


@RestController
@RequestMapping("/inventory")
@CrossOrigign("*")

public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	@GetMapping
	public List<Inventory> getAllInventory(){
		return inventoryService.getAllInventory();
		
	}
	
	@GetMapping("/{id}")
	public Optional<Inventory> getItemById(PathVariable(required = true) int id){
		return inventoryService.getItemById;
	}
	
	@PostMapping
	public void addItem(@RequestBody Inventory inventory) {
		inventoryService.addItem(inventory);
	}
	
	@PutMapping
	public void addItem(@PathVariable(value = "id")int id, @RequestBody Inventory inventory) {
		inventorySeervice.updateInventory(inventory,id);
	}
	
}
