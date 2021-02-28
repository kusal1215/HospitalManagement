package hospitalmanagement_centralserver;

import java.util.ArrayList;
import java.util.Scanner;

import hospitalmanagement_doctorservice.DocotorServiceImpl;
import hospitalmanagement_doctorservice.DoctorService;

public class CentralServerImpl implements ICentralServer {

	DoctorService doctorService = new DocotorServiceImpl();
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

}
