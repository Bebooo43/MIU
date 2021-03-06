package lab3_3D;

public class House extends Property{

	private double lot;
	
	public House(double lot) {
		this.lot = lot;
	}
	
	@Override
	public double rent() {
		return 0.1 * lot;
	}
	public double getLot() {
		return lot;
	}
	public void setLot(double lot) {
		this.lot = lot;
	}
}
