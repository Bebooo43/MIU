package edu.miu.cs.cs544.lab3_2_f;

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
@Table(name = "employee_f")
public class Employee { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String name;
	private Integer employeeNumber; 
	@ManyToOne
	private Department department;
	@ManyToOne
	private Office office;
	
	public Employee(String name, Integer employeeNumber, Department department, Office office) {
		this.name = name;
		this.employeeNumber = employeeNumber;
		this.department = department;
		this.office = office;
	} 
} 