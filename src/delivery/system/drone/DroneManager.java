package delivery.system.drone;

import java.util.LinkedList;
import java.util.List;

public class DroneManager implements DroneManagerInterface {
	private List<Drone> drones = new LinkedList<>();
	
	public void addDrone(Drone drone){
		drones.add(drone);
	}

	public void setBattery_units_to_maximum() {
		for (Drone drone: this.drones) {
			drone.setBattery_units(drone.getMaximumBatteryUnits());
		}
	}
	
	@Override
	public boolean hasDrones(RequestResult reqRes) {
		if (!reqRes.isExecutable()){
			return false;
		}
		charge_drones();
		int distance = (int)Math.ceil(Coordinates.calculateDistance(
				reqRes.getTargetCoordinates(), reqRes.getWarehouseCoordinates()));
		
		float weight = reqRes.getTotalWeight();
		List<Drone> used = new LinkedList<>();
		for (Drone drone :drones){
			if (weight <= 0){
				break;
			}
			if (drone.getBattery_units() >= 2*distance){
				used.add(drone);
				weight -= drone.getCapacity();
			}
		}
		if (weight <= 0){
			for (Drone drone : used){
				int currentBattery = drone.getBattery_units();
				drone.setBattery_units(currentBattery - 2*distance);
			}
			return true;
		}
		return false;
	}
	
	public static void chargeDrones(RequestResult reqRes) {
		<?> log = DeliveryLog.getDeliveryLog();
		if (reqRes.id < 1) {
			break;
		} else {
			batteryToCharge = calcBatteryToCharge(log[reqRes.id - 1], log[reqRes.id]);
			droneManager.chargeDrones(range);
		}
	}
	
	public static int calcBatteryToCharge(int delivery_1, int delivery_2) {
		batteryUnits = (delivery_2 - delivery_2) * Drone.chargeRate;
		return batteryUnits;
	}
	
	@Override
	public String toString() {
		return "DroneManager [drones=" + drones + "]";
	}

}
