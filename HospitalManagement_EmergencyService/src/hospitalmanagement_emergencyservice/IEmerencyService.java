package hospitalmanagement_emergencyservice;

import java.util.ArrayList;

public interface IEmerencyService {

	public ArrayList<String> getEmergencyServiceByZone(String zone);
	
	public String displayZones();
	
	public void addEmergencyDriver();
	
	public void DeleteEmergencyDriver(String name);
	
	public ArrayList<String> getExtraDetails(String number);
	
}
