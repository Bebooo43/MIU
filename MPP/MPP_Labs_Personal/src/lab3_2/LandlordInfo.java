package lab3_2;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {

	List<Building> buildings;
	
	public LandlordInfo() {
		buildings = new ArrayList<Building>();
	}
	
	public void addBuilding(Building b) {
		buildings.add(b);
	}
	
	public double calcProfits() {
		double sum = 0;
		for (Building building : buildings) {
			sum+= building.getProfit();
		}
		return sum;
	}
}
