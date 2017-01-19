package delivery.system.drone;

public class Coordinates {
	@Override
	public String toString() {
		return "Coordinates [x=" + x + ", y=" + y + "]";
	}

	private int x;
	private int y;
	
	public Coordinates(){
		this.setX(0);
		this.setY(0);
	}
	
	public Coordinates(int x,int y){
		this.setX(x);
		this.setY(y);
	}
	
	public Coordinates(Coordinates other){
		this.x=other.x;
		this.y=other.y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public static  double calculateDistance(Coordinates first,Coordinates second){
		return Math.sqrt((first.x-second.x)*(first.x-second.x) +(first.y-second.y)*(first.y-second.y));
	}
}
