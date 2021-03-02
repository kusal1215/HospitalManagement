package hospitalmanagement_laboratoryservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class laboratoryActivator implements BundleActivator {
	
	ServiceRegistration LaboratoryServiceRegistration;

	/*
	 * private static BundleContext context;
	 * 
	 * static BundleContext getContext() { return context; }
	 */

	public void start(BundleContext bundleContext) throws Exception {
		/* laboratoryActivator.context = bundleContext; */
		ILaboratoryService iLaboratoryService = new laboratoryServcieImpl();
		LaboratoryServiceRegistration = bundleContext.registerService(ILaboratoryService.class.getName(), iLaboratoryService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		/* laboratoryActivator.context = null; */
		LaboratoryServiceRegistration.unregister();
		
	}

}
