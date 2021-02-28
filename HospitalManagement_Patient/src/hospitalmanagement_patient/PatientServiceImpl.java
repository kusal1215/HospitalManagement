package hospitalmanagement_patient;

import java.util.InputMismatchException;
import java.util.Scanner;

import hospitalmanagement_centralserver.ICentralServer;

public class PatientServiceImpl implements IPatientService {
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void run(ICentralServer iCentralServer) {
		// TODO Auto-generated method stub
		
		
		while(true) {
			System.out.println("01 - Find Doctors\n02 - Find An Emergancy Service\n03 - Find Lab Service\n0 - Exit\n");
			System.out.println("Please Select a Service :");
			
			try {
				
				int iService = sc.nextInt();
				
				switch (iService) {
				
				case 1:iCentralServer.handleDocotoService();
					break;
				case 0: System.exit(0);
					break;
				default:System.out.println("####### please select one  from the list #######\n");
				}
				
			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("error, please select a valid input");
			}
		}
		
	}

}
