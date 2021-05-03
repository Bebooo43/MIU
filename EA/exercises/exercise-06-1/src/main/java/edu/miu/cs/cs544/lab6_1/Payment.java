package edu.miu.cs.cs544.lab6_1;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class Payment { 

	private String paydate;
	private double amount;
	
	public Payment(String paydate, double amount) {
		super();
		this.paydate = paydate;
		this.amount = amount;
	}
	
	
} 