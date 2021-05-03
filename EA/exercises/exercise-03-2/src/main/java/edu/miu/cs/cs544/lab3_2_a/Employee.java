package edu.miu.cs.cs544.lab3_2_a;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "employee")
public class Employee { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String name;
	private Integer employeeNumber; 
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	public Employee(String name, Integer employeeNumber, Department department) {
		this.name = name;
		this.employeeNumber = employeeNumber;
		this.department = department;
	} 
} 