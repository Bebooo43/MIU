package edu.miu.cs.cs544.lab7_1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String flightnr;
	private LocalDate departureDate;
	private LocalTime departureTime;
	private LocalDate arrivalDate;
	private LocalTime arrivalTime;
	@ManyToOne
	private Airline airline;
	@ManyToOne
	private AirPlane airplane;
	@ManyToOne
	private Airport origin;
	@ManyToOne
	private Airport destination;
	
	public Flight(String flightnr, LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate,
			LocalTime arrivalTime, Airline airline, AirPlane airplane, Airport origin, Airport destination) {
		
		this.flightnr = flightnr;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.airline = airline;
		this.airplane = airplane;
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public String toString() {
		//formating data and time
		String formatedDepartureDate = departureDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
		String formatedArrivalDate = arrivalDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.US);
	    
		StringBuilder builder = new StringBuilder();
		builder.append(flightnr + " ");
		builder.append(origin.getCity()+" "+formatedDepartureDate +" "+departureTime.format(timeFormatter)+ " ");
		builder.append(destination.getCity()+" "+formatedArrivalDate+" "+arrivalTime.format(timeFormatter));
		
		return builder.toString(); 
	}

	
}
