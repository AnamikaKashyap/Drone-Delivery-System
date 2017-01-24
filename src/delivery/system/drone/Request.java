package delivery.system.drone;

import java.util.HashMap;
import java.util.Map;

public class Request {
	private int ID;
	private String timestamp;
	private Coordinates target_coordinates;
	private Map<Integer, Integer> products;
	private Map<Integer, SupplyRequestHelper> supply;
	
	

	public Request(){
		this.ID=0;
		this.timestamp=null;
		this.target_coordinates=null;
		this.products = new HashMap<>();
		this.supply=new HashMap<>();
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
	
	public Map<Integer, SupplyRequestHelper> getSupply() {
		return supply;
	}
	//delivery <id> <timestamp> <target coordinates> <product id 1> <quantity> <product id 2> <quantity> ...
	public static Request parse(String input){
		int index = input.indexOf(' ');
		String requestType = input.substring(0, index);
		switch(requestType){
		case("delivery") : return parseDelivery(input);
		case("supply") : return parseSupply(input);
		}
		return null;
	}
	public static Request parseDelivery(String input){
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
			
			result.products.clear();
			
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
	
//	supply <id> <timestamp YYYY-MM-DD HH:MM> <product name 1> <product weight> <quantity> <product name 2> <product weight> <quantity>
//
//	e.g. "supply 5 2016-10-25 12:32 tomato 5 100 potatoes 6 50 cheese 2 4"
	//delivery <id> <timestamp> <target coordinates> <product id 1> <quantity> <product id 2> <quantity> ...	
	//delivery 4 2016-10-25 12:31 420,369 1 100 2 20 3 30 4 100
	public static Request parseSupply(String input){
		Request result = new Request();
		try{
			
			String[] splitted = input.split(" ");
			result.setID(Integer.parseInt(splitted[1]));
			result.setTimestamp(splitted[2] + splitted[3]);
			
			result.supply.clear();
			int size = splitted.length;
			for (int i=4;i<size;i+=2){
				
				int id = Integer.parseInt(splitted[i]);
				int quantity = Integer.parseInt(splitted[i+1]);
				result.supply.put(id,new SupplyRequestHelper(id, quantity));
			}
		}catch (IllegalArgumentException e){
			e.printStackTrace();
		}
		return result;
	}
	
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
