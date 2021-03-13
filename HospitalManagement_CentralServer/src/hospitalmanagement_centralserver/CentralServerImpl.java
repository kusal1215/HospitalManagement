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

	}
	
	public void UpdateDoctorTimeSlots() {
		
		System.out.print("Enter Doctor Name: ");
		String doctortName = sc.nextLine();
		System.out.println("Please enter time:");
		String timeSlot = sc.nextLine();
		
		System.out.println(doctortName +" / " + timeSlot);
		
		doctorService.UpdateDoctorTimeSlots(doctortName, timeSlot);;
		
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

		System.out.println("---------------Available laboratory in " + area + "-------------------");
		
		for (String lab : labs) {
			System.out.println(lab + "\n");
		}
	}

	@Override
	public void GetReports() {
		try {
			System.out.print("Please select Report status (Delivered/ Not-Delivered): ");
			String status = sc.next();
			
			if (status.equalsIgnoreCase("Delivered") || status.equalsIgnoreCase("Not-Delivered")) {
				ArrayList<String> Reportstatus = iLaboratoryService.GetReportStatus(status);
				for (String Reportlist : Reportstatus) {
					System.out.println(Reportlist);
				}					
			}
			else {
				System.out.println("Invalid Status");
			}
		} catch (Exception e) {
			System.out.println("Invalid Status");
		}

	}

	@Override
	public void AddReport() {
		
		String status = null;

		System.out.print("Enter report: ");
		String name = sc.nextLine();
		System.out.println("Please enter status\t01 - Delivered \n\t\t\t02 - Not-Delivered");
		System.out.print("Status: ");
		String statusnum = sc.nextLine();
		
		if (statusnum.contentEquals("1")) {
			status = "Delivered";
		}
		else if (statusnum.contentEquals("2")) {
			status = "Not-Delivered";
		} else {
			System.out.println("Invalid number");
		}
		
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
		String ReportStatus = null;
		
		System.out.print("Enter report: ");
		String ReportName = sc.nextLine();
		System.out.println("Please enter status\t01 - Delivered \n\t\t\t02 - Not-Delivered");
		System.out.print("Status: ");
		int ReportStatusNum = sc.nextInt();
		
		if (ReportStatusNum == 1) {
				ReportStatus = "Delivered";
		}
		else if (ReportStatusNum == 2) {
			ReportStatus = "Not-Delivered";
		} else {
			System.out.println("Invalid number");
		}
		
		iLaboratoryService.UpdateReportStatus(ReportName, ReportStatus);
		
	}

	
}
