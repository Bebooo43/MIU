package lab3_2;

public class Apartment {

	private double rent;
	
	public Apartment() {
		this(0);
	}
	public Apartment(double rent) {
		this.rent = rent;
	}
	
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
}
