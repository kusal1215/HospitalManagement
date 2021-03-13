package hospitalmanagement_agent;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import hospitalmanagement_centralserver.ICentralServer;

public class AgentActivator implements BundleActivator {

	
	ServiceReference serviceReference;
	IAgentService iAgentService = new AgentServiceImpl();
	
	
	public void start(BundleContext bundleContext) throws Exception {
//		AgentActivator.context = bundleContext;
		serviceReference = bundleContext.getServiceReference(ICentralServer.class.getName());
		ICentralServer centralServer = (ICentralServer) bundleContext.getService(serviceReference);
		
		iAgentService.run(centralServer);
	}

	public void stop(BundleContext bundleContext) throws Exception {
//		AgentActivator.context = null;
	}

}
