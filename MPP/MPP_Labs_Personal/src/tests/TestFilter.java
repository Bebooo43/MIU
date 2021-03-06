package tests;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
	String name;
	double salary;
	long id;

	public Employee(String name, long id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	String genNextName() {
		return "Emp-" + (this.id + 1);
	}

	double genNextSalary() {
		return new Random().nextDouble() * 1000000;
	}

	long genNextId() {
		return this.id + 1;
	}

	@Override
	public String toString() {
		return this.id + " " + this.name + " " + this.salary + "\n";
	}
}

public class TestFilter {
	public static void main(String[] args) {
		List<Employee> employees = createDummyEmployee(10000000l);
		System.out.println("created");
		List<Employee> emps = null;
		long time = 0;
		for (int i = 0; i < 100; i++) {
			long startTime = System.currentTimeMillis(); //reading start time 
//			emps = employees.stream()
//					.filter((Employee e) -> e.name.endsWith("999") && e.salary > 10000 && e.id % 2 == 1)
//					.collect(Collectors.toList());
			
			 emps = employees.stream()
					.filter(e -> e.name.endsWith("999"))
					.filter(e -> e.salary > 10000)
					.filter(e -> e.id % 2 == 1)
					.collect(Collectors.toList());
			time += System.currentTimeMillis() - startTime; // adding time taken to time
		}
		time/=100; // calculating average of this time
		System.out.println("Took "+ time + " ns");
		System.out.println("Found "+ emps.size() + " Records");
		
	}

	public static List<Employee> createDummyEmployee(long n) {
		Employee e1 = new Employee("Emp-1", 1l, 1.0);
		return Stream.iterate(e1, (Employee e) -> new Employee(e.genNextName(), e.genNextId(), e.genNextSalary()))
				.limit(n).collect(Collectors.toList());
	}
}
