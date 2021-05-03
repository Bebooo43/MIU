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
@Table(name = "book")
@DiscriminatorValue("book")
public class Book extends Product{ 
	
	private String title;

	public Book(String name, String description, String title) {
		super(name, description);
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", " + super.toString() + "]";
	}
	
	
	
} 