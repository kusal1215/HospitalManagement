package hospitalmanagement_inventoryservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class InventoryServiceActivator implements BundleActivator {

	ServiceRegistration inventoryclientSerReg;


	

	public void start(BundleContext context) throws Exception {
		IInventoryService InventoryService = new InventoryServiceImpl();
		inventoryclientSerReg = context.registerService(IInventoryService.class.getName(), InventoryService, null);
	}
	

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping Inventry Service");
		inventoryclientSerReg.unregister();
	}


}
