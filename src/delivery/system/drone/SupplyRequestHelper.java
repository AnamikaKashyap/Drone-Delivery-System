package delivery.system.drone;

public class SupplyRequestHelper {
	private int ID;
	private int quantity;
	
	public SupplyRequestHelper(int id, int quantity){
		this.setID(id);
		this.quantity=quantity;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
}
