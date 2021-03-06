/**
 * 
 */
package hospitalmanagement_employee;

import java.util.InputMismatchException;
import java.util.Scanner;

import hospitalmanagement_centralserver.ICentralServer;

/**
 * @author user
 *
 */
public class EmployeeServiceImpl implements IEmployee_Service {
	
	
	Scanner scn = new Scanner(System.in);
	private ICentralServer iCentralServer = null;


	@Override
	public void run(ICentralServer centralServer) {
		// TODO Auto-generated method stub
		this.iCentralServer = centralServer;
		UserLogin();
	}
	
	@Override
	public void UserLogin() {
		// TODO Auto-generated method stub
		
		String uname;
		String pwd;
		
		while(true) {
		
			System.out.print("Enter username : ");
			uname = scn.nextLine();
			
			System.out.print("Enter Password : ");
			pwd = scn.nextLine();
			
			int choice;
			
			
			
			
			
			
			if(uname.equalsIgnoreCase("Stock Manager") && pwd.equals("stock@123")){
				
				while (true) {	
				
					scn =  new Scanner(System.in);
				
					System.out.println();
					System.out.println("1 : Get the drugs with stock less than 500.0g");
					System.out.println("2 : Add new drugs to the stock");
					System.out.println("0 : Exit");
					System.out.print("Choose the service you need : ");
				
				
					try {
						choice = scn.nextInt();
					
						switch(choice) {
							case 1 : iCentralServer.getInventoryWithLessItems(); break;
							case 2 : iCentralServer.addInventory();break;
							case 0 : System.exit(0); break;
							default: System.out.println("Select a Number from the List");
						
						}
					}catch (InputMismatchException e) {
						System.out.println("Invalid Input");
				
					}
				}
			}
			else if(uname.equalsIgnoreCase("Pharmacy") && pwd.equals("pharmacy@123"))
			{
			
			while(true) {
					
					scn =  new Scanner(System.in);
					
					System.out.println();
					System.out.println("1 : Get a specific drug ");
					System.out.println("0 : Exit");
					
					System.out.print("Choose the service : ");
					
					try {
						
						int iInput = scn.nextInt();
						
						switch(iInput) {
							
							case 0:	System.exit(0);
									break;
							
							case 1:	iCentralServer.getInventoryWithLessItems();
									iCentralServer.getInventoryItemAndReduceInventoryItem();
									break;
								
							default:System.out.println("Please select a number from the list");
						}
								
					} catch (InputMismatchException e) {
						// TODO: handle exception
						System.out.println("Invalid Input");
					}
				}
			}
			else if(uname.equalsIgnoreCase("Emergency") && pwd.equals("emergency@123")) {
				while (true) {	
					
					scn =  new Scanner(System.in);
				
					System.out.println();
					System.out.println("1 : add a driver to emergrncy service");
					System.out.println("2 : delete driver");
					System.out.println("0 : Exit");
					System.out.print("Choose the service you need : ");
				
				
					try {
						choice = scn.nextInt();
					
						switch(choice) {
							case 1 : iCentralServer.addEmergencyDriver();; break;
							case 2 : iCentralServer.DeleteEmergencyDriver();break;
							case 0 : System.exit(0); break;
							default: System.out.println("Select a Number from the List");
						
						}
					}catch (InputMismatchException e) {
						System.out.println("Invalid Input");
				
					}
				}
			}
			
			else if(uname.equalsIgnoreCase("Doctor") && pwd.equals("doctor@123")) {
				while (true) {	
					
					scn =  new Scanner(System.in);
				
					System.out.println();
					System.out.println("1 : add a Docotr to system");
//					System.out.println("2 : delete driver");
					System.out.println("0 : Exit");
					System.out.print("Choose the service you need : ");
				
				
					try {
						choice = scn.nextInt();
					
						switch(choice) {
							case 1 : iCentralServer.addDoctortoSystem(); break;
//							case 2 : iCentralServer.DeleteEmergencyDriver();break;
							case 0 : System.exit(0); break;
							default: System.out.println("Select a Number from the List");
						
						}
					}catch (InputMismatchException e) {
						System.out.println("Invalid Input");
				
					}
				}
			}
			
			else {
				System.out.println("Incorrect user name and/or password\n");
			
			}
		
	}

	}


}
