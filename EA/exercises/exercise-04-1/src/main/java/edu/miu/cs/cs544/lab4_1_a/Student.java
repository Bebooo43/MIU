package edu.miu.cs.cs544.lab4_1_a;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Table(name = "student")
public class Student { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	private Long id; 
	private String firstName;
	private String lastName; 
	@OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
	private Set<Laptop> laptops;
	
	public Student(String firstName, String lastName, String laptopBrand,String laptopType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.laptops = new HashSet<>(Arrays.asList(new Laptop(laptopBrand, laptopType, this)));
	} 
} 