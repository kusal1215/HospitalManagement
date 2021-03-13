/**
 * 
 */
package hospitalmanagement_agent;

import java.util.InputMismatchException;
import java.util.Scanner;

import hospitalmanagement_centralserver.CentralServerImpl;
import hospitalmanagement_centralserver.ICentralServer;

/**
 * @author oshadi
 *
 */
public class AgentServiceImpl implements IAgentService {

	Scanner scn = new Scanner(System.in);
	private ICentralServer iCentralServer = null;

	@Override
	public void run(ICentralServer centralServer) {

		this.iCentralServer = centralServer;
		UserLogin();

	}

	@Override
	public void UserLogin() {

		String uname;
		String pwd;

		while (true) {
			System.out.print("Enter username : ");
			uname = scn.nextLine();

			System.out.print("Enter Password : ");
			pwd = scn.nextLine();

			int choice;

			if (uname.equalsIgnoreCase("Agent") && pwd.equals("agent@123")) {
				while (true) {
					System.out.println();
					System.out.println("1 : Get the Reports");
					System.out.println("2 : Update Report Status");
					System.out.println("0 : Exit");
					System.out.print("Choose the service you need : ");

					try {
						choice = scn.nextInt();

						switch (choice) {
						case 0:
							System.exit(0);
							break;
						case 1:
							iCentralServer.GetReports();break;
						case 2:
							iCentralServer.UpdateReport();break;
						/*
						 * case 2: iCentralServer.AddReport();break; case 3:
						 * iCentralServer.DeleteReport();break;
						 */
						default:
							System.out.println("Select a Number from the List");

						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid Input");

					}
				}
			}
		}
	}

}
