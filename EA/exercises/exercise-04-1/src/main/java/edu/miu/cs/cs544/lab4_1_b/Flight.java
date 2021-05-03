package edu.miu.cs.cs544.lab4_1_b;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer flightNumber;
	@Column(name = "flight_from")
	private String from;
	@Column(name = "flight_to")
	private String to;
	private LocalDate date;
	
	public Flight(Integer flightNumber, String from, String to, LocalDate date) {
		super();
		this.flightNumber = flightNumber;
		this.from = from;
		this.to = to;
		this.date = date;
	}
}
