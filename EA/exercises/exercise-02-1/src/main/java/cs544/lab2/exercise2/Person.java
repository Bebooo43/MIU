package cs544.lab2.exercise2;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter @Setter
public class Person {

	private int id; 
	private String firstname; 
	private String lastname; 
	private LocalDate dateofbirth;
	
	public Person(String firstname, String lastname, LocalDate dateofbirth) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
	}
}
