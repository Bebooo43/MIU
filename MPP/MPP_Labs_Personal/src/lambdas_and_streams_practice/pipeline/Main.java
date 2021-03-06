package lambdas_and_streams_practice.pipeline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lambdas_and_streams_practice.quizclasses.Employee;
import lambdas_and_streams_practice.quizclasses.EmployeeTestData;
import lambdas_and_streams_practice.quizclasses.TraderTransactTestData;
import lambdas_and_streams_practice.quizclasses.Transaction;
import lambdas_and_streams_practice.quizclasses.Pair;
import lambdas_and_streams_practice.quizclasses.Trader;

/** USE STREAM PIPELINES TO SOLVE THE PROBLEMS HERE */
public class Main {
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		System.out.println("Sample Problem - solved");
		List<Employee> sampleData = EmployeeTestData.getList();
		//SAMPLE: Create a stream pipeline that does the following:
		//Print all Employee records for which name has length > 5 and birth year is > 1970
		// Expected output: [<name: Timothy salary: 50000 year of birth: 1996>, <name: Ricardo salary: 50000 year of birth: 1988>]
		List<Employee> result = sampleData.stream()
							        .filter(e -> e.getName().length() > 5)
							        .filter(e -> e.getYearOfBirth() > 1970)
							        .collect(Collectors.toList());
		System.out.println(result);
				
		prob1();
		prob2();
		prob3();
	}
	
	//Create a stream pipeline that obtains a list of
	//all name/salary pairs extracted from the list of Employees
	//for which salary is at least 60000 but less than 130000, in ascending
	//order of name, then descending order of salary.
	//Then, print the list to the console.
	// Expected output: 60k - 130k earners, sorted: [(Andy, 60000.0), (Joe, 100000.0), (Joe, 90000.0)]
	public static void prob1() {
		//use this list
		List<Employee> list = EmployeeTestData.getList();
		List<Pair> result = list.stream()
				.filter(e -> e.getSalary() >= 60000 && e.getSalary() < 130000)
				.sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary, Comparator.reverseOrder()))
				.map(e -> new Pair(e.getName(), e.getSalary()))
				.collect(Collectors.toList());
		
		System.out.println(result);
	}
	
	//Create a stream pipeline to find all transactions from year 2011 
	//and sort them by value (small to high), and print to console
	//(Note: there is an instance variable "value" in Transaction)
	// Expected output: [{Trader:Brian in Cambridge, year: 2011, value:300}, {Trader:Raoul in Cambridge, year: 2011, value:400}]
	public static void prob2() {
		//use this list	
		List<Transaction> list = TraderTransactTestData.getTransactions();
		List<Transaction> result = list.stream()
									.filter(t -> t.getYear() == 2011)
									.sorted(Comparator.comparing(Transaction::getValue))
									.collect(Collectors.toList());
		System.out.println(result);
	}
	
	// Create a stream pipeline to find all traders from Cambridge, 
	// sort them by name, and print to console
	// Expected output: [Trader:Alan in Cambridge, Trader:Brian in Cambridge, Trader:Raoul in Cambridge]
	public static void prob3() {
		//Use this list
		List<Transaction> list = TraderTransactTestData.getTransactions();  
		List<Trader> result = list.stream()
							.filter(t -> t.getTrader().getCity().equals("Cambridge"))
							.distinct()
							.map(Transaction::getTrader)
							.sorted(Comparator.comparing(Trader::getName))
							.collect(Collectors.toList());
		System.out.println(result);
	                
	}
}
