/**
 * 
 */
package hospitalmanagement_laboratoryservice;

import java.util.ArrayList;

/**
 * @author oshadi
 *
 */
public interface ILaboratoryService {
	
	/* public ArrayList<String> DisplayTestTypes(); */
	public void DisplayLaboratories();
	public ArrayList<String> getNearByLab(String Area);
	/* public double CalculateTot(); */
	
	//New method
	public ArrayList<String> GetReportStatus(String status);
	public void AddReport(String name, String Status);
	public void DeleteReport(String name);
	public void UpdateReportStatus(String name, String Status);
}
