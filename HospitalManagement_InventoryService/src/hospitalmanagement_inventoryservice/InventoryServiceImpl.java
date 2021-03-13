package hospitalmanagement_inventoryservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author user
 *
 */
public class InventoryServiceImpl implements IInventoryService {

	HashMap<String, Float> inventoryQuantity = new HashMap<String, Float>();
	HashMap<String, String> drugCategory = new HashMap<String, String>();

	Scanner scn = new Scanner(System.in);

	public InventoryServiceImpl() {

		inventoryQuantity.put("Amoxicillin", (float) 800.0);
		inventoryQuantity.put("Benthyl", (float) 400.0);
		inventoryQuantity.put("Cetirizine", (float) 625.0);
		inventoryQuantity.put("Doxepin", (float) 380.0);
		inventoryQuantity.put("Heparin", (float) 1000.0);
		inventoryQuantity.put("Motrin", (float) 200.0);
		inventoryQuantity.put("Rituxan", (float) 1120.0);

		drugCategory.put("Wellwoman 50+ 30's - Rs.3300.00", "NUTRACEUTICALS");
		drugCategory.put("Wellwoman sport & fitness - Rs.3,065.00", "NUTRACEUTICALS");
		drugCategory.put("Ultra Vitamin D3 96's - Rs.1,824.00", "NUTRACEUTICALS");

		drugCategory.put("Ayurveda Immunity Booster Pack - Rs.950.00", "AYURVEDA");
		drugCategory.put("Dum Hattiya  - Rs.560.00", "AYURVEDAL");
		drugCategory.put("Peenus Thailaya - Rs.950.00", "AYURVEDA");

		drugCategory.put("Cow & Gate Next Steps 4 350g - Rs.990.00", "BABYCARE");
		drugCategory.put("Tiki Baby Bubbly Bunty Cologne 100ml - Rs.260.00", "BABYCARE");
		drugCategory.put("Bambi premium care X-Large 4s - Rs.200.00", "BABYCARE");

		drugCategory.put("Facia Day Cream Advanced Skin Whitening Formula 50g - Rs.720.00", "PERSONALCARE");
		drugCategory.put("Genove Pilopeptan Anti Hair Loss Shampoo 250Ml - Rs.4,940.00", "PERSONALCARE");
		drugCategory.put("SLC FACE WASH 50G - Rs.865.00", "PersonalCare");

		drugCategory.put("Bones -Up 200g - Rs.800.00", "PETCARE");
		drugCategory.put("Red Dogs 200ml - Rs.865.00", "PETCARE");
		drugCategory.put("Chicken Liver Bites - Rs.700.00", "PETCARE");

	}

	@Override
	public void DisplayAvailableInventory() {
		// TODO Auto-generated method stub

		System.out.println("Available Inventory " + "\n");
		for (Map.Entry<String, Float> Inventory : inventoryQuantity.entrySet()) {
			System.out.println(Inventory.getKey());
		}

	}
	
	@Override
	public void DisplayCategories() {
		System.out.println("------------------Available Categories--------------------------");
		System.out.println("NUTRACEUTICALS\nAYURVEDAL\nBABYCARE\nPERSONALCARE\nPETCARE\n");
		
		
	}

	@Override
	public void addInventory() {
		// TODO Auto-generated method stub

		System.out.print("Enter drug name : ");
		String _sDname = scn.nextLine();
		System.out.print("Enter quantity : ");
		Float addinventory = scn.nextFloat();

		inventoryQuantity.put(_sDname, addinventory);

		System.out.println("\n New drug " + _sDname + " is added to the stock with a quantity of : " + addinventory + "g");
	}

	@Override
	public void getInventoryItemAndReduceInventoryItem() {
		// TODO Auto-generated method stub
		float qty = 0;
		scn = new Scanner(System.in);

		/*
		 * System.out.print("Choose drug with quantity needed : "); String drugName =
		 * scn.nextLine(); Float quantity = scn.nextFloat();
		 */

		System.out.print("Choose drug: ");
		String drugName = scn.nextLine();

		for (Map.Entry<String, Float> Name : inventoryQuantity.entrySet()) {
			if (Name.getKey().contains(drugName)) {
				qty = Name.getValue();
			}
		}

		System.out.print("quantity needed (Available Quantity: " + qty + "g): ");
		Float quantity = scn.nextFloat();

		for (Map.Entry<String, Float> inventoryItemAndReduceInventoryItem : inventoryQuantity.entrySet()) {
			if (inventoryItemAndReduceInventoryItem.getKey().contains(drugName)) {
				if (inventoryItemAndReduceInventoryItem.getValue() >= quantity) {
					inventoryQuantity.replace(drugName, inventoryItemAndReduceInventoryItem.getValue() - quantity);
					System.out.println(drugName + " (" + quantity + "g) is successfully taken out." + "\n");
					System.out.println("Available Quantity: " + (qty - quantity) + "g");
					return;
				} else {
					System.out.println("\nNo enough stock");
					return;
				}
			}
		}

		System.out.println("Invalid Drug Name");

	}

	@Override
	public void getInventoryWithLessItems() {
		// TODO Auto-generated method stub
		System.out.println("\n-------------------------------------------------");
		System.out.println("      drugs with stock less than 500.0g");
		System.out.println("----------------------------------------------------");
		for (Map.Entry<String, Float> inventoryWithLessItems : inventoryQuantity.entrySet()) {
			if (inventoryWithLessItems.getValue() < 500.0) {
				System.out.println("\t" +inventoryWithLessItems.getKey());
			}

		}

	}

	@Override
	public ArrayList<String> GetPhamacyDrugList(String Name) {
		// Creating an arraylist to store reports status
		ArrayList<String> name = new ArrayList<String>();

		System.out.println("\n------------------------------------------------------");
		System.out.println("List of products for " + Name);
		System.out.println("-------------------------------------------------------");
		// Get reports status
		for (Map.Entry<String, String> DrugList : drugCategory.entrySet()) {
			if (DrugList.getValue().equalsIgnoreCase(Name)) {
				name.add(DrugList.getKey());
			}
		}

		return name;
	}

	@Override
	public void DeleteDrugs(String Name) {
		try {
			if (inventoryQuantity.containsKey(Name)) {
				
				inventoryQuantity.remove(Name);
				System.out.println(Name + " is successfully deleted" + "\n");
				
			}else {
				System.out.println("Invalid Drug");
			}
		} catch (Exception e) {
			System.out.println("Invalid Entry");
		}
		
	}



}
