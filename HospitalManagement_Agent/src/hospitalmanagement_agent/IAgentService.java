/**
 * 
 */
package hospitalmanagement_agent;

import hospitalmanagement_centralserver.CentralServerImpl;
import hospitalmanagement_centralserver.ICentralServer;

/**
 * @author oshadi
 *
 */
public interface IAgentService {
	
	public void run(ICentralServer centralServer);
	
	public void UserLogin();


}
