package delivery.system.drone;

public class Factory {

	public static Warehouse createWarehouse() {
		Warehouse warehouse = new Warehouse();
		warehouse.setCoordinates(new Coordinates(42,42));
		warehouse.addProduct(new Product(1,"aaa",15), 100);
		warehouse.addProduct(new Product(2,"bbb",20), 100);
		warehouse.addProduct(new Product(3,"ccc",25), 100);
		warehouse.addProduct(new Product(4,"ddd",30), 100);
		return warehouse;
	}
	
	public static DroneManager createDroneManager() {
		DroneManager Asen = new DroneManager();
		for (int i=1;i<=30;i++){
			Asen.addDrone(new Drone (i,500*i,300,10));
		}
		return Asen;
	}
	
	public static RequestManager createRequestManager(Warehouse warehouse, DroneManager droneManager) {
		return new RequestManager(warehouse, droneManager);
	}
	
	/*
	public static void main(String[] args) {
		//example:
		//delivery 4 2016-10-25 12:31 420,369 1 100 2 20 3 30 4 100
		Factory init = new Factory();
				while (true) {
					
					RequestResult result = init.requestManager.warehouseHasProducts(request);
					System.out.println(result);
					System.out.println(Coordinates.calculateDistance(result.getTargetCoordinates(), result.getWarehouseCoordinates()));
					System.out.println(init.requestManager.droneManagerHasDrones(result));
				}
	}*/

}
