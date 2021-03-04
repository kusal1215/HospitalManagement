package hotelmanagement_emergencyservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IEmerencyServiceImpl implements IEmerencyService {
	
	private HashMap<String, String> zones = new HashMap<String, String>();
	
	private HashMap<String, String> emergency_drivers = new HashMap<String, String>();
	
	Scanner sc = new Scanner(System.in);
	
	public IEmerencyServiceImpl() {
		// TODO Auto-generated constructor stub
		
		zones.put("111", "Colombo1");
		zones.put("112", "Colombo2");
		zones.put("113","Colombo3");
		zones.put("114","Colombo4");
		zones.put("115","Colombo5");
		
		
	}

	@Override
	public ArrayList<String> getEmergencyServiceByZone(String zone) {
		// TODO Auto-generated method stub
		
		ArrayList<String> result = new ArrayList<String>();
		
		for(Map.Entry<String, String> emergency : zones.entrySet()) {
			
			if(emergency.getValue().equalsIgnoreCase(zone)) {
				
				result.add(emergency.getKey());
			}
		}

		return  result;
	}

	@Override
	public String displayZones() {
		// TODO Auto-generated method stub
		
		return "\ncolombo1\n"
		+ "colombo2\n"
		+ "colombo3\n"
		+ "colombo4\n"
		+ "colombo5\n"
		+ "colombo6\n";
		
	}
	
	@Override
	public void addEmergencyDriver() {
		// TODO Auto-generated method stub
		
		System.out.print("Enter Full name : ");
		String fName = sc.nextLine();
		System.out.print("Enter Driving License Number : ");
		String dLicense = sc.nextLine();
		
		emergency_drivers.put(fName,dLicense);
		
		System.out.println("********New Driver Details Succesfully added********\n" +"full name :"+fName +"\n"+"License No:"+ dLicense );
	}

	
	@Override
	public void DeleteEmergencyDriver(String name) {
		
		try {
			emergency_drivers.remove(name);
			System.out.println("'" +name + "'" +"this user deleted");
		} catch (Exception e) {
			System.out.println("Invalide Driver");
		}

	}
}
