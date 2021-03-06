package lab10.prob5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.javafx.binding.SelectBinding.AsString;

public class Main {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(
						  new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));
		
	             
		Main main = new Main();
		main.printEmps(main.asString(emps));
	}
	
	public String asString(List<Employee> emps){
		return emps.stream()
			    .filter(e -> salaryGreaterThan100000(e))
			    .filter(e -> lastNameAfterM(e))
			    .map(e -> fullName(e))
			    .sorted()
			    .collect(Collectors.joining(", "));
	}
	
	public boolean salaryGreaterThan100000(Employee e){
		return e.getSalary() > 100000;
	}
	
	public boolean lastNameAfterM(Employee e){
		return e.getLastName().charAt(0) > 'M';
	}
	
	void printEmps(String string){
		System.out.println(string);
	}
	
	public static String fullName(Employee e) {
		return e.getFirstName() + " " + e.getLastName();
	}

}
