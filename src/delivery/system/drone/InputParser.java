package delivery.system.drone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputParser {

	public static DeliveryRequest readRequest() {
		try (Scanner scanner = new Scanner(System.in)) {
			String requestType = scanner.next();
			String requestPayload = scanner.nextLine();
			System.out.println(requestPayload);
			DeliveryRequest request = parse(requestType, requestPayload);
			System.out.println(request);
		}

		return null;
	}

	private static DeliveryRequest parse(String type, String payload) {
		switch (type) {
		case ("delivery"):
			return parseDelivery(payload);
		case ("supply"):
			//TODO remove comment when implemented return parseSupply(payload);
		}
		return null; // TODO throw exception type not recognized
	}

	// <id> <timestamp> <target coordinates> <product id 1> <quantity> <product
	// id 2> <quantity>
	private static DeliveryRequest parseDelivery(String input) {

		String[] splitted = input.split("\\s+");
		Integer id = Integer.valueOf(splitted[0]);
		String timestamp = splitted[1] + " " + splitted[2];
		String[] coordinates = splitted[3].split(",");
		Coordinates coordinate = new Coordinates(Integer.valueOf(coordinates[0]), 
				Integer.valueOf(coordinates[1]));

		int currentPosition = 4;
		int productCount = (splitted.length - currentPosition ) / 2;
		Map<Integer, Integer> idToQuantity = new HashMap<Integer, Integer>();
		for (int i = 0; i < productCount; i++) {
			int productId = Integer.parseInt(splitted[currentPosition + i]);
			int productQuantity = Integer.parseInt(splitted[currentPosition + i + 1]);
			idToQuantity.put(productId, productQuantity);
		}
		
		DeliveryRequest request = new DeliveryRequest(id, timestamp, coordinate, idToQuantity);
		return request;
	}

	// supply <id> <timestamp YYYY-MM-DD HH:MM> <product name 1> <product
	// weight> <quantity> <product name 2> <product weight> <quantity>
	//
	// e.g. "supply 5 2016-10-25 12:32 tomato 5 100 potatoes 6 50 cheese 2 4"
	// delivery <id> <timestamp> <target coordinates> <product id 1> <quantity>
	// <product id 2> <quantity> ...
	// delivery 4 2016-10-25 12:31 420,369 1 100 2 20 3 30 4 100
	/* fix implementation
	private static SupplyRequest parseSupply(String input) {
		DeliveryRequest result = new DeliveryRequest();
		try {

			result.supply.clear();
			String[] splitted = input.split(" ");
			result.setID(Integer.parseInt(splitted[1]));
			result.setTimestamp(splitted[2] + splitted[3]);

			int size = splitted.length;
			for (int i = 4; i < size; i += 2) {

				int id = Integer.parseInt(splitted[i]);
				int quantity = Integer.parseInt(splitted[i + 1]);
				result.supply.put(id, new SupplyRequestHelper(id, quantity));
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return result;
	}*/

}
