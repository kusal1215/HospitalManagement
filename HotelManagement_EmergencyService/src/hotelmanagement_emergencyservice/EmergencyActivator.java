package hotelmanagement_emergencyservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class EmergencyActivator implements BundleActivator {

	ServiceRegistration clientServiceRegistration;

	public void start(BundleContext context) throws Exception {
		IEmerencyService emergencyService = new IEmerencyServiceImpl();
		clientServiceRegistration = context.registerService(IEmerencyService.class.getName(), emergencyService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("********* Stopping Hospital Management *********");
		clientServiceRegistration.unregister();
	}

}
