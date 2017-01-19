package delivery.system.drone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;

public class Main {

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		warehouse.setCoordinates(new Coordinates(42,42));
		warehouse.addProduct(new Product(1,"aaa",15), 100);
		warehouse.addProduct(new Product(2,"bbb",20), 100);
		warehouse.addProduct(new Product(3,"ccc",25), 100);
		warehouse.addProduct(new Product(4,"ddd",30), 100);
		
		DroneManager Asen = new DroneManager();
		//int ID, int battery_units, float capacity, int charging_units
		for (int i=1;i<=30;i++){
			Asen.addDrone(new Drone (i,500*i,300,10));
		}
		
		//delivery 4 2016-10-25 12:31 420,369 1 100 2 20 3 30 4 100
		Scanner scanner = new Scanner(System.in);
		String req = scanner.nextLine();
		System.out.println(req);
		Request request = Request.parse(req);
		System.out.println(request);
		scanner.close();
		RequestResult result = warehouse.hasProducts(request);
		
		System.out.println(result);
		System.out.println(Coordinates.calculateDistance(result.getTargetCoordinates(), result.getWarehouseCoordinates()));
		System.out.println(Asen.hasDrones(result));
		System.out.println(Asen);

	}

}
