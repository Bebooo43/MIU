package edu.miu.cs.cs544.lab5_1_b;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.miu.cs.cs544.lab5_1_a.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "cd")
@DiscriminatorValue("cd")
public class CD extends Product{ 
	
	private String artist;
	
	public CD(String name, String description,String artist) {
		super(name, description);
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "CD [artist=" + artist + ", " + super.toString() + "]";
	} 
	
	
} 