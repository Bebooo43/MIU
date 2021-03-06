package lab3_3D;

public class Trailer extends Property{

	private Address address;
	public Trailer(Address address) {
		this.address = address;
	}
	
	@Override
	public double rent() {
		return 500;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
