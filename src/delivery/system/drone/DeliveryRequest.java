package delivery.system.drone;

import java.util.Map;

public class DeliveryRequest {
	//TODO make things final
	private final int ID;
	private String timestamp;
	private Coordinates target_coordinates;
	private Map<Integer, Integer> idToQuantity;

	public DeliveryRequest(int id,
			String timestamp,
			Coordinates coordinates,
			Map<Integer, Integer> idToQuantity) {
		this.ID = id;
		this.timestamp = timestamp;
		this.target_coordinates = coordinates;
		this.idToQuantity = idToQuantity;
	}

	public int getID() {
		return ID;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Coordinates getTarget_coordinates() {
		return target_coordinates;
	}

	public void setTarget_coordinates(Coordinates target_coordinates) {
		this.target_coordinates = target_coordinates;
	}

	public Map<Integer, Integer> getProducts() {
		return idToQuantity;
	}

	public void setProducts(Map<Integer, Integer> products) {
		this.idToQuantity = products;
	}
	// delivery <id> <timestamp> <target coordinates> <product id 1> <quantity>
	// <product id 2> <quantity> ...

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Request ID: " + this.ID + "\n");
		result.append("Timestamp: " + this.timestamp + "\n");
		result.append("Target coordinates: " + this.target_coordinates + "\n");
		for (Map.Entry<Integer, Integer> entry : idToQuantity.entrySet()) {
			result.append(entry.getKey() + " -> ");
			result.append(entry.getValue() + "\n");
		}
		return result.toString();
	}
}
