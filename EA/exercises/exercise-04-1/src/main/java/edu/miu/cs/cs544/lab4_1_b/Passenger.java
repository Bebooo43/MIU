package edu.miu.cs.cs544.lab4_1_b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@Entity
@ToString
@Table(name = "passenger")
public class Passenger { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String name; 
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "passenger_id")
	private List<Flight> flights;
	
	public Passenger(String name, Flight flight) {
		this.name = name;
		this.flights = new ArrayList<>(Arrays.asList(flight));
	}
	
	public void addFlight(Flight newFlight) {
		flights.add(newFlight);
	}
} 