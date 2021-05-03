package edu.miu.cs.cs544.lab7_1;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "airport")
public class Airport { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id; 
	private String name;
	private String city;
	private String country;
	private String airportCode;
	@OneToMany(mappedBy = "origin")
	private Set<Flight> origins;
	@OneToMany(mappedBy = "destination")
	private Set<Flight> destinations;
	
	public Airport(String name, String city, String country, String airportCode) {
		this.name = name;
		this.city = city;
		this.country = country;
		this.airportCode = airportCode;
		origins = new HashSet<>();
		destinations = new HashSet<>();
	}
} 