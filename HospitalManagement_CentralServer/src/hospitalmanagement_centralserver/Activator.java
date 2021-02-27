package hospitalmanagement_centralserver;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
		ICentralServer centralServer = new CentralServerImpl();
		
		serviceRegistration = context.registerService(ICentralServer.class.getName(), centralServer, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		serviceRegistration.unregister();
		}

}
