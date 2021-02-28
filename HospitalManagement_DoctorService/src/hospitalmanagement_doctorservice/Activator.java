package hospitalmanagement_doctorservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	ServiceRegistration clientServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("********* Start Doctor Services *********\n");
		
		DoctorService doctorService = new DocotorServiceImpl();
		clientServiceRegistration = context.registerService(DoctorService.class.getName(), doctorService, null);
		
	}
	

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("********* Stopping Hospital Management *********");
		clientServiceRegistration.unregister();
		
	}

}
