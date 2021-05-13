package edu.miu.cs.cs544.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Customer")
@NoArgsConstructor @Getter @Setter 
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Length(max = 30)
	private String fname;
	@Length(max = 30)
	private String lname;
	@Past
	private LocalDate birthDate;
	@Email
	private String email;
	
	public Customer(@Length(max = 30) String fname, @Length(max = 30) String lname, @Past LocalDate birthDate,@Email String email) {
		this.fname = fname;
		this.lname = lname;
		this.birthDate = birthDate;
		this.email = email;
	}
}
