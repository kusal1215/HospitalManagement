package hospitalmanagement_doctorservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DocotorServiceImpl implements DoctorService {

	private HashMap<String, String> doctors = new HashMap<String, String>();
	private HashMap<String, String> doctors_available_time = new HashMap<String, String>();
	
	
	Scanner sc = new Scanner(System.in);
	
	public DocotorServiceImpl() {
		// TODO Auto-generated constructor stub
		
		doctors.put("Kusal", "EyeSurgeon");
		doctors.put("Yasasmi", "Cardiologist");
		doctors.put("oshadi","Eye Surgeon");
		doctors.put("kamal Bandara","Physician");
		doctors.put("rashmika De Silva","Cardiologist");
		doctors.put("Visaka Rathnamalala","Hematologists");
		doctors.put("Sunil Dissanayake","Dermatologist");
		doctors.put("Kisal Ariyarathne","Surgeon");
		doctors.put("Suresh Kottegoda","Cardiologist");
		
		
		doctors_available_time.put("6pm to 8pm Monday","Kusal");
		doctors_available_time.put("6pm to 9pm Sunday","Yasasmi");
		doctors_available_time.put("4pm to 7pm Sunday","Kisal Ariyarathne");
		doctors_available_time.put("4pm to 6pm Wednesday","oshadi");
		doctors_available_time.put("9am to 12pm Tusday","kamal Bandara");
		doctors_available_time.put("4.30pm to 6.30pm Friday","rashmika De Silva");
	}
	

	@Override
	public ArrayList<String> getDoctorsBySpecialization(String specialization) {
		// TODO Auto-generated method stub
		
		ArrayList<String> result = new ArrayList<String>();
		
		for(Map.Entry<String, String> doc : doctors.entrySet()) {
			
			if(doc.getValue().equalsIgnoreCase(specialization)) {
				result.add(doc.getKey());
			}
		}
		return  result;
	}
	

	public String displaySpecializations() {
		
		return "\nEyeSurgeon\n"
				+ "Surgeon\n"
				+ "Cardiologist\n"
				+ "Hematologists\n"
				+ "Dermatologist\n"
				+ "Physician\n"
				+ "Pediatricians\n"
				+ "Neurologists\n";
	}
	
	@Override
	public void addDoctortoSystem() {
		// TODO Auto-generated method stub
		
		System.out.print("Enter Full name : ");
		String fName = sc.nextLine();
		System.out.print("Enter Specialization : ");
		String Specialization = sc.nextLine();
		
		doctors.put(fName,Specialization);
		
		System.out.println("********New Doctor Succesfully added********\n" +"full name :"+fName +"\n"+"Specialization:"+ Specialization );
	}
	

	@Override
	public ArrayList<String> displayDoctorsAvailableTime(String doctor_name) {
		// TODO Auto-generated method stub
		
		ArrayList<String> result = new ArrayList<String>();
		
		for(Map.Entry<String, String> doc : doctors_available_time.entrySet()) {
			
			if(doc.getValue().equalsIgnoreCase(doctor_name)) {
				result.add(doc.getKey());
			}
		}

		return  result;
	}
	
	public void UpdateDoctorTimeSlots(String doctortName, String timeSlot) {
		try {
			for(Map.Entry<String, String> updateDoctorTimeSlot : doctors_available_time.entrySet()) {
				if (updateDoctorTimeSlot.getKey().contains(doctortName)) {
					doctors_available_time.replace(doctortName, timeSlot);
				}
			}
			
			System.out.println("Dr."+ doctortName + " Time Slot " + "Successfully Updated to " + timeSlot);
			
		} catch (Exception e) {
			System.out.println("Invalid Entry");
		}
		
	}
	
}
