package delivery.system.drone;

import java.util.Scanner;

public class InitializerClass {
	private RequestManager requestManager;

	public static Warehouse setWarehouse() {
		Warehouse warehouse = new Warehouse();
		warehouse.setCoordinates(new Coordinates(42,42));
		warehouse.addProduct(new Product(1,"aaa",15), 100);
		warehouse.addProduct(new Product(2,"bbb",20), 100);
		warehouse.addProduct(new Product(3,"ccc",25), 100);
		warehouse.addProduct(new Product(4,"ddd",30), 100);
		return warehouse;
	}
	
	public static DroneManager setDroneManager() {
		DroneManager Asen = new DroneManager();
		for (int i=1;i<=30;i++){
			Asen.addDrone(new Drone (i,500*i,300,10));
		}
		return Asen;
	}
	
	public InitializerClass() {
		this.requestManager = new RequestManager(setWarehouse(), setDroneManager());
	}
	
	public static void main(String[] args) {
		//example:
		//delivery 4 2016-10-25 12:31 420,369 1 100 2 20 3 30 4 100
		InitializerClass init = new InitializerClass();
				while (true) {
					Scanner scanner = new Scanner(System.in);
					String req = scanner.nextLine();
					System.out.println(req);
					Request request = Request.parse(req);
					System.out.println(request);
					RequestResult result = init.requestManager.warehouseHasProducts(request);
					
					System.out.println(result);
					System.out.println(Coordinates.calculateDistance(result.getTargetCoordinates(), result.getWarehouseCoordinates()));
					System.out.println(init.requestManager.droneManagerHasDrones(result));
				}
	}

}
