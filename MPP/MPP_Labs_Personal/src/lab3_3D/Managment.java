package lab3_3D;

import java.util.List;

public class Managment {

	public List<Property> findPropertiesByCity(String city){
		return null;
	}
	
	public static double computeTotalRentAllProperties(Property[] properties) {
		double totalRent = 0;
		for (Property property : properties) {
			totalRent += property.rent();	
		}
		return totalRent;
	}
}
