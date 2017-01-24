package delivery.system.drone;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RequestManager {
	private Warehouse warehouse;
	private DroneManager droneManager;
	private List<Drone> dronesUsed = new LinkedList<Drone>();
	
	public RequestManager(Warehouse warehouse, DroneManager droneManager) {
		this.warehouse = warehouse;
		this.droneManager = droneManager;
	}
	
	public RequestResult warehouseHasProducts(Request request) {
		return this.warehouse.hasProducts(request);
	}
	
	public boolean droneManagerHasDrones(RequestResult result) {
		return this.droneManager.hasDrones(result);
	}
	
	public void reduceProductQuantity(Map<Integer, Integer> quantities, Request request) {
		for (Map.Entry<Integer, Integer> entry : request.getProducts().entrySet()){
			int key = entry.getKey();
			int value = entry.getValue();
			quantities.computeIfPresent(key, (k, v) -> v - value);
		}
	}
	
	public void updateDroneBattery() {
		this.droneManager.setBattery_units_to_maximum();
	}
}
