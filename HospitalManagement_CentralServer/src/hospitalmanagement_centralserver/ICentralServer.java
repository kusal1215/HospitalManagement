package hospitalmanagement_centralserver;

public interface ICentralServer {

//	Hospital(doctor) Management Services
	public void handleDocotoService();	
	
//	Emergency Management Services
	public void handleEmergencyService();
	public void addEmergencyDriver();
	public void DeleteEmergencyDriver();
	
//  Inventory Management Services	
	public void DisplayAvailableInventory();
	public void addInventory();
	public void getInventoryItemAndReduceInventoryItem();
	public void getInventoryWithLessItems();
	
//	Laboratory Management Services
	public void handleLabService();
	
	public void GetReports(); 
	public void AddReport();
	public void DeleteReport();
}
