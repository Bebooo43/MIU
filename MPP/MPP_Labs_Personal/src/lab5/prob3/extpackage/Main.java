package lab5.prob3.extpackage;

import java.time.LocalDate;

import lab5.prob3.Customer;
import lab5.prob3.CustomerOrderFactory;
import lab5.prob3.Order;

public class Main {
	public static void main(String[] args) {
		Customer cust = CustomerOrderFactory.createCustomer("Bob");
		
		Order order = CustomerOrderFactory.newOrder(cust, LocalDate.now());
		CustomerOrderFactory.addItem(order, "Shirt");
		CustomerOrderFactory.addItem(order, "Laptop");

		
		order = CustomerOrderFactory.newOrder(cust, LocalDate.now());
		CustomerOrderFactory.addItem(order, "Pants");
		CustomerOrderFactory.addItem(order, "Knife set");

		System.out.println(cust.getOrders());
	}
}

		
