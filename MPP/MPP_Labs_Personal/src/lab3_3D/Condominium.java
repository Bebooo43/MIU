package lab3_3D;

public class Condominium extends Property{

	private int floors;
	
	public Condominium(int floors) {
		this.floors = floors;
	}
	
	public int getFloors() {
		return floors;
	}
	public void setFloors(int floors) {
		this.floors = floors;
	}
	@Override
	public double rent() {
		return 500 * floors;
	}
}
