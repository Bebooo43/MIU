package edu.miu.cs.cs544.lab6_1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@Entity
@ToString
@Table(name = "doctor")
public class Doctor { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id; 
	private String doctorType;
	private String firstName;
	private String lastName;
	
	public Doctor(String doctorType, String firstName, String lastName) {
		this.doctorType = doctorType;
		this.firstName = firstName;
		this.lastName = lastName;
	}
} 