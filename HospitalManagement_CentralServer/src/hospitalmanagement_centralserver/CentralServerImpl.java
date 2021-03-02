package hospitalmanagement_centralserver;

import java.util.ArrayList;
import java.util.Scanner;

import hospitalmanagement_doctorservice.DocotorServiceImpl;
import hospitalmanagement_doctorservice.DoctorService;
import hospitalmanagement_inventoryservice.IInventoryService;
import hospitalmanagement_inventoryservice.InventoryServiceImpl;
import hotelmanagement_emergencyservice.IEmerencyService;
import hotelmanagement_emergencyservice.IEmerencyServiceImpl;

public class CentralServerImpl implements ICentralServer {
	
	

	DoctorService doctorService = new DocotorServiceImpl();
	IEmerencyService emerencyService = new IEmerencyServiceImpl();
	IInventoryService inventoryService= new InventoryServiceImpl() ;
		
	
	
	Scanner sc = new Scanner(System.in);

	@Override
	public void handleDocotoService() {
		// TODO Auto-generated method stub
		System.out.println(doctorService.displaySpecializations());
		System.out.println("Select Specializations from above :");

		String userInput = sc.next();

		ArrayList<String> doctorList = doctorService.getDoctorsBySpecialization(userInput);

		for (String name : doctorList) {
			System.out.println("Dr." + name + "\n");
		}
	}
	
	public void handleEmergencyService() {
		// TODO Auto-generated method stub
		System.out.println(emerencyService.displayZones());
		System.out.println("Select zone from above :");

		String userInput = sc.next();

		ArrayList<String> emegencyList = emerencyService.getEmergencyServiceByZone(userInput);

		for (String contactNumber : emegencyList) {
						
			System.out.println(userInput + " Emergency serivce Contact No:" + contactNumber + "\n");
		}
	}

	@Override
	public void DisplayAvailableInventory() {
		// TODO Auto-generated method stub
		
		inventoryService.DisplayAvailableInventory();
	}

	@Override
	public void addInventory() {
		// TODO Auto-generated method stub
		inventoryService.addInventory();
	}

	@Override
	public void getInventoryItemAndReduceInventoryItem() {
		// TODO Auto-generated method stub
		inventoryService.getInventoryItemAndReduceInventoryItem();
		
	}

	@Override
	public void getInventoryWithLessItems() {
		// TODO Auto-generated method stub
		inventoryService.getInventoryWithLessItems();
		
	}

}
