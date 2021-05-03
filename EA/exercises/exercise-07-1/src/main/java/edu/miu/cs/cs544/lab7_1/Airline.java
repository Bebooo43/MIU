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
@Table(name = "airline")
public class Airline { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id; 
	private String name;
	@OneToMany(mappedBy = "airline")
	@OrderBy("flightnr")
	private List<Flight> flights;
	
	public Airline(String name) {
		super();
		this.name = name;
		this.flights = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
} 