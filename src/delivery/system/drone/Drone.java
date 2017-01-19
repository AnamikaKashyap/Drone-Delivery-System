package delivery.system.drone;

public class Drone {
	private int ID;
	private int battery_units;
	private float capacity;
	private int charging_units;
	
	public Drone(int ID, int battery_units, float capacity, int charging_units){
		this.ID=ID;
		this.battery_units=battery_units;
		this.capacity=capacity;
		this.charging_units=charging_units;
	}
	
	@Override
	public String toString() {
		return "Drone [ID=" + ID + ", battery_units=" + battery_units + ", capacity=" + capacity + ", charging_units="
				+ charging_units + "]";
	}

	public int getID() {
		return ID;
	}
	public int getBattery_units() {
		return battery_units;
	}
	public float getCapacity() {
		return capacity;
	}
	public int getCharging_units() {
		return charging_units;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setBattery_units(int battery_units) {
		this.battery_units = battery_units;
	}
	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}
	public void setCharging_units(int charging_units) {
		this.charging_units = charging_units;
	}
}
