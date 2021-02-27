package hospitalmanagement_doctorservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DocotorServiceImpl implements DoctorService {

	private HashMap<String, String> doctors = new HashMap<String, String>();
	
	public DocotorServiceImpl() {
		// TODO Auto-generated constructor stub
		
		doctors.put("Kusal", "Eye Surgeon");
		doctors.put("Yasasmi", "Cardiologist");
		doctors.put("Mala Sudusinghe","Eye Surgeon");
		doctors.put("Mihira Bandara","Surgeon");
		doctors.put("Imantha De Silva","Cardiologist");
		doctors.put("Visaka Rathnamalala","Hematologists");
		doctors.put("Manel Dissanayake","Dermatologist");
		doctors.put("Duminda Ariyarathne","Surgeon");
		doctors.put("Suresh Kottegoda","Cardiologist");
		doctors.put("Dharshan De silva","Physician");
		doctors.put("Anoma Abeygunawardhana","Pediatricians");
		doctors.put("A Shanthakumar","Neurologists");
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
		
		return "\nEye Surgeon\n"
				+ "Surgeon\n"
				+ "Cardiologist\n"
				+ "Hematologists\n"
				+ "Dermatologist\n"
				+ "Physician\n"
				+ "Pediatricians\n"
				+ "Neurologists\n";
	}
}