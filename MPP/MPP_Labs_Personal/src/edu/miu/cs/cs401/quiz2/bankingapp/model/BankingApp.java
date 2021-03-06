package edu.miu.cs.cs401.quiz2.bankingapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankingApp {

	public static void main(String[] args) {

		Customer c1 = new Customer("C19102","Anna Lynn Smith", LocalDate.of(1977 , 1, 31), 2801011119L, 10095.50);
		Customer c2 = new Customer("C24499","Bob Jones", LocalDate.of(1989 , 12, 7), 2911111901L, 5590.35);
		List<Customer> list = new ArrayList<>();
		list.add(c1);list.add(c2);
		
		list.stream().forEach((c) -> System.out.println(c));
	}

}
