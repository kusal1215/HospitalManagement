/**
 * 
 */
package hospitalmanagement_inventoryservice;

import java.util.ArrayList;

/**
 * @author user
 *
 */
public interface IInventoryService {
	
	public void DisplayAvailableInventory();
	public void addInventory();
	public void getInventoryItemAndReduceInventoryItem();
	public void getInventoryWithLessItems();
	public void DeleteDrugs(String Name);
	 
	public void DisplayCategories();
	public ArrayList<String> GetPhamacyDrugList(String Name);
	

}
