package lab4_E.launch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lab4_E.Account;
import lab4_E.Admin;
import lab4_E.CheckingAccount;
import lab4_E.Employee;
import lab4_E.SavingsAccount;

/** This class tests the code package */
public class Main {
    
	public static void main(String[] args) {
		Account[] someCheckingAccounts = new CheckingAccount[2];
		someCheckingAccounts[0] = new CheckingAccount("231-471", 25.00, 100.0);
		someCheckingAccounts[1] = new CheckingAccount("446-973", 25.00, 200.0);
		Account[] someSavingsAccounts = new SavingsAccount[3];
		someSavingsAccounts[0] = new SavingsAccount("44-8123", 0.03, 200.0);
		someSavingsAccounts[1] = new SavingsAccount("21-9672", 0.03, 200.0);
		someSavingsAccounts[2] = new SavingsAccount("68-0902", 0.04, 600.0);
		
		
		Employee e1 = new Employee("Joe");
		Employee e2 = new Employee("Ralph");
		Employee e3 = new Employee("Tom");
		
			e1.addAccount(someCheckingAccounts[0]);
			e1.addAccount(someSavingsAccounts[0]);
			e2.addAccount(someCheckingAccounts[1]);
			e2.addAccount(someSavingsAccounts[1]);
			e3.addAccount(someSavingsAccounts[2]);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		System.out.println(Admin.computeUpdatedBalanceSum(employees));
		
		
	}
     
}
