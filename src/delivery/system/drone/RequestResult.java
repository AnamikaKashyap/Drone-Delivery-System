package delivery.system.drone;

import java.util.LinkedList;
import java.util.List;

public class RequestResult {
	private boolean executable = false;
	private String log = "";
	private float totalWeight = 0;
	private Coordinates warehouseCoordinates = new Coordinates();
	private Coordinates targetCoordinates = new Coordinates();
	
	public boolean isExecutable() {
		return executable;
	}
	public void setExecutable(boolean executable) {
		this.executable = executable;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	public float getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(float totalWeight) {
		this.totalWeight = totalWeight;
	}
	public void addWeigth(float weight){
		this.totalWeight+= weight;
	}
	@Override
	public String toString() {
		return "RequestResult [executable=" + executable + ", log=" + log + ", totalWeight=" + totalWeight + "]";
	}
	public Coordinates getWarehouseCoordinates() {
		return warehouseCoordinates;
	}
	public void setWarehouseCoordinates(Coordinates warehouseCoordinates) {
		this.warehouseCoordinates = warehouseCoordinates;
	}
	public Coordinates getTargetCoordinates() {
		return targetCoordinates;
	}
	public void setTargetCoordinates(Coordinates targetCoordinates) {
		this.targetCoordinates = targetCoordinates;
	}
	
}
