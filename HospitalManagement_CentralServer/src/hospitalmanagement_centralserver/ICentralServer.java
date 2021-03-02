package hospitalmanagement_centralserver;

public interface ICentralServer {

//	Hospital(doctor) Management Services
	public void handleDocotoService();	
	
//	Emergency Managemnet Services
	public void handleEmergencyService();
	
//  Inventory Management Services	
	public void DisplayAvailableInventory();
	public void addInventory();
	public void getInventoryItemAndReduceInventoryItem();
	public void getInventoryWithLessItems();
}
