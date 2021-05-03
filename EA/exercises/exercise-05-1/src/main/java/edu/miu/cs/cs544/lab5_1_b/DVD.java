package edu.miu.cs.cs544.lab5_1_b;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.miu.cs.cs544.lab5_1_a.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "dvd")
@DiscriminatorValue("dvd")
public class DVD extends Product{ 
	
	private String genre;
	
	public DVD(String name, String description,String genre) {
		super(name, description);
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "DVD [genre=" + genre + " , " + super.toString() + "]";
	}
	
	
} 