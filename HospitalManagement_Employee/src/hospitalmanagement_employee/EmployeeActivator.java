package hospitalmanagement_employee;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import hospitalmanagement_centralserver.ICentralServer;

public class EmployeeActivator implements BundleActivator {

	
	ServiceReference serviceReference;
	IEmployee_Service iEmpolyeeService = new EmployeeServiceImpl();
	/*
	 * private static BundleContext context;
	 * 
	 * static BundleContext getContext() { return context; }
	 */

	public void start(BundleContext bundleContext) throws Exception {
//		EmployeeActivator.context = bundleContext;
		serviceReference = bundleContext.getServiceReference(ICentralServer.class.getName());
		ICentralServer centralServer = (ICentralServer) bundleContext.getService(serviceReference);
	
		iEmpolyeeService.run(centralServer);
	}

	public void stop(BundleContext bundleContext) throws Exception {
//		EmployeeActivator.context = null;
	}

}
