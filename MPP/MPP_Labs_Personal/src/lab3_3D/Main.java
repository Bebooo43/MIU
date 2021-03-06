package lab3_3D;

public class Main {

	public static void main(String[] args) {
		Property[] properties = { new House(9000), new Condominium(2), new Trailer(new Address("Street", "city", "state", 222, null)) };
		double totalRent = Managment.computeTotalRentAllProperties(properties);
		System.out.println(totalRent);
	}

}
