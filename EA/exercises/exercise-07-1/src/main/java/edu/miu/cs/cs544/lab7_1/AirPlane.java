package edu.miu.cs.cs544.lab7_1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "airplane")
public class AirPlane { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id; 
	private String serialnr;
	private String model;
	private Integer capacity;
	@OneToMany(mappedBy = "airplane")
	@OrderBy("flightnr")
	private List<Flight> flights;
	
	public AirPlane(String serialnr, String model, Integer capacity) {
		super();
		this.serialnr = serialnr;
		this.model = model;
		this.capacity = capacity;
		this.flights = new ArrayList<>();
	}
} 