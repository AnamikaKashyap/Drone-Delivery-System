package delivery.system.drone;

import java.util.HashMap;
import java.util.Map;

public class Request {
	private int ID;
	private String timestamp;
	private Coordinates target_coordinates;
	private Map<Integer, Integer> products;
	
	public Request(){
		this.ID=0;
		this.timestamp=null;
		this.target_coordinates=null;
		this.products = new HashMap<>();
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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
		return products;
	}

	public void setProducts(Map<Integer, Integer> products) {
		this.products = products;
	}

	public static Request parse(String input){
		Request result = new Request();
		try{
			
			String[] splitted = input.split(" ");
			result.setID(Integer.parseInt(splitted[1]));
			result.setTimestamp(splitted[2] + splitted[3]);
			String[] coordinates = splitted[4].split(",");
			Coordinates newCoordinates = new Coordinates();
			newCoordinates.setX(Integer.parseInt(coordinates[0]));
			newCoordinates.setY(Integer.parseInt(coordinates[1]));
			result.setTarget_coordinates(newCoordinates);
			
			int size = splitted.length;
			for (int i=5;i<size;i+=2){
				int id = Integer.parseInt(splitted[i]);
				int quantity = Integer.parseInt(splitted[i+1]);
				result.products.put(id, quantity);
			}
		}catch (IllegalArgumentException e){
			e.printStackTrace();
		}
		return result;
	}
	
	//delivery <id> <timestamp> <target coordinates> <product id 1> <quantity> <product id 2> <quantity> ...
	public String toString(){
		StringBuilder result = new StringBuilder();
		result.append("Request ID: " + this.ID + "\n");
		result.append("Timestamp: " + this.timestamp + "\n");
		result.append("Target coordinates: " + this.target_coordinates + "\n");
		for (Map.Entry<Integer, Integer> entry : products.entrySet())
		{
		    result.append(entry.getKey() + " -> ");
		    result.append(entry.getValue() + "\n");
		}
		return result.toString();
	}
}
