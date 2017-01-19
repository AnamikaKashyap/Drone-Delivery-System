package delivery.system.drone;

import java.util.Map;

public class RequestManager {
	private Warehouse warehouse;
	private DroneManager droneManager;
	
	public RequestManager(Warehouse warehouse, DroneManager droneManager) {
		this.warehouse = warehouse;
		this.droneManager = droneManager;
	}
	
	public void reduceProductQuantity(Map<Integer, Integer> quantities, Request request) {
		for (Map.Entry<Integer, Integer> entry : request.getProducts().entrySet()){
			int key = entry.getKey();
			int value = entry.getValue();
			quantities.computeIfPresent(key, (k, v) -> v - value);
		}
	}
	
	public void updateDroneBattery() {
		// TODO
	}
}
