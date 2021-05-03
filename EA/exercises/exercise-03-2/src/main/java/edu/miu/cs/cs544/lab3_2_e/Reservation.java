package edu.miu.cs.cs544.lab3_2_e;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@Entity
@ToString
@Table(name = "reservation_e")
public class Reservation { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private LocalDate date;
	@ManyToOne
	private Book book;
	
	public Reservation(LocalDate date, Book book) {
		this.date = date;
		this.book = book;
	} 
} 