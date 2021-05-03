package edu.miu.cs.cs544.lab5_1_a;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "customer")
public class Customer { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	private Long id; 
	private String firstName;
	private String lastName; 
	@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<Order> orders;
	
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.orders = new HashSet<>();
	} 
	
	public void addOrder(Order order) {
		orders.add(order);
	}
} 