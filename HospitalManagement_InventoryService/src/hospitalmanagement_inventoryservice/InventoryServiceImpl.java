package hospitalmanagement_inventoryservice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author user
 *
 */
public class InventoryServiceImpl implements IInventoryService {
	
	HashMap<String, Float> inventoryQuantity = new HashMap<String, Float>();
	
	Scanner scn = new Scanner(System.in);
	
	
	public InventoryServiceImpl() {
		
		inventoryQuantity.put("Amoxicillin", (float) 800.0);
		inventoryQuantity.put("Benthyl", (float) 400.0);
		inventoryQuantity.put("Cetirizine", (float) 625.0);
		inventoryQuantity.put("Doxepin", (float) 380.0);
		inventoryQuantity.put("Heparin", (float) 1000.0);
		inventoryQuantity.put("Motrin", (float) 200.0);
		inventoryQuantity.put("Rituxan", (float) 1120.0);
		
	}


	
	@Override
	public void DisplayAvailableInventory() {
		// TODO Auto-generated method stub
		
		System.out.println("Available Inventory "+"\n");
		for(Map.Entry<String, Float> Inventory : inventoryQuantity.entrySet()) {
			System.out.println(Inventory.getKey());
		}
		
	}



	@Override
	public void addInventory() {
		// TODO Auto-generated method stub
		
		System.out.print("Enter drug name : ");
		String _sDname = scn.nextLine();
		System.out.print("Enter quantity : ");
		Float addinventory = scn.nextFloat();
		
		inventoryQuantity.put(_sDname,addinventory);
		
		System.out.println("New drug " +_sDname+" is added to the stock with a quantity of : " +addinventory);
//		System.out.println("\n");
	}



	@Override
	public void getInventoryItemAndReduceInventoryItem() {
		// TODO Auto-generated method stub
		
		scn = new Scanner(System.in);
		
		System.out.print("Choose drug with quantity needed : ");
		String drugName = scn.nextLine();
		Float quantity = scn.nextFloat();
		
		for(Map.Entry<String, Float> inventoryItemAndReduceInventoryItem : inventoryQuantity.entrySet()) {
			if(inventoryItemAndReduceInventoryItem.getKey().contains(drugName)) {
				if(inventoryItemAndReduceInventoryItem.getValue() >= quantity) {
					inventoryQuantity.replace(drugName, inventoryItemAndReduceInventoryItem.getValue() - quantity);
					System.out.println(drugName+" is successfully taken out");
					return;
				}
				else {
					System.out.println("No enough stock");
					return;
				}
			}
		}
		
		System.out.println("Invalid Drug Name");
		
	}



	@Override
	public void getInventoryWithLessItems() {
		// TODO Auto-generated method stub
		for(Map.Entry<String, Float>inventoryWithLessItems : inventoryQuantity.entrySet()) {
			if(inventoryWithLessItems.getValue() < 500.0) {
				System.out.println(inventoryWithLessItems.getKey());
			}
			
		}
//		System.out.println("\n");
		
	}



	






}
