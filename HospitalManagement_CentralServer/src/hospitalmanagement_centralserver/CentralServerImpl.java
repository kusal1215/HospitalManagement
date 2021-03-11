package hospitalmanagement_centralserver;

import java.util.ArrayList;
import java.util.Scanner;

import hospitalmanagement_doctorservice.DocotorServiceImpl;
import hospitalmanagement_doctorservice.DoctorService;
import hospitalmanagement_emergencyservice.IEmerencyService;
import hospitalmanagement_emergencyservice.IEmerencyServiceImpl;
import hospitalmanagement_inventoryservice.IInventoryService;
import hospitalmanagement_inventoryservice.InventoryServiceImpl;
import hospitalmanagement_laboratoryservice.ILaboratoryService;
import hospitalmanagement_laboratoryservice.laboratoryServcieImpl;

public class CentralServerImpl implements ICentralServer {

	DoctorService doctorService = new DocotorServiceImpl();
	IEmerencyService emerencyService = new IEmerencyServiceImpl();
	IInventoryService inventoryService = new InventoryServiceImpl();
	ILaboratoryService iLaboratoryService = new laboratoryServcieImpl();

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

		System.out.println("Enter the doctor name that you need to check Availability :");

		String dconameInput = sc.next();

		ArrayList<String> doctorTimeSlotList = doctorService.displayDoctorsAvailableTime(dconameInput);

		for (String time_slot : doctorTimeSlotList) {
			System.out.println("Dr. " + dconameInput + " Available At " + time_slot);
			System.out.println("Contact Front Desk to Make An Appointment : 01119502049 \n");
		}

	}

	@Override
	public void addDoctortoSystem() {
		// TODO Auto-generated method stub
		doctorService.addDoctortoSystem();
		;

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

		System.out.println("Enter the Contact Number for extra details :");

		String Enumber = sc.next();

		ArrayList<String> emergencyDriverDetailstList = emerencyService.getExtraDetails(Enumber);

		for (String driver_details : emergencyDriverDetailstList) {
			System.out.println(" details regarding " + Enumber + "\n" + driver_details + "\n");

		}
	}

	@Override
	public void addEmergencyDriver() {
		// TODO Auto-generated method stub
		emerencyService.addEmergencyDriver();

	}

	@Override
	public void DeleteEmergencyDriver() {
		// TODO Auto-generated method stub
		System.out.print("Enter name: ");
		String DriverName = sc.nextLine();
		emerencyService.DeleteEmergencyDriver(DriverName);

	}

	
	//Invenory Service
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

	@Override
	public void getDrugList() {
		inventoryService.DisplayCategories();
		System.out.print("Please Type category: ");
		String category = sc.next();

		ArrayList<String> Druglist = inventoryService.GetPhamacyDrugList(category);
		for (String drug : Druglist) {
			System.out.println(drug);

		}
		
		System.out.println("\n");

	}

	@Override
	public void DeleteItems() {
		inventoryService.DisplayAvailableInventory();
		System.out.print("Enter Drug Name: ");
		String DrugtName = sc.nextLine();
		inventoryService.DeleteDrugs(DrugtName);
		
	}

	
	
	
	//Laboratory Service
	@Override
	public void handleLabService() {
		iLaboratoryService.DisplayLaboratories();

		System.out.print("Please select an area: ");
		String area = sc.next();

		ArrayList<String> labs = iLaboratoryService.getNearByLab(area);

		for (String lab : labs) {
			System.out.println(lab + "\n");
		}
	}

	@Override
	public void GetReports() {
		
		System.out.print("Please select Report status (Delivered/ Not-Delivered): ");
		String status = sc.next();

		ArrayList<String> Reportstatus = iLaboratoryService.GetReportStatus(status);
		for (String Reportlist : Reportstatus) {
			System.out.println(Reportlist);

		}

	}

	@Override
	public void AddReport() {
		System.out.print("Enter report: ");
		String name = sc.nextLine();
		System.out.print("Enter status (Delivered/ Not-Delivered): ");
		String status = sc.nextLine();

		iLaboratoryService.AddReport(name, status);

	}

	@Override
	public void DeleteReport() {
		System.out.print("Enter report: ");
		String ReportName = sc.nextLine();
		iLaboratoryService.DeleteReport(ReportName);

	}

	@Override
	public void UpdateReport() {
		System.out.print("Enter report: ");
		String ReportName = sc.nextLine();
		System.out.print("Status (Delivered/ Not-Delivered): ");
		String ReportStatus = sc.nextLine();
		iLaboratoryService.UpdateReportStatus(ReportName, ReportStatus);
		
	}

	
}
