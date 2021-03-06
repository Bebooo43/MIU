package lab8.question_2a_comparator;

import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		EmployeeSalaryComparator salaryComparator = new EmployeeSalaryComparator();
		if(e1.equals(e2)) return 0;
		else if(e1.name.compareTo(e2.name) == 1 || 
				(e1.name.compareTo(e2.name) == 0 && salaryComparator.compare(e1, e2) == 1)) return 1;
		else return -1;
	}
}
