package hospitalmanagement_patient;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import hospitalmanagement_centralserver.ICentralServer;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	IPatientService iPatientService = new PatientServiceImpl();

	public void start(BundleContext context) throws Exception {

		
		serviceReference = context.getServiceReference(ICentralServer.class.getName());
		ICentralServer centralServer = (ICentralServer) context.getService(serviceReference);
		
		iPatientService.run(centralServer);
	}

	public void stop(BundleContext context) throws Exception {
		
	}

}
