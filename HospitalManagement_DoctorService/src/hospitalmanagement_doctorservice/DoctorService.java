package hospitalmanagement_doctorservice;

import java.util.ArrayList;
import java.util.HashMap;

public interface DoctorService {
	
	public ArrayList<String> getDoctorsBySpecialization(String specialization);
	
	public String displaySpecializations();
	
	public void addDoctortoSystem();
	
	public ArrayList<String> displayDoctorsAvailableTime(String doctor_name);
	
	public void UpdateDoctorTimeSlots(String doctortName, String timeSlot);
}
