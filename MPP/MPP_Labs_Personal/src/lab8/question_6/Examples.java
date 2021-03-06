package lab8.question_6;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class Examples {

	// Method reference type: Class::instanceMethod
	//A. (Employee e) -> e.getName()
	Function<Employee, String> e = Employee::getName; 
	//B. (Employee e,String s) -> e.setName(s)
	BiConsumer<Employee, String> employeeNameSetter = Employee::setName;
	//C. (String s1,String s2) -> s1.compareTo(s2)
	BiFunction<String,String, Integer> f2 = String::compareTo;
	Comparator<String> f2Correct = String::compareTo;
	//D. (Integer x,Integer y) -> Math.pow(x,y)	
	BiFunction<Integer, Integer, Double> pow = Math::pow;
	//E. (Apple a) -> a.getWeight()
	Function<Apple, Double> apple = Apple::getWeight;
	//F. (String x) -> Integer.parseInt(x);
	Function<String, Integer> f = Integer::parseInt;
	// -> IntFunction<String> intFuc = Integer::parseInt;
	//G. EmployeeNameComparator comp = new EmployeeNameComparator();
	//(Employee e1, Employee e2) -> comp.compare(e1,e2)
	EmployeeNameComparator emp = new EmployeeNameComparator();
	BiFunction<Employee, Employee, Integer> bfuncEmployee = emp::compare;
	
	
	void evaluator() {
		System.out.println(e.apply(new Employee("Teste")));
	}
	
	public static void main(String[] args) {
		Examples examples = new Examples();
		examples.evaluator();
	}
}

class Employee{
	private String name;
	
	public Employee(String name) {
		this.name = name;// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class Apple{
	private Double weight;
	
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
}

class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
}



