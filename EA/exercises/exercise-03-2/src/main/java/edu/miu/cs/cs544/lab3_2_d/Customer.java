package edu.miu.cs.cs544.lab3_2_d;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(cascade = CascadeType.PERSIST)
	@OrderBy("date DESC")
	@JoinColumn(name = "customer_id")
	private Set<Reservation> reservations;
	
	public Customer(String name) {
		this.name = name;
		this.reservations = new HashSet<>();
	}
	
	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}
}
