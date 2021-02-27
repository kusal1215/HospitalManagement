package hospitalmanagement_doctorservice;

import java.util.ArrayList;
import java.util.HashMap;

public interface DoctorService {
	
	public ArrayList<String> getDoctorsBySpecialization(String specialization);
	
	public String displaySpecializations();

}
