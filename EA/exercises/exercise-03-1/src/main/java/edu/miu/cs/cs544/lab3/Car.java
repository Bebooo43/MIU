package edu.miu.cs.cs544.lab3;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

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
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue
	private Long id;
	private String brand;
	private Integer year;
	private Double price;
	@ManyToOne(cascade = CascadeType.PERSIST)
	//@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Owner owner;
	
	public Car(String brand, Integer year, Double price, Owner owner) {
		super();
		this.brand = brand;
		this.year = year;
		this.price = price;
		this.owner = owner;
	}
}
