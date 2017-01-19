package delivery.system.drone;

public class Product {
	private int ID;
	private String name;
	private float weight;
	
	public Product(int ID, String name, float weight){
		this.ID=ID;
		this.name=name;
		this.weight=weight;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public float getWeight() {
		return weight;
	}

}
