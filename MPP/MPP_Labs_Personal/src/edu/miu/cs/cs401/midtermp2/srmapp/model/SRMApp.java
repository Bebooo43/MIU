package edu.miu.cs.cs401.midtermp2.srmapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SRMApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Supplier> supplies = new ArrayList<>();
		
		supplies.add(new Supplier("S101", "United Farms", 3109128478L, 1.25, "Bananas", LocalDate.of(2021, 02, 14), 480));
		supplies.add(new Supplier("S101", "United Farms", 2910019138L, 1.09, "Apples", LocalDate.of(2021, 01, 31),525));
		supplies.add(new Supplier("S102", "ElSegundo Agro", 7281100287L, 2.49, "Avocados", LocalDate.of(2021, 02, 11), 164));
		supplies.add(new Supplier("S103", "La Boulangerie", 2102799156L, 1.89, "Brioche", LocalDate.of(2021, 01, 04), 96));
			 
		supplies.stream().forEach(s -> {System.out.println(s);});
		
	}

}
