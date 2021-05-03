package edu.miu.cs.cs544.lab5_1_a;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@Entity
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type")
@Table(name = "product")
public class Product { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id; 
	private String name;
	private String description;
	
	public Product(String name, String description) {
		this.name = name;
		this.description = description;
	}
} 