package delivery.system.drone;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Warehouse implements WarehouseManagerInterface {
	private Coordinates coordinates;
	private Map<Integer, Product> products;
	private Map<Integer, Integer> quantities;

	public Warehouse() {
		products = new HashMap<>();
		quantities = new HashMap<>();
		coordinates = new Coordinates();
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Map<Integer, Product> getProducts() {
		return products;
	}

	public void addProduct(Product product, int quantity) {
		products.put(product.getID(), product);
		quantities.put(product.getID(), quantity);
	}

	@Override
	public RequestResult hasProducts(DeliveryRequest request) {
		RequestResult result = new RequestResult();
		result.setExecutable(true);
		result.setWarehouseCoordinates(this.coordinates);
		result.setTargetCoordinates(request.getTarget_coordinates());
		for (Map.Entry<Integer, Integer> entry : request.getProducts().entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if (products.get(key) == null) {
				result.setLog("There is no product with ID " + key);
				result.setExecutable(false);
				break;
			}
			if (quantities.get(key) < value) {
				result.setLog("Warehouse is missing " + products.get(key).getName());
				result.setExecutable(false);
				break;
			}
			result.addWeigth(value * products.get(key).getWeight());
		}
		return result;
	}

	public void AcceptSupply(DeliveryRequest request) {
		for (Entry<Integer, SupplyRequestHelper> entry : request.getSupply().entrySet()) {
			int key = entry.getKey();
			SupplyRequestHelper value = entry.getValue();
			if (quantities.get(key) != null) {
				// TODO: FIX THIS UGLY CODE !
				int new_value = entry.getValue().getQuantity() + quantities.get(key);
				quantities.put(key, new_value);
			}
			// We will need this one day, I promise.
			// else {
			// int quantity = entry.getValue().getQuantity();
			// int id = entry.getValue().getID();
			// int weight = entry.getValue().getWeight();
			// quantities.put(key, quantity);
			// Product new_product = new Product(ID, name, weight)
			// }
		}
	}

}
