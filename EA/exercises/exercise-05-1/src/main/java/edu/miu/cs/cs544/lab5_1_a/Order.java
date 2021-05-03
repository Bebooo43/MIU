package edu.miu.cs.cs544.lab5_1_a;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@Entity
@Table(name = "_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long orderId;
	private LocalDate date;
	@ManyToOne
	private Customer customer;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "order_id")
	private List<OrderLine> orderLines;
	
	public Order(LocalDate date, Customer customer) {
		this.date = date;
		this.customer = customer;
		this.orderLines = new ArrayList<>();
	}
	
	public void addOrderLine(OrderLine newOrderLine) {
		orderLines.add(newOrderLine);
	}
}
