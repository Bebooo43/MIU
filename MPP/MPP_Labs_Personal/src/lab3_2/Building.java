package lab3_2;

import java.util.*;

public class Building {

	private double maintenance;
	private List<Apartment> apartaments;
	double sum;
	
	public Building() {apartaments = new ArrayList<Apartment>();}
	public Building(double maintenance, int maxSize) {
		this.maintenance = maintenance;
		apartaments = new ArrayList<Apartment>();//Arrays.asList(new Apartment[maxSize]);
	}
	
	public double getProfit() {
		apartaments.stream().forEach((apt) -> { 
			sum += apt.getRent();
		});;
		return sum - maintenance;
	}
	
	public void addApartment(Apartment a) {
		apartaments.add(a);
	}
	
	public double getMaintenance() {
		return maintenance;
	}
	
	public void setMaintenance(double maintenance) {
		this.maintenance = maintenance;
	}
	
	public List<Apartment> getApartaments() {
		return apartaments;
	}
	public void setApartaments(List<Apartment> apartaments) {
		this.apartaments = apartaments;
	}
	
	@Override
	public String toString() {
		return String.format("The profit of this building is %s", getProfit());
	}
}
