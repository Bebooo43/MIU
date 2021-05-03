package cs544.lab2.exercise1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter @Setter
@Entity
@Table(name = "car")
public class Car {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private Integer year;
	private Double price;
	
	public Car(String brand, Integer year, Double price) {
		super();
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
}
