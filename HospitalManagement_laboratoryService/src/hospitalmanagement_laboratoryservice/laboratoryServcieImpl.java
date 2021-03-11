/**
 * 
 */
package hospitalmanagement_laboratoryservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author oshadi
 *
 */
public class laboratoryServcieImpl implements ILaboratoryService {

	public static final String LABORATORIES = "\nMalabe\nKaduwela\nBattaramula\nKohuwala\n";
	public HashMap<String, String> LocationAndAvailableTime = new HashMap<String, String>();
	
	//new Method
	public HashMap<String, String> ReportsDelivery = new HashMap<String, String>();
	
	public laboratoryServcieImpl() {
		LocationAndAvailableTime.put("Sarvodya(8.30 am - 5.30 pm)", "Kaduwela");
		LocationAndAvailableTime.put("LHD(9.30 am - 7.30 pm)", "Malabe");
		LocationAndAvailableTime.put("Navodhya(10.30 am - 4.30 pm)", "Kohuwala");
		LocationAndAvailableTime.put("LabCorp(8.30 am - 5.30 pm)", "Battaramula");
	
//		new method
		ReportsDelivery.put("Ms. Madhura De Silva - LabCorp(Battaramulla)", "Delivered");
		ReportsDelivery.put("Mr. Lahiru De Silva - LHP(Malabe)", "Delivered");
		ReportsDelivery.put("Ms. Brenda De Silva - LabCorp(Battaramulla)", "Not-Delivered");
		ReportsDelivery.put("Ms. Liyanarachchi - LabCorp(Battaramulla)", "Not-Delivered");
	}
	
	@Override
	public void DisplayLaboratories() {
		// TODO Auto-generated method stub
		System.out.println(LABORATORIES);
		/*
		 * for (Map.Entry<String, String> locAndTime :
		 * LocationAndAvailableTime.entrySet()) {
		 * System.out.println(locAndTime.getValue()); }
		 */
	}

	
	@Override
	public ArrayList<String> getNearByLab(String Area) {
		
		//Creating an arraylist to store laboratory names with requested area
		ArrayList<String> LabName = new ArrayList<String>();
		
		//Get nearby laboratory according to the location
		for (Map.Entry<String, String> locAndTime : LocationAndAvailableTime.entrySet()) {
			if (locAndTime.getValue().equalsIgnoreCase(Area)) {
				
				LabName.add(locAndTime.getKey());
				
			}
			
		}
		
		return LabName;
	}

	

	@Override
	public ArrayList<String> GetReportStatus(String status) {
		//Creating an arraylist to store reports status
		ArrayList<String> Status = new ArrayList<String>();
		
		//Get reports status
		for (Map.Entry<String, String> ReportList : ReportsDelivery.entrySet()) {
			if (ReportList.getValue().equalsIgnoreCase(status)) {
				Status.add(ReportList.getKey());
			}
		}
		
		return Status;
	}

@Override
public void AddReport(String name, String Status) {
	
	ReportsDelivery.put(name, Status);
	
	System.out.println("New report " +name+" is added with the status of : " +Status);
	//	System.out.println("\n");
	System.out.println("\n------------------Report List--------------------");
	for(Map.Entry<String, String> ReportList : ReportsDelivery.entrySet()) {
		System.out.println("Name: " + ReportList.getKey() + "\nStatus: " + ReportList.getValue() + "\n\n");
	}
}

@Override
public void DeleteReport(String name) {
	
	try {
		ReportsDelivery.remove(name);
		System.out.println("Successfully deleted the " +name+ " report ");
	} catch (Exception e) {
		System.out.println("Invalide Entry");
	}

}

@Override
public void UpdateReportStatus(String name, String Status) {
	try {
		for(Map.Entry<String, String> UpdatedReport : ReportsDelivery.entrySet()) {
			if (UpdatedReport.getKey().contains(name)) {
				ReportsDelivery.replace(name, Status);
			}
		}
		
		System.out.println("Successfully Updated");
		
	} catch (Exception e) {
		System.out.println("Invalide Entry");
	}
	
}

	

}
