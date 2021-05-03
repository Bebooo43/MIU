package edu.miu.cs.cs544.lab3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "owner")
public class Owner { 
	
	@Id
	@GeneratedValue
	private Long id; 
	private String name; 
	private String address;
	
	public Owner(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	} 
} 