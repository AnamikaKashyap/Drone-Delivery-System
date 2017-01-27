package delivery.system.drone;

public class Main {

	public static void main(String[] args) {
		Warehouse warehouse = Factory.createWarehouse();
		DroneManager droneManager = Factory.createDroneManager();
		RequestManager deliveryManager = Factory.createRequestManager(warehouse, droneManager);
		
		while(true) {
			DeliveryRequest request = InputParser.readRequest();
			
			System.out.println(deliveryManager.handleRquest(request));
			
		}
	}

}
